# Usar una imagen base con Maven incluido
FROM maven:3.9-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml primero (para aprovechar la caché de Docker)
COPY pom.xml .

# Copiar el código fuente
COPY src ./src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Imagen final más ligera solo para ejecutar
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/lab13-daw-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

