#!/bin/bash
if  [ -f master.zip ]; then
	echo "master.zip existed"
	rm -rf master.zip
	rm -rf master
	echo "remove master.zip complete"
fi
echo "start copy code form github..."
curl -LO https://github.com/lifeng159632/springcloud_study/archive/master.zip
echo "copy code complete..."
if [ ! -f master.zip ]; then
	echo "code is not existed"
	exit -1
fi
echo "unzip code.zip..."
unzip -d master master.zip
echo "unzip zip complete..."

cd master/springcloud_study-master/spring-cloud-eureka
echo "go to workspace"
echo "start build project with maven..."
mvn clean package
echo "build complete..."
echo "run project..."
# docker run --rm -v "$PWD":/usr/src/spring-cloud-eureka -w /usr/src/spring-cloud-eureka openjdk:8 java -jar springcloud-eureka-1.0-SNAPSHOT.jar
docker build --tag sc-eureka:0.0.1 .
docker run --publish 8000:8000 --detach --name eureka sc-eureka:0.0.1
echo "project starting..."