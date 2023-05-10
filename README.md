# Social Media Application

This is a simple social media application built with Spring Boot.

## Features

- User Registration
- User Login

## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Hibernate

## Setup and Installation

1. Clone the repository: 
    ```
    git clone https://github.com/sisisi222/social-media-app.git
    ```
2. Navigate into the directory: 
    ```
    cd socialmediaapp
    ```
3. Update the `application.properties` file with your PostgreSQL connection details.
4. Build the project with Maven: 
    ```
    mvn clean install
    ```
5. Run the application: 
    ```
    mvn spring-boot:run
    ```

## API Endpoints

- `POST /api/users/register`: Register a new user.
    - Request Body: 
    ```json
    {
        "username": "yourusername",
        "password": "yourpassword"
    }
    ```

- `POST /login`: Authenticate a user.
    - Request Body: 
    ```json
    {
        "username": "yourusername",
        "password": "yourpassword"
    }
    ```

## Future Enhancements

- Add the ability to create posts
- Add the ability to like and comment on posts
- Add user profiles

