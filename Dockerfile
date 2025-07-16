# Stage 1: build com Maven + JDK17
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: runtime com JRE 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
ENV PORT=8080
VOLUME /tmp
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
