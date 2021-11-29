FROM openjdk:8u191-jre-alpine3.8

COPY target/jumia-0.0.1-SNAPSHOT.jar jumia-0.0.1-SNAPSHOT.jar

EXPOSE 8091

CMD ["java", "-jar", "jumia-0.0.1-SNAPSHOT.jar"]