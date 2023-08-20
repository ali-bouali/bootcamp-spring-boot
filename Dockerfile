FROM openjdk:17-jdk

WORKDIR /app

COPY target/bootcamp-1.0.jar /app/bootcamp.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "-Drds.url=${DB_URL}", "bootcamp.jar"]
