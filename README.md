# Nimap Assignment: Category & Product Management System

## Overview
This project is a **Category and Product Management System** built using **Spring Boot**. It provides REST APIs to manage categories and products, including functionalities for CRUD operations, pagination, and a one-to-many relationship between categories and products.

---

## Features

1. **Category CRUD Operations**:
   - Create, read, update, and delete categories.
   - Fetch all categories with pagination.
   
2. **Product CRUD Operations**:
   - Create, read, update, and delete products.
   - Fetch all products with pagination.
   - Retrieve product details along with its associated category.

3. **One-to-Many Relationship**:
   - A single category can have multiple products.

4. **Server-Side Pagination**:
   - Paginated results for both categories and products.

5. **Validation**:
   - Input validation using annotations (e.g., `@NotNull`, `@Size`).

---

## Technologies Used

- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **JPA & Hibernate**: For database interaction
- **Pagination**: Built-in Spring Data functionality
- **Validation**: Spring Boot Validation

---

## Prerequisites

1. **Java 17** or later
2. **Maven** for dependency management
3. **MySQL** as the relational database
4. **Postman** or any other tool to test APIs

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository_url>
   cd <repository_folder>
   ```

2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nimap_db
   spring.datasource.username=<your_db_username>
   spring.datasource.password=<your_db_password>
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Test the APIs using Postman or any other tool.

---

## API Endpoints

### Category APIs
1. **Get All Categories (Paginated)**  
   `GET /api/categories?page=<page_number>`  

2. **Create a Category**  
   `POST /api/categories`  
   **Request Body**:
   ```json
   {
       "name": "Electronics"
   }
   ```

3. **Get Category by ID**  
   `GET /api/categories/{id}`  

4. **Update Category by ID**  
   `PUT /api/categories/{id}`  
   **Request Body**:
   ```json
   {
       "name": "Updated Category Name"
   }
   ```

5. **Delete Category by ID**  
   `DELETE /api/categories/{id}`  

---

### Product APIs
1. **Get All Products (Paginated)**  
   `GET /api/products?page=<page_number>`  

2. **Create a Product**  
   `POST /api/products`  
   **Request Body**:
   ```json
   {
       "name": "Laptop",
       "price": 75000,
       "categoryId": 1
   }
   ```

3. **Get Product by ID (With Category Details)**  
   `GET /api/products/{id}`  

4. **Update Product by ID**  
   `PUT /api/products/{id}`  
   **Request Body**:
   ```json
   {
       "name": "Updated Product Name",
       "price": 80000,
       "categoryId": 2
   }
   ```

5. **Delete Product by ID**  
   `DELETE /api/products/{id}`  

---

## Database Schema

### Category Table
| Field | Type    | Constraints |
|-------|---------|-------------|
| id    | BIGINT  | Primary Key |
| name  | VARCHAR | Not Null    |

### Product Table
| Field       | Type    | Constraints       |
|-------------|---------|-------------------|
| id          | BIGINT  | Primary Key       |
| name        | VARCHAR | Not Null          |
| price       | DOUBLE  |                   |
| category_id | BIGINT  | Foreign Key (Category) |

---

## Future Enhancements

- Implement authentication and authorization.
- Add support for filtering and sorting results.
- Integrate Swagger for API documentation.

---

## Author
**Prakhar Tripathi**  
Feel free to reach out for questions or suggestions!  

---
