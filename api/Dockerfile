# Use an official Maven image for building and running the app
FROM maven:3.9.6-eclipse-temurin-21 AS dev

# Set the working directory
WORKDIR /app

# Copy pom.xml and download dependencies (for faster rebuilds)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Expose the default Spring Boot port
EXPOSE 8080

# Enable hot reload with spring-boot:run
CMD ["mvn", "spring-boot:run"]
