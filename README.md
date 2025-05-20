# Demo Microservicios en JAVA + Spring

## Descripción

Este proyecto es un backend desarrollado con **Spring Boot** que expone una API REST para la gestión de pacientes. Utiliza una base de datos Oracle Autonomous Database (con wallet) y sigue una arquitectura de microservicios sencilla.

## Tecnologías utilizadas

- **Java 17**: Lenguaje principal del backend.
- **Spring Boot 3.4.5**: Framework para desarrollo rápido de aplicaciones Java.
- **Spring Data JPA**: Abstracción para acceso y persistencia de datos con JPA/Hibernate.
- **Oracle Autonomous Database**: Base de datos en la nube de Oracle.
- **Lombok**: Simplifica la escritura de código eliminando boilerplate (getters, setters, etc).
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **Docker & Docker Compose**: Para contenerización y orquestación de la aplicación y el acceso seguro a Oracle mediante wallet.

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

## Ejecución con Docker y Oracle Wallet

1. **Prepara tu wallet de Oracle**  
   Descarga el wallet desde Oracle Cloud y colócalo en la carpeta `Wallet_YF7TJC6PMFWBDZF6` dentro del proyecto.

2. **Configura el archivo `application.properties`**  
   Asegúrate de que la URL de conexión apunte al wallet dentro del contenedor:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@yf7tjc6pmfwbdzf6_high?TNS_ADMIN=/app/Wallet_YF7TJC6PMFWBDZF6
   spring.datasource.username=EJEMPLO_SPRING
   spring.datasource.password=tu_contraseña
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
   ```

3. **Construye el proyecto y la imagen Docker**
   ```sh
   ./mvnw clean package
   docker-compose build
   ```

4. **Levanta los servicios**
   ```sh
   docker-compose up
   ```

5. **Accede a la API**
   - URL base: `http://localhost:8080/api/v1/pacientes`

## Notas sobre Docker y Wallet

- El archivo `docker-compose.yml` monta la carpeta del wallet en el contenedor y define la variable de entorno `TNS_ADMIN` para que el driver Oracle lo encuentre correctamente.
- El `Dockerfile` copia el jar generado y la configuración necesaria para ejecutar la aplicación en el contenedor.

---
