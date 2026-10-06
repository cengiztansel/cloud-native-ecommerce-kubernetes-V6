package com.quantumshop.gatewayservice.filter;
import com.quantumshop.gatewayservice.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("FILTER WORKING");
        String path = request.getRequestURI();

        // Login endpoint serbest
        if (path.startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Kubernetes / monitoring health endpoints serbest
        if (path.startsWith("/actuator")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("JWT token missing");
            return;
        }

        try {
            String token = authHeader.substring(7);
            String username = jwtService.extractUsername(token);
            String role = jwtService.extractRole(token);
            System.out.println("Authenticated user: " + username + " role=" + role);

            // RBAC
            if (path.startsWith("/api/admin") && !"ADMIN".equals(role)) {
                response.setStatus(403);
                response.getWriter().write("ADMIN role required");
                return;
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid JWT");
        }
    }
}
