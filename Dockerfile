# Build Stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

# Runtime Stage
FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /build/target/bootcamp-1.0.jar /app/bootcamp.jar

EXPOSE 8087

ENV DB_URL=jdbc:postgresql://postgres-sql:5432/bank_db

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "-Dspring.datasource.url=${DB_URL}", "bootcamp.jar"]
