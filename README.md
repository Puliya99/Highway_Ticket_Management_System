# Highway Ticket Management System

## Overview

In today's dynamic transportation landscape, managing highway tickets efficiently is crucial for ensuring smooth traffic flow and compliance with regulations. This project aims to develop a robust microservice-based backend application for a Highway Ticket Management System. The system streamlines the handling of ticket issuance, vehicle registration, user management, and payment processing without relying on external payment gateways. By leveraging Spring Boot and Spring Cloud technologies, including Eureka for service discovery, a Configuration Server for centralized configuration management, and a Spring Cloud Gateway for intelligent routing, the application ensures scalability, resilience, and seamless integration of services. Comprehensive testing using Postman validates the functionality and reliability of each microservice, ensuring they meet stringent business requirements and provide a seamless user experience.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Cloud (Eureka, Config Server, Gateway)**
- **Maven**
- **Postman**

## Microservices

### 1. Eureka Server

**Purpose**: Enables microservices to register themselves and discover other services dynamically.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Eureka Server.
- Annotate the main class with `@EnableEurekaServer`.
- Configure `application.yml`.

### 2. Config Server

**Purpose**: Centralizes configuration management.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Config Server.
- Annotate the main class with `@EnableConfigServer`.
- Configure `application.yml` to point to a Git repository.

### 3. API Gateway

**Purpose**: Serves as a single entry point for client requests.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Spring Cloud Gateway.
- Annotate the main class with `@EnableEurekaClient`.
- Configure routes in `application.yml`.

### 4. Microservices

#### Ticket Service

**Purpose**: Manages ticket lifecycle.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Eureka Client and Spring Web.
- Annotate the main class with `@EnableEurekaClient`.
- Define endpoints in `TicketController`.

#### Vehicle Service

**Purpose**: Handles vehicle operations.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Eureka Client and Spring Web.
- Annotate the main class with `@EnableEurekaClient`.
- Define endpoints in `VehicleController`.

#### User Service

**Purpose**: Manages user and owner information.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Eureka Client and Spring Web.
- Annotate the main class with `@EnableEurekaClient`.
- Define endpoints in `UserController`.

#### Payment Service

**Purpose**: Facilitates secure payment processing internally.

**Setup**:
- Create a Spring Boot application.
- Add dependencies for Eureka Client and Spring Web.
- Annotate the main class with `@EnableEurekaClient`.
- Define endpoints in `PaymentController`.

Testing
Tools: Postman - https://www.postman.com/telecoms-astronaut-34620843/workspace/highwayticketmanagementsystem/collection/30946361-18f4d045-6143-4afa-ba1e-867d3b08c2f3?action=share&creator=30946361

Approach:

Create Postman collections for each microservice.
Test all API endpoints for each service.
Validate error handling and edge cases.
Ensure integration between services works as expected.
Getting Started
Prerequisites
Java 17
Maven
Git
