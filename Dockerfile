FROM maven:3.8.1-openjdk-8

COPY . /app
WORKDIR /app
RUN mvn clean package

FROM openjdk:8
WORKDIR /root
COPY --from=0 /app/target/IssueManagementAPI-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

