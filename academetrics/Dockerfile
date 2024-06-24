# Use Ubuntu as the base image
FROM ubuntu:20.04

# Install OpenJDK 21
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    apt-get clean

# Install MySQL client
RUN apt-get update && \
    apt-get install -y mysql-client && \
    apt-get clean

# Set the argument for the JAR file location
ARG JAR_FILE=target/*.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
