package com.quantumshop.orderservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/api/orders")
    public String hello() {
        return "Order Service is running";
    }
}
