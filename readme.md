# Notes API

A RESTful Notes Management API built with Spring Boot and PostgreSQL.

## Features

* Create Note
* Get All Notes
* Get Note By ID
* Update Note
* Delete Note
* Validation
* Global Exception Handling
* Pagination
* Sorting
* Search Notes By Title

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* Swagger/OpenAPI

## API Endpoints

### Create Note

POST /api/notes

### Get All Notes

GET /api/notes

### Get Note By ID

GET /api/notes/{id}

### Update Note

PUT /api/notes/{id}

### Delete Note

DELETE /api/notes/{id}

### Search Notes

GET /api/notes/search?title=spring

## Running Locally

1. Clone repository
2. Configure PostgreSQL
3. Update application.properties
4. Run:

mvn spring-boot:run

## Future Improvements

* JWT Authentication
* Docker Support
* Unit Testing
* API Response Wrapper
* Auditing
