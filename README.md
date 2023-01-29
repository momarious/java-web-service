# Java Web Service
A Java web service built using Maven and the MySQL Connector.

## Overview
This Java web service is a simple project management tool that allows you to manage notes for your projects. The project uses Maven for build and dependency management, and the MySQL Connector for database connectivity. The application is packaged as a WAR file for deployment to a servlet container.

## Prerequisites
- Java 8 or higher
- Maven
- MySQL database

## Dependencies
The project has the following dependency:

```
- MySQL Connector: mysql-connector-java:5.1.23

## Build
To build the project, run the following command in the project root directory:

Copy code
mvn clean install
This will compile the source code, run tests (if any), and package the application as a WAR file in the target directory.

## Deployment
To deploy the application, copy the WAR file to the webapps directory of a servlet container, such as Apache Tomcat. The application can then be accessed at the following URL:

javascript
http://localhost:8080/GestionDesNotes
Configuration
The database connection properties (such as the URL, username, and password) are typically stored in a configuration file and loaded at runtime.
