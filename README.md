# Basic Spring Application
This is a simple library management system using Spring Boot, Spring Web, Thymeleaf, and Spring Data Jpa. This basic spring application allows you to perform CRUD operations (Create, Read, Update, Delete) for both books and authors.

To Set up the project:
-
- clone the repository https://github.com/vuelee123/basicSpringApp.git by using 'git clone'.
- import the project into IDE as a Maven project.
- run the application from IDE or use the command 'mvn spring-boot:run' in the terminal.
- open your web browser and navigate to 'http://localhost:8080' on the url where it will take you to the home page.
### On the home page, you are given two options to perform the CRUD operations by either choosing 'Author List' or 'Book List'.

Model
-
- the 'Book' class is the book entity with the id, title, and author properties.
- the 'Author' class is the author entity with the id, name, and book properties.

Repository
-
-  BookRepository interface extends 'JpaRepository<Book, Long>' and provides CRUD operations for the 'Book' model.
-  AuthorRepository interface extends 'JpaRepository<Author, Long>' and provides CRUD operations for the 'Author' model.

Controller
-
- BookController handles CRUD operations for books.
- AuthorController handles CRUD operations for authors.
- @Controller is the base request mapping path for related operations for book and author.

Templates
-
- the application uses Thymeleaf templates to render the views for all the html provided.

#### You can use the button and forms to test the CRUD operations for both books and authors. You can create new books/authors, update existing books/authors, delete books/authors and view the list of books/authors.


