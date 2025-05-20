# Demo Microservicios en JAVA + Spring

## Descripción

Este proyecto es un backend desarrollado con **Spring Boot** que expone una API REST para la gestión de pacientes. Utiliza una base de datos PostgreSQL y sigue una arquitectura de microservicios sencilla.

## Tecnologías utilizadas

- **Java 17**: Lenguaje principal del backend.
- **Spring Boot 3.4.5**: Framework para desarrollo rápido de aplicaciones Java.
- **Spring Data JPA**: Abstracción para acceso y persistencia de datos con JPA/Hibernate.
- **PostgreSQL**: Base de datos relacional open source.
- **Lombok**: Simplifica la escritura de código eliminando boilerplate (getters, setters, etc).
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Docker & Docker Compose**: Para contenerización y orquestación de la aplicación y la base de datos.

## Dependencias mínimas en `pom.xml` y su uso

- `spring-boot-starter-data-jpa`: Proporciona integración con JPA/Hibernate para persistencia de datos.
- `spring-boot-starter-web`: Permite crear APIs REST y manejar peticiones HTTP.
- `org.postgresql:postgresql`: Driver JDBC para conectarse a bases de datos PostgreSQL.
- `org.projectlombok:lombok`: Anotaciones para reducir código repetitivo (solo en desarrollo).
- `spring-boot-starter-test`: Herramientas para pruebas unitarias y de integración (solo en test).

## Estructura básica

- `controller/`: Controladores REST (ejemplo: `PacienteController`).
- `model/`: Entidades JPA (ejemplo: `Paciente`).
- `repository/`: Interfaces de acceso a datos.
- `service/`: Lógica de negocio y servicios.
- `resources/application.properties`: Configuración de la aplicación y conexión a la base de datos.

## Ejecución con Docker

1. Asegúrate de tener Docker y Docker Compose instalados.
2. Construye el proyecto y el contenedor:
   ```sh
   ./mvnw clean package
   docker-compose build
   ```
3. Levanta los servicios:
   ```sh
   docker-compose up
   ```
4. Accede a la API en: `http://localhost:8080/api/v1/pacientes`

## Configuración de la base de datos

La configuración de conexión a PostgreSQL se encuentra en `src/main/resources/application.properties` y en las variables de entorno del servicio `app` en `docker-compose.yml`:

```properties
spring.datasource.url=jdbc:postgresql://db:5432/demomicroservices
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---
