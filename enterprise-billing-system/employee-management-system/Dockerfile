FROM openjdk:8-jdk-alpine
LABEL maintainer="tripathi.binay86@gmail.com"
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]