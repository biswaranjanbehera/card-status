FROM openjdk:17
WORKDIR /usr/src/myapp
COPY target/Getting-the-card-status-0.0.1-SNAPSHOT.jar /usr/src/myapp
CMD [ "java" , "-jar" , "Getting-the-card-status-0.0.1-SNAPSHOT.jar"]
EXPOSE 9595