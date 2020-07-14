FROM openjdk:8
WORKDIR /data/apps/
RUN wget -LO https://github.com/lifeng159632/springcloud_study/archive/master.zip
RUN unzip master.zip
WORKDIR /data/apps/springcloud_study-master/spring-cloud-eureka
RUN docker run -it --rm --name spring-cloud-eureka -v "$(pwd)":/data/apps/springcloud_study-master/spring-cloud-eureka
    -w /data/apps/springcloud_study-master/spring-cloud-eureka maven:3.3-jdk-8 mvn clean install
EXPOSE 8080
CMD ["java", "-jar","springcloud-eureka-1.0-SNAPSHOT.jar"]
