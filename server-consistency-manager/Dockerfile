FROM openjdk:8-alpine
MAINTAINER Nanoo (arnaudlaval33@gmail.com)
ADD target/server-consistency-manager-0.0.1-SNAPSHOT.jar server-consistency-manager-0.0.1-SNAPSHOT.jar
EXPOSE 9101
ENTRYPOINT ["java","-jar","server-consistency-manager-0.0.1-SNAPSHOT.jar"]