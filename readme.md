# Ecommerce-Price

A **Spring Boot** application/service that provides a REST endpoint for querying price information. The service:

- Accepts the following input parameters: application date, product identifier, and brand identifier.
- Returns the following output data: product identifier, brand identifier, applicable rate, application dates, and final price to apply.

---

## Table of Contents

- [Architecture](#architecture)
- [API First Approach](#api-first-approach)
- [Technologies Used](#technologies-used)
- [API Documentation](#api-documentation)
- [Database Access](#database-access)
- [Testing](#testing)
- [Docker](#docker)

---

## Architecture

The project is built using the **Hexagonal Architecture** pattern, also known as **Ports and Adapters**, ensuring clear separation of concerns and modularity. It includes the following layers:

- **Domain Layer:** Contains the core business logic and the `Price` entity.
- **Application Layer:** Implements application-specific use cases and orchestrates interactions between the domain and infrastructure layers.
- **Infrastructure Layer:** Provides implementations for external dependencies such as the **H2 database** and utilizes **Specifications** for dynamic filtering.
- **Interface Layer:** Manages requests and responses through APIs generated using **OpenAPI**. In this project, the `PriceControllerApi` serves as the main interface.

---

## API First Approach

This project follows the **API First** development methodology, where the API is designed and documented before implementation. The API contract is defined using **OpenAPI 3.0 (Swagger)** and stored in the file:

src/main/resources/openapi/price-api.yml



### Benefits of the API First Approach:
- **Consistency and Collaboration:** The API contract acts as a single source of truth for all stakeholders, including frontend and backend developers.
- **Parallel Development:** Teams can develop independently using the API specification as a guide.
- **Comprehensive Testing:** Mock servers and contract tests can be implemented early in the development lifecycle.

### Working with the OpenAPI Specification:
- The OpenAPI file defines all endpoints, request parameters, and response schemas.
- Swagger UI is used to automatically generate interactive documentation for the API.
- Developers and testers can utilize tools like **Postman** or **Swagger Codegen** to consume or simulate the API.

---

## Technologies Used

- **Java 11** - Programming language.
- **Spring Boot** - Framework for building the application.
- **H2 Database** - In-memory database for testing and development.
- **OpenAPI (Swagger)** - For API documentation and design.
- **JUnit, Mockito** - Testing frameworks.
- **JPA (Java Persistence API)** - For database access.
- **Postman** - API testing.
- **Docker** - Containerization.

---

## API Documentation

The API is documented using **Swagger UI**. After running the application, you can access the documentation locally:

http://localhost:8080/swagger-ui/index.html#/Price



This documentation provides details about all available endpoints, parameters, and response schemas.

---
## Database Access

The project uses an in-memory **H2 Database** for testing and development purposes. You can access the H2 Console to view and manage the database at runtime.

H2 Console URL : http://localhost:8080/h2-console

### H2 Credentials
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** `password`  

Ensure the application is running to access the H2 Console.
---



## Testing

The project includes comprehensive testing to ensure reliability and maintainability. The following types of tests have been implemented:

### 1. Unit Tests
Unit tests have been created for all layers of the project:
- **Application Layer:** Tests for business use cases and service logic.
- **Domain Layer:** Tests for core entities and domain-specific logic.
- **Infrastructure Layer:** Tests for database operations and repository functionality.
- **Interface Layer:** Tests for controllers and request/response handling.

These tests validate the functionality of individual components and ensure they perform as expected.

### 2. Integration Tests
Integration tests verify the interaction between components and the system as a whole. This includes testing database access, service orchestration, and API endpoints.

### 3. Contract Tests
Contract tests ensure that the API complies with predefined contracts, promoting consistency and preventing breaking changes. The contracts are stored in the following directory: 
\src\test\resources\contracts\price


#### Available Contracts:
- **shouldReturnPrice.yml**: Validates general use cases of the project.
- **validationRequestTechnicalTest.yml**: Contains the five specific tests required for the technical assessment.

These contracts help verify that the API adheres to expected behavior under various scenarios.



---

## Docker

The project is fully containerized for easy deployment. To build and run the application in a Docker container, use the following commands:

```bash
# Build the Docker image
docker build -t ecommerce-price-app .

# Run the container
docker run -p 8080:8080 ecommerce-price-app

Once running, the application will be accessible at http://localhost:8080.