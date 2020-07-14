FROM maven:3.6-openjdk-8
WORKDIR /data/apps/springcloud_study-master/spring-cloud-eureka
COPY . .
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar","springcloud-eureka-1.0-SNAPSHOT.jar"]
