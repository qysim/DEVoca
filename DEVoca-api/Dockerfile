# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy

LABEL authors="cheesecat47"

WORKDIR /app

COPY . .

RUN chmod +x gradlew && \
    ./gradlew bootJar
