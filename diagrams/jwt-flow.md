JWT Authentication Flow
## JWT Authentication Flow

```mermaid
sequenceDiagram

participant User
participant AuthService
participant Gateway
participant ProductService

User->>AuthService: Login(username,password)

AuthService->>AuthService: Validate User

AuthService-->>User: JWT Token

User->>Gateway: Request + JWT

Gateway->>Gateway: Validate JWT

Gateway->>ProductService: Forward Request

ProductService-->>User: Response
```
