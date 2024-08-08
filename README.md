# Library Management System

This project is a Library Management System API built using Spring Boot. The system allows librarians to manage books, patrons, and borrowing records through a RESTful API.

## Features

- Book management: CRUD operations for books.
- Patron management: CRUD operations for patrons.
- Borrowing and returning books.
- Basic authentication for secure access.
- Logging using Aspect-Oriented Programming (AOP).
- Caching frequently accessed data.
- Transaction management to ensure data integrity.

## Getting Started

### Installation

1. Clone the repository:
   git clone https://github.com/Khloud-azeem/Library-Management-System
2. Access the project directory:
    cd library-management-system/demo

### Running the Application

1. Install the dependencies:
    ```mvn clean install```
2. Start the application:
    ```mvn spring-boot:run```

### Testing the Application

1. Run the tests:
    ```mvn test```

## API Endpoints

### Book Management

- GET /api/books: Retrieve a list of all books.
- GET /api/books/{id}: Retrieve details of a specific book by ID.
- POST /api/books: Add a new book to the library.
- PUT /api/books/{id}: Update an existing book's information.
- DELETE /api/books/{id}: Remove a book from the library.

### Patron Management

- GET /api/patrons: Retrieve a list of all patrons.
- GET /api/patrons/{id}: Retrieve details of a specific patron by ID.
- POST /api/patrons: Add a new patron to the system.
- PUT /api/patrons/{id}: Update an existing patron's information.
- DELETE /api/patrons/{id}: Remove a patron from the system.

### Borrowing Operations

- POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to borrow a book.
- PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.
- Authentication

## Database Configuration

The application uses a PostgreSQL database, to up the database:

1. Ensure PostgreSQL is installed and running on your system.

2. Create a database for the application:
    ```CREATE DATABASE librarydb;```
3. Create a user for the application with a password:
    - ```CREATE USER libraryuser WITH PASSWORD 'yourpassword';```
    - ```GRANT ALL PRIVILEGES ON DATABASE librarydb TO libraryuser;```

## Authentication

The API is protected by basic authentication. Use the following credentials:
- Username: admin
- Password: password
