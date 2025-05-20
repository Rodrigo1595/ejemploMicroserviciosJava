# Usa una imagen oficial de OpenJDK
FROM eclipse-temurin:17-jdk-alpine

# Crea el directorio de la app
WORKDIR /app

# Copia el jar construido y los recursos necesarios
COPY target/demomicroservices-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties ./src/main/resources/application.properties

# Expone el puerto de la app
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]