FROM openjdk:8-jdk-alpine

ENV JAR_FILE=target/davidson-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
