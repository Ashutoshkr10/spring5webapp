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

#### H2 Console

In application.properites file set: 

spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb

H2 Console URL: 

http://localhost:8080/h2-console

#### Models 

1. Author
2. Book
3. Publisher

Annotations for Models

1. @Entity : applied to class - Marks the class as JPA entity.
2. @Id : applied to id filed of class
3. @GenratedValue(strategy = GenerationType.Auto) : id field of class - auto generates the Id 
4. @ManyToMany : for mapping relations

Creating the Models 

```java

package ashu.prac.spring5webapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;


@Entity
public class Author {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy= "authors")
	private Set<Book> books = new HashSet<>();

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(String firstName, String lastName, Set<Book> books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = books;
	}

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}
	

}


```

#### Using GitHub

#### Creating Repositories 

By extending the repository class we get the CRUD methods by default 

```java

package ashu.prac.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ashu.prac.spring5webapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

```

#### Using Grails to initialize a database

using the Bootstrap class to initialize the data base for local development.

```java

package ashu.prac.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ashu.prac.spring5webapp.models.Author;
import ashu.prac.spring5webapp.models.Book;
import ashu.prac.spring5webapp.models.Publisher;
import ashu.prac.spring5webapp.repositories.AuthorRepository;
import ashu.prac.spring5webapp.repositories.BookRepository;
import ashu.prac.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		initData();
	}

	private void initData() {
		
		Publisher harpC = new Publisher("Harper Collins","Harpers address");
		Publisher worx = new Publisher("Worx","Worx's address");
		
		publisherRepository.save(harpC);
		publisherRepository.save(worx);
		
		// eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", harpC);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Jhonson");
		Book noEJB = new Book("J2EE development without EJB", "2344", worx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

	

}

```

#### Controller 

```java

package ashu.prac.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ashu.prac.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		
		System.out.println(bookRepository.findAll());
		
		return "books";
	}

}


```









 


