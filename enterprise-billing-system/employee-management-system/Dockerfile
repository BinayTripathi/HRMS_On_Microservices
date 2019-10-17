FROM openjdk:8-jdk-alpine
LABEL maintainer="tripathi.binay86@gmail.com"
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE ${MY_SERVICE_PORT}
ENTRYPOINT [ "sh", "-c", "java -jar -Dserver.port=${MY_SERVICE_PORT} /app.jar" ]