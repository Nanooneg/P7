FROM openjdk:8-alpine
MAINTAINER Nanoo (arnaudlaval33@gmail.com)
ADD target/server-gateway-0.0.1-SNAPSHOT.jar server-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8763
ENTRYPOINT ["java","-jar","server-gateway-0.0.1-SNAPSHOT.jar"]