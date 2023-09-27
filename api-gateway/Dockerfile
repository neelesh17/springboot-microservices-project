FROM eclipse-temurin:20

WORKDIR /app

COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "api-gateway.jar"]