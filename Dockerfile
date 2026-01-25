FROM openjdk:25-ea-slim

COPY . /app

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8090