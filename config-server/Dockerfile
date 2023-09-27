FROM eclipse-temurin:20

WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar /app/config-server.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar", "config-server.jar"]