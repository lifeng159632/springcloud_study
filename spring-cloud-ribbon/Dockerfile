FROM openjdk:8
WORKDIR /data/apps/spring-cloud-ribbon
COPY ./target/spring-cloud-ribbon-1.0-SNAPSHOT.jar .
EXPOSE 8083
CMD ["java", "-jar","spring-cloud-ribbon-1.0-SNAPSHOT.jar"]