#!/bin/bash
# Ensure the script stops on error
set -e

# Build the Spring Boot application
./mvnw clean package

# Move the JAR file to a known location
mkdir -p build
cp target/*.jar build/app.jar
