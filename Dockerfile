FROM openjdk:17
WORKDIR /backend
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE /backend/app.jar
ENTRYPOINT exec java -jar app.jar