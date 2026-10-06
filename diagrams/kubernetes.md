```mermaid
flowchart TD

Internet

Ingress[Kubernetes Ingress]

Gateway[Gateway Pod]

Product[Product Pod]
Basket[Basket Pod]
User[User Pod]
Auth[Auth Pod]

Postgres[(PostgreSQL)]

Internet --> Ingress

Ingress --> Gateway

Gateway --> Product
Gateway --> Basket
Gateway --> User
Gateway --> Auth

Product --> Postgres
User --> Postgres
Auth --> Postgres
```
