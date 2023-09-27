FROM eclipse-temurin:20

WORKDIR /app

COPY target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "service-registry.jar"]