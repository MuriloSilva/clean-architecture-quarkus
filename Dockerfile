# Stage 1: build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml ./
COPY core/pom.xml core/pom.xml
COPY infrastructure/pom.xml infrastructure/pom.xml
COPY core ./core
COPY infrastructure ./infrastructure
RUN mvn -B -pl infrastructure -am package -DskipTests

# Stage 2: run the application on a lightweight image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /workspace/infrastructure/target/quarkus-app/lib/ /app/lib/
COPY --from=build /workspace/infrastructure/target/quarkus-app/*.jar /app/
COPY --from=build /workspace/infrastructure/target/quarkus-app/app/ /app/app/
COPY --from=build /workspace/infrastructure/target/quarkus-app/quarkus/ /app/quarkus/
CMD ["java","-jar","/app/quarkus-run.jar"]
