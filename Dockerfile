FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/challenge-0.1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]