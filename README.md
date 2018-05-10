# DB2-project
University Database 2 II class project

## Description

This is a simple server with spring boot, it maps a relation between peoples and friends

## Setup

This project uses `postgre` as the default DB, to setup it you:
* Should have a database called `rede-social`
* Should edit the credentials at `src\main\resources\application.properties` to the one your postgre uses

## Build

You will need **maven** to generate the jar, and of course java to run it, the following sequence can run this project:

* To generate the project jar : `mvn package`
* To run the jar: `java -jar target\social-0.1.0.jar`

After that, you can access [http://localhost:8080/](http://localhost:8080/) to see if it is running fine.
