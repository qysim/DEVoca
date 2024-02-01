# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy as builder

LABEL authors="cheesecat47"

WORKDIR /app

COPY . .

RUN chmod +x gradlew && \
    ./gradlew bootJar

FROM eclipse-temurin:17-jdk-jammy

LABEL authors="cheesecat47"

ARG INFISICAL_TOKEN

ENV INFISICAL_TOKEN=${INFISICAL_TOKEN}

WORKDIR /app

COPY --from=builder /app/build/libs/devoca-0.0.1-SNAPSHOT.jar .

RUN apt-get update && apt-get install -y bash curl && curl -1sLf \
'https://dl.cloudsmith.io/public/infisical/infisical-cli/setup.deb.sh' | bash \
&& apt-get update && apt-get install -y infisical

CMD ["infisical", "run", "--", "java", "-jar", "/app/devoca-0.0.1-SNAPSHOT.jar"]
