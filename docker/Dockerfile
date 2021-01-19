FROM gradle:6.7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon 

FROM openjdk:11-jre AS app
WORKDIR /app
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar /app/home-budget-app.jar
ENTRYPOINT ["java", "-jar","/app/home-budget-app.jar"]