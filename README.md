# PruebaTecnicaNTT-Backend

Este proyecto es una API RESTful desarrollada con **Spring Boot**, diseñada como parte de una prueba técnica. Proporciona servicios para autenticación de usuarios, gestión de empleados y oficinas.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security** – Autenticación con JWT
- **Spring Web** – API REST
- **Spring Data JPA** – Acceso a base de datos
- **Lombok** – reducir escritura de codigo / seguir buenas practicas
- **PostgreSQL** – Base de datos
- **Flyway** – Migraciones de base de datos

## Autenticación

- Basada en JWT.
- Los endpoints `/api/auth/login` y `/api/auth/register` están públicos.
- El resto de la API requiere autenticación por Bearer token.
