FROM eclipse-temurin:20

WORKDIR /app

COPY target/employee-service-0.0.1-SNAPSHOT.jar /app/employee-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "employee-service.jar"]