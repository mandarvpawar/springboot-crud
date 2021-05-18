# Tells Docker to use the Maven image "maven:3.5.2-jdk-8-alpine" as the base image for the first stage of the build
FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

# Point of contact for the image author.
MAINTAINER Mandar Pawar

# Creates a build directory in the image and copies the pom.xml into it.
COPY pom.xml /build/

# Copies the src directory into the build directory in the image.
COPY src /build/src/

# Sets build as the working directory. 
# Any further commands will run from the build directory.
WORKDIR /build/

# Runs the "mvn package" command to compile and package the application as an executable JAR
RUN mvn package

# Tells Docker you want to use the openjdk:8-jre-alpine base image for the next stage of the multi-stage build
FROM openjdk:8-jre-alpine

# Tells Docker to create a new working directory in the image called /app
WORKDIR /app

# Tells Docker to copy docker-boot-intro-0.1.0.jar from the /build/target directory in the MAVEN_BUILD stage to the /app directory of the current stage
COPY --from=MAVEN_BUILD /build/target/docker-boot-intro-0.1.0.jar /app/

# Tells Docker what command to run when a container is started from this image.
ENTRYPOINT ["java", "-jar", "app.jar"]