#!/bin/sh

while ! nc -z config-server 8888 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z service-registry 8761 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done

java -jar /aap/organisation-service.jar