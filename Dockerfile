# Use Amazon Corretto 21 as the base image
FROM amazoncorretto:21-alpine as build

# Set working directory
WORKDIR /app

# Copy your pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the app
RUN ./mvnw clean package -DskipTests

# Copy the built JAR file to a new stage
FROM amazoncorretto:21-alpine

WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/*.jar /app/my-spring-boot-app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "my-spring-boot-app.jar"]
