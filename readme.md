# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.2/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### JPA

JPA is just the specification.

1. JPA is bridge between Java's object and data in Databases.
2. ORM - Object Relational Mapping

JPA implementations

1. Hibernate 
2. EclipseLink
3. Open JPA

Almost all the Database are supported by JPA

### Maven shell Commands 

1. ./mvnw spring-boot:run -- In the root project directory runs the project.

### This Project 

A simple spring boot application 

#### Initial Setup

Spring Initializer

1. Web
2. JPA
3. H2
4. Thymeleaf
5. Actuator

#### Models 

1. Author
2. Book
3. Publisher

Annotations for Models

1. @Entity : applied to class - Marks the class as JPA entity.
2. @Id : applied to id filed of class
3. @GenratedValue(strategy = GenerationType.Auto) : id field of class - auto generates the Id 
4. @ManyToMany : for mapping relations

#### H2 Console

In application.properites file set: 

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb

H2 Console URL: 

http://localhost:8080/h2-console

#### Using GitHub











 


