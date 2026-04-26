FROM gradle:7.5-jdk17 as BUILD
WORKDIR /app
COPY . .
RUN ./gradlew clean build --no-daemon


FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar  /app/usuario.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/usuario.jar"]