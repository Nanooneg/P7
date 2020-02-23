# P7
OC project n°7 from DA JAVA cursus

## Présentation
This repository contain a SI for libraries.

It made of microservices, a web application and a batch. 

![architecture diagram](p7-architecture-diagram.jpg)

## Devolopement
It has been developed with IntelliJ IDEA 2019.3.3 (Ultimate Edition) and Java JDK 1.8.0_231.

I use SpringBoot 2.2.4.RELEASE and diverse dependencies in many of the services. 
You find details in pom.xml files.

## Installation & Run
- Import all services contained in the repository.
- DB : ms-account/ms-book/ms-loan/server-authentication require a PostgreSql data source. 
You need to create one per services and add your configuration in application.properties file
for each of them (db-address/user/password). 
There is some data for the demo in data.sql files launched at the start.



- First, run server-eureka, then all services except server-gateway you have to run lastly.
You can access to the web application at port localhost:8080 from your web browser if you don't 
have change the server.port properties in it application.properties file.

You will find the configuration.properties files in each services :
src/main/resources/application.properties.

## Version 1.0-SNAPSHOT

## Author : NanoO