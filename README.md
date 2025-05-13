The project is developed using RESTful architecture, which follows a layered and modular design to ensure separation of concerns and maintainability. The architecture includes several key layers, each with specific responsibilities:

1. Entity Layer
The entity layer is responsible for defining the application's core data models. This includes classes such as User, Author, Book, and Loan. These classes are mapped to database tables using JPA annotations. Relationships between entities are established using Association Mapping, such as One-to-Many and Many-to-One, to model real-world relationships in the database schema.

2. Repository Layer
The repository layer handles direct interactions with the database. It extends Spring Data JPA's JpaRepository interface, providing basic CRUD operations. Additionally, custom queries are written using JPQL or native SQL to retrieve data based on specific conditions or business needs.

3. DAO (Data Access Object) Layer
The DAO layer is used for advanced data access operations that go beyond standard repository functionality. It contains methods that access data using a combination of built-in JPA capabilities and custom-defined logic. This layer abstracts the data access logic and provides a clean interface for interacting with the database.

4. Service Layer
The service layer is responsible for implementing the business logic of the application. It acts as an intermediary between the controller and repository/DAO layers. In this layer, data processing, validation, and transformation occur. It also manages the construction of response structures, often using Data Transfer Objects (DTOs) to ensure clean and structured data exchange.

5. DTO (Data Transfer Object) Layer
The DTO layer facilitates the transfer of data between the client and server. DTOs are used to decouple internal data representations (i.e., entities) from external API responses. They help in exposing only necessary information and ensure that sensitive or irrelevant data is not shared with the client.

6. Controller Layer
The controller layer is responsible for handling incoming HTTP requests from clients, including those sent via Postman or browsers. It defines RESTful endpoints using annotations such as @GetMapping, @PostMapping, etc. This layer receives requests, delegates the business logic to the service layer, and returns the appropriate HTTP responses.

7. Exception Handling Layer
To manage errors consistently across the application, an exception handling layer is implemented using Spring’s @ControllerAdvice and custom exception classes. This ensures that meaningful and user-friendly error messages are returned for exceptions such as missing resources, invalid input, or database errors.

