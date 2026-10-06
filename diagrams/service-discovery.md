Eureka Discovery Flow
## Service Discovery

```mermaid
sequenceDiagram

participant Product
participant Basket
participant UserService
participant Eureka
participant Gateway

Product->>Eureka: Register
Basket->>Eureka: Register
UserService->>Eureka: Register

Gateway->>Eureka: Discover Services

Eureka-->>Gateway: Service Locations
```
