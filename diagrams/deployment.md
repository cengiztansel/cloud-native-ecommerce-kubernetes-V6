Docker Topology
## Docker Infrastructure

```mermaid
flowchart LR

Docker[Docker Host]

Nginx[Nginx]
Postgres[(PostgreSQL)]
Redis[(Redis)]
Rabbit[(RabbitMQ)]
Adminer[Adminer]

Docker --> Nginx
Docker --> Postgres
Docker --> Redis
Docker --> Rabbit
Docker --> Adminer
