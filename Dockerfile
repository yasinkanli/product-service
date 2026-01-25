FROM openjdk:25-ea-1-jdk-slim

COPY . /app

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8090