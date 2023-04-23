FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the start.io jar file to the container
COPY start.io.jar /app

# Run the application when the container starts
CMD ["java", "-jar", "start.io.jar"]
