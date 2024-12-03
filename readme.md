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

## Testing

The project includes the following types of tests to ensure code quality and correctness:

- **Unit Tests:** Validate individual components and methods.
- **Integration Tests:** Test interactions between components and the database.
- **Contract Tests:** Verify compliance with the API specification defined in `price-api.yml`.

---

## Docker

The project is fully containerized for easy deployment. To build and run the application in a Docker container, use the following commands:

```bash
# Build the Docker image
docker build -t ecommerce-price-app .

# Run the container
docker run -p 8080:8080 ecommerce-price-app

Once running, the application will be accessible at http://localhost:8080.