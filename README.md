# teamvoy-task

This is the project that satisfy test task from the Teamvoy.
The main idea - to create RESTful API for orders and items. Project was written on Java 11 and Spring Boot,
JPA - Spring Data, storage - MySQL, unit tests - JUnit and Mockito, build automation tool - Maven.

Technologies used in this project:
- Java 11
- Spring Boot
- Spring Data
- MySQL
- JUnit5
- Mockito
- Maven

## how to work with the project
First all you need to have working MySQL RDBMS. Create schema with name 'testdb'.
In resources directory open file application.properties. Change user and password to yours.
There's a bean to inject some starter items. It is called automatically, you don't need to call it.
That's all :) Just run the project and open localhost:8080 on your client (any browser app).

P.S dont forget to allow auto-import for maven dependencies or import all of them before starting the project.
