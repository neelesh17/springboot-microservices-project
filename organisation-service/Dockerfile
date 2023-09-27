FROM eclipse-temurin:20

WORKDIR /app

COPY target/organisation-service-0.0.1-SNAPSHOT.jar /app/organisation-service.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar" , "organisation-service.jar"]