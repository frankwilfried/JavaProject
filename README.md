# 📋 Java Todo App

A simple task management application built with **Java**, **Spring Boot**, **JPA**, and **PostgreSQL**.

## 🚀 Features

- Create users
- Add tasks (ToDos) to a user
- Toggle task completion status
- Delete tasks or users
- REST API endpoints testable with Postman

## 📦 Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## ▶️ Getting Started

### 1. Prerequisites

- Java 17+
- PostgreSQL
- Maven

### 2. Database Configuration

In `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/Todo_App
spring.datasource.username=postgres
spring.datasource.password=2002
spring.jpa.hibernate.ddl-auto=update
