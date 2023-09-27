# the first stage of our build will use a maven 3.9.2 parent image

FROM maven:3.9.2 AS MAVEN_BUILD

# Copy only pom.xml of your projects and download dependencies
COPY pom.xml .
RUN mvn -B -f pom.xml dependency:go-offline -DskipTests

# copy the pom and src code to the container
COPY . .
RUN mvn -B install -DskipTests

# the second stage of our build will use open jdk 17 on alpine
FROM openjdk:17

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD ./target/diary-backend-0.0.1-SNAPSHOT.jar /spring-boot-server.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/spring-boot-server.jar"]
