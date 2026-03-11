# Maxs Pay - Spring Boot Microservices Backend

Production-ready backend architecture scaffold for fintech digital payments by **Maxs Corporation**.

## Services
- config-server
- eureka-server
- api-gateway (routing, JWT validation, logging, rate limiting)
- authentication-service
- user-service
- merchant-service
- payment-service (UPI + Net Banking)
- transaction-service
- webhook-service
- notification-service (Kafka)
- reconciliation-service (scheduler)
- admin-service

## Security
- OAuth2 Resource Server + JWT
- BCrypt password hashing in authentication service
- Role model: ADMIN, MERCHANT, CUSTOMER
- Webhook signature verification component
- Input validation (Jakarta Validation)

## Event-driven Topics
- `payment-created`
- `payment-success`
- `payment-failed`
- `refund-created`
- `settlement-completed`

## Build
```bash
mvn clean package
```

## Deploy
```bash
docker compose -f deployment/docker-compose.yml up --build
```

## Database
Oracle schema is available at `database/oracle-schema.sql`.
