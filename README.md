Sweet Shop Management System – Backend
📌 Project Overview

The Sweet Shop Management System (Backend) is a Spring Boot–based REST API designed to manage authentication, sweets inventory, and purchase operations for a sweet shop.

Key Features:

JWT-based Authentication
User registration
User login
Role-based Authorization
Admin and authenticated user access control
Sweets Management
Add, update, delete sweets (Admin only)
View and search sweets (Authenticated users)
Inventory Management
Purchase sweets (reduces stock)
Restock sweets (Admin only)


Database
SQLite (file-based, no external DB setup required)


Security
Spring Security with JWT filters

🛠️ Tech Stack

Java 17+

Spring Boot 3.x

Spring Security

Spring Data JPA

SQLite

Hibernate

JWT (JSON Web Tokens)

Maven

📂 Project Structure (Backend)
backend/
 ├── src/main/java/com/sweetshop/sweetshop
 │   ├── auth/            # Auth controllers & services
 │   ├── config/          # Security & DB configuration
 │   ├── entities/        # JPA entities (User, Sweet)
 │   ├── repositories/   # JPA repositories
 │   ├── security/        # JWT filter & utils
 │   ├── services/        # Business logic
 │   └── controllers/    # REST controllers
 ├── src/main/resources/
 │   └── application.properties
 ├── sweetshop.db         
 └── pom.xml

⚙️ Backend Setup & Run Instructions
1️⃣ Prerequisites

Ensure the following are installed on your system:

Java 17 or higher

java -version


Maven (or use the Maven Wrapper)

mvn -version

2️⃣ Clone the Repository
git clone https://github.com/AyushBhardwaj611/sweetshop-management-system.git
cd sweetshop-management-system/backend

3️⃣ Configure Application Properties

The project already uses SQLite and works out of the box.

Verify src/main/resources/application.properties:

spring.application.name=sweetshop

spring.datasource.url=jdbc:sqlite:./sweetshop.db
spring.datasource.driver-class-name=org.sqlite.JDBC

spring.jpa.database-platform=com.sweetshop.sweetshop.config.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE


⚠️ No username/password or external database setup is required.

4️⃣ Run the Backend Application

From the backend directory:

./mvnw spring-boot:run


If Maven Wrapper is not available:

mvn spring-boot:run

5️⃣ Verify Application Startup
On successful startup, you should see logs similar to:

Tomcat started on port 8080
Started SweetshopApplication
DB initialized


The SQLite database file will be created automatically:

backend/sweetshop.db

🔐 API Access Summary
Authentication

POST /api/auth/register

POST /api/auth/login

Sweets (Protected)

GET /api/sweets – View sweets

GET /api/sweets/search – Search sweets

POST /api/sweets – Add sweet (Admin only)

PUT /api/sweets/{id} – Update sweet (Admin only)

DELETE /api/sweets/{id} – Delete sweet (Admin only)

Inventory (Protected)

POST /api/sweets/{id}/purchase – Purchase sweet

POST /api/sweets/{id}/restock – Restock sweet (Admin only)

⚠️ All protected endpoints require a JWT token in the Authorization header:

Authorization: Bearer <token>

🧪 Testing the APIs

You can test the APIs using:
Postman

