# Use the official Maven image to build the app
# You can use your own JDK version as needed
FROM maven:3.8.1-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Use an OpenJDK runtime image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the runtime container
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/deepakserver-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Use the environment variable PORT from Render, default to 8080
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
