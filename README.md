# demomicroservices

## Descripción

Este proyecto es un backend desarrollado con **Spring Boot** que expone una API REST para la gestión de pacientes. Utiliza una base de datos Oracle Autonomous Database y sigue una arquitectura de microservicios sencilla, ideal para propósitos educativos o como base para sistemas de salud.

## Tecnologías utilizadas

- **Java 17**: Lenguaje principal del backend.
- **Spring Boot 3.4.5**: Framework para desarrollo rápido de aplicaciones Java.
- **Spring Data JPA**: Abstracción para acceso y persistencia de datos con JPA/Hibernate.
- **Oracle Autonomous Database**: Base de datos en la nube de Oracle.
- **Lombok**: Simplifica la escritura de código eliminando boilerplate (getters, setters, etc).
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Dependencias mínimas en `pom.xml` y su uso

- `spring-boot-starter-data-jpa`: Proporciona integración con JPA/Hibernate para persistencia de datos.
- `spring-boot-starter-web`: Permite crear APIs REST y manejar peticiones HTTP.
- `com.oracle.database.jdbc:ojdbc11`: Driver JDBC para conectarse a bases de datos Oracle.
- `com.oracle.database.security:oraclepki`: Soporte de wallets y conexiones seguras a Oracle Autonomous Database.
- `org.projectlombok:lombok`: Anotaciones para reducir código repetitivo (solo en desarrollo).
- `spring-boot-starter-test`: Herramientas para pruebas unitarias y de integración (solo en test).

## Estructura básica

- `controller/`: Controladores REST (ejemplo: `PacienteController`).
- `model/`: Entidades JPA (ejemplo: `Paciente`).
- `repository/`: Interfaces de acceso a datos.
- `service/`: Lógica de negocio y servicios.
- `resources/application.properties`: Configuración de la aplicación y conexión a la base de datos.

## Ejecución

1. Configura el archivo `application.properties` con los datos de tu wallet y base de datos Oracle.
2. Ejecuta el proyecto con Maven o desde tu IDE:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Accede a la API en: `http://localhost:8080/api/v1/pacientes`

---