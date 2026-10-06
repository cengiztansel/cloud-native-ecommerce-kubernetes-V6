# High-Level Architecture
## Cloud Native Architecture

```mermaid
flowchart TD

Client[Client Browser]

Gateway[Spring Cloud Gateway]

Eureka[Eureka Discovery]

Auth[Auth Service]
User[User Service]
Product[Product Service]
Basket[Basket Service]

Postgres[(PostgreSQL)]
Redis[(Redis)]
Rabbit[(RabbitMQ)]

Client --> Gateway

Gateway --> Auth
Gateway --> User
Gateway --> Product
Gateway --> Basket

Auth --> Postgres
User --> Postgres
Product --> Postgres

Basket --> Redis

Product --> Rabbit
Basket --> Rabbit
User --> Rabbit

Auth --> Eureka
User --> Eureka
Product --> Eureka
Basket --> Eureka
Gateway --> Eureka
```
