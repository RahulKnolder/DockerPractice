FROM ubuntu:rolling
RUN apt-get update && apt-get install -y openjdk-17-jdk
COPY /target/microservice-1-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/microservice-1-0.0.1-SNAPSHOT.jar"]