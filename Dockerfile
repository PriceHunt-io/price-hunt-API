# Etapa 1: Build com Maven
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app

# Copia arquivos do projeto
COPY pom.xml .
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com JRE leve
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Copia o wait-for-it.sh (está na raiz do projeto)
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Expondo porta padrão
EXPOSE 8080

# Espera o banco ficar pronto e só depois inicia a API
ENTRYPOINT ["/wait-for-it.sh", "database:5432", "--", "java", "-jar", "app.jar"]
