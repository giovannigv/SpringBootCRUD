# Spring Boot CRUD Application with MySQL, HTTPS, and JWT

This is a secure Spring Boot CRUD (Create, Read, Update, Delete) application that interacts with a MySQL database. It incorporates HTTPS for secure communication and JWT for authentication/authorization.

## Features

- Secure CRUD endpoints for managing items in the MySQL database.
- Uses HTTPS for secure communication.
- Implements JWT as the authentication provider.

## Requirements

- Java JDK 17
- MySQL Server
- JWT provider

## Setup

1. Clone the repository to your local machine:
```bash
git clone https://github.com/your_username/spring-boot-mysql-crud.git
cd spring-boot-mysql-crud
```

2. Set up the MySQL Database:

   - Create a new MySQL database for the application.
   - Update the `application.properties` file with your MySQL database credentials (in the "MySQL configuration" section).

3. Run the Application:

   Use your favorite IDE or run the following command from the project root:

```bash
gradle spring-boot:run
```

The application should now be accessible at `https://localhost:8000`.

## Usage

1. Access the Application:

Open your web browser and navigate to `https://localhost:8000`.

2. Authentication

This application uses JWT (JSON Web Tokens) for authentication. When making requests to secure endpoints, include the JWT token in the request headers.

To obtain a JWT token:

- Send a POST request to `/authenticate` with JSON payload containing your username and password:

    
3. CRUD Operations:

- Once authenticated, you can access the secure CRUD endpoints for managing items in the database.
- Use tools like Postman to test the CRUD endpoints.

ROUTE: `/api/product`, `/api/order`
GET - List all items in the database.
POST - Create a new item in the database.
PUT - Update an existing item in the database.
DELETE - Delete an existing item from the database.

4. Secure Communication:

- All communication with the application is over HTTPS, ensuring secure data transfer.

## Notes

- This is a basic example application and should not be used in production without further enhancements.
- The application uses JWT tokens for authentication, which are stateless and do not require server-side session management.
- Make sure to keep your JWT secret key secure and avoid exposing it in the codebase or publicly accessible locations.
- For production deployment, consider using a production-grade database and securely managing JWT secret keys.

## License

This project is licensed under the [MIT License](LICENSE).


