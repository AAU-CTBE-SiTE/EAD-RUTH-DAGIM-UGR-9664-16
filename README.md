# LAB 9: Microservices

Two Spring Boot services that communicate using `RestClient`.

| Service          | Port | Database |
|------------------|------|----------|
| customer_service | 8080 | MongoDB  |
| order_service    | 8081 | MySQL    |

## How they communicate
Each order stores a `customerId` (one order per customer).
The order service uses `RestClient` to get the customer's details from the customer service.

## Run
1. Start MongoDB and MySQL.
2. Set your MySQL password in `order_service/src/main/resources/application.properties`.
3. Run `CustomerServiceApplication`.
4. Run `OrderServiceApplication`.

## Customer endpoints (port 8080)
| Method | URL                 | Action          |
|--------|---------------------|-----------------|
| POST   | /api/customers      | Save customer   |
| GET    | /api/customers      | List customers  |
| GET    | /api/customers/{id} | Get by ID       |
| DELETE | /api/customers/{id} | Delete customer |

## Order endpoints (port 8081)
| Method | URL                               | Action                  |
|--------|-----------------------------------|-------------------------|
| POST   | /api/orders                       | Save order              |
| GET    | /api/orders                       | List orders             |
| GET    | /api/orders/{id}                  | Order with its customer |
| GET    | /api/orders/customer/{customerId} | A customer's order      |

## Sample requests
Customer:
{"id": 1, "name": "Alice", "email": "alice@example.com"}

Order:
{"product": "Laptop", "quantity": 1, "price": 800, "customerId": 1}
