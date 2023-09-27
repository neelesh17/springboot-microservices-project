FROM eclipse-temurin:20

WORKDIR /app

COPY target/department-service-0.0.1-SNAPSHOT.jar /app/department-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "department-service.jar"]