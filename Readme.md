# :book: Aladi

## Context
Aladi is the Barcelona Public Library System. This is a replica of it. 

## Objective
This is a simple API to learn relations Many to Many an One to Many. It has no DTOs and no Error and Exceptions.

### Technologies
- Java 21
- Spring Boot 3
- h2

### Endpoints:
- POST - Create User: localhost:8080/api/v1/users
- POST - Create Book: localhost:8080/api/v1/books/{editorial}
- POST - Create Reserve: localhost:8080/api/v1/reserves/user/{userId}/book/{bookId}
- GET - Reserve by User: localhost:8080/api/v1/reserves/user/{userId}

### Important
This is just an educational project.