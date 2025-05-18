# 🛡️ Kotlin Security – Clean Architecture

This project demonstrates a backend application in **Kotlin** using the principles of **Clean Architecture**. It implements authentication and authorization with JWT, with clear separation of responsibilities between the domain, application and infrastructure layers.

---

## 📐 Architecture

The structure follows the **Clean Architecture**, promoting high cohesion and low coupling between the components:

- **Domain**: Domain entities and contracts (interfaces), without dependence on frameworks.
- **Application**: Use cases and business rules.
- **Infrastructure**: Technical implementations (Spring Security, MongoDB, etc.).
- **Interface (Web)**: Layer responsible for exposing the application endpoints.

---

## 🚀 Technologies Used

- **Kotlin**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MongoDB**
- **Gradle**

---

## 🧱 Project Structure

```text
kotlin-security/
├──domain/
│ ├── entities/
│ ├── repositories/
│ └── exceptions/
├──application/
│ ├── usecases/
│ └── services/
├── infrastructure/
│ ├── config/
│ ├── controllers/
│ ├── repositories/
│ └── security/`
└── README.md
```

## 🔐 Features

- ✅ User registration with password encryption
- ✅ Authentication via JWT
- ✅ Endpoint protection based on permissions (roles)
- ✅ Validations and global exception handling
- ✅ Decoupled architecture with clear separation of responsibilities
