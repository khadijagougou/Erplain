FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the project (assuming Maven is used)
RUN mvn clean package

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Set the entrypoint and expose port
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
EXPOSE 8080
