# Spring Boot & Angular Demo Application - 'Project Manager' Tool by Tomasz Gomoradzki

Relatively simple tool allowing to manage Project work, tasks, sub tasks, team members, sending updates.
Application uses embeded H2 database. After being built application can be launched and tested (see details below).


Deployment and running:

Project directory structure is divided into two main parts:

- 'angular-front-end', which is Angular front-end
- 'spring-boot-demo-api', which is Spring Boot back-end rest api

It is set up to be built using Maven into one WAR file, produced in /spring-boot-demo/target directory To do that:

1. clone the project
2. go to project api directory: '/spring-boot-demo/spring-boot-demo-api'
3. build the project in with command: 'mvn clean package', 'mvn install'. This will produce one WAR file in target directory
4. run application with command: 'java -jar target/spring-boot-demo-0.0.1-SNAPSHOT.war'

In project directory '/spring-boot-demo/war-backup', already built WAR file has been saved for review and testing purposes.

Application is configured to be launched at:

'http://localhost:8080'



Technologies used and some of the concepts deployed:

- Java 11
- Spring Boot 2.1
- H2 Database
- Angular 8
- Maven 3
