# Ecommerce-price

Build a Spring Boot application/service that provides a REST endpoint for querying, such that:

Accepts the following input parameters: application date, product identifier, brand identifier.
Returns the following output data: product identifier, brand identifier, applicable rate, application dates, and final price to apply.

## Table of Contents

- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Docker](#docker)


## Architecture

The project follows the Hexagonal Architecture pattern, also known as Ports and Adapters. This architectural pattern promotes a clear separation of concerns by dividing the application into multiple layers:

- **Domain Layer:** Contains the core in this case out entity Price
- **Application Layer:** Implements the use cases of the application and orchestrates the interactions between the domain and infrastructure layers.
- **Infrastructure Layer:** Provides implementations for external services and frameworks, such acces to database H2 , and here we using Specification for managment the filters.
- **Interface Layer:** Handles out Request/Response trough APi generate with OpenApi , in this project we have PriceControllerApi.

## Technologies Used

- Java
- Spring Boot
- H2 Database
- OpenAPI
- Junit, Mockito
- JPA
- Postman
- Docker



## Docker

The project is dockerized and can be run in a container. To build and run the Docker image, use the following commands:


```shel
#build docker imagen
docker build -t spring-boot-app .

#Run container
docker run -p 8080:8080 spring-boot-app

```
## Documentation Api

The project is building with swagger , you can access to the url in you local machine  after run the app to see the endpoint and parameters :

http://localhost:8080/swagger-ui/index.html#/Price

## Test
In this project We have included the following tests
- Unit Tests
- Integration Test
- Contract Test