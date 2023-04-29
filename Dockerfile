FROM openjdk:17-jdk

WORKDIR /app

COPY target/bootcamp-1.0.jar /app/bootcamp.jar

EXPOSE 8087

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "bootcamp.jar"]
