# Project to manager data person using Java 11 with Spring boot

This is a Micro Service to manager information person like contacts, address, documents and parents relationship.

The system messages were made in an internationalized way, the default is en_US and the locale can be changed using the Accept-Language header.

Database: PostgreSql.

The complete documentation is in the swagger:
http://localhost:8080/swagger-ui.html

The project has three profiles:
- test
- dev
- prod

Command to generate file jar:

`./mvnw clean package`

This project has a Dockerfile to build a image, below has a exemple:

`docker build -t sb/msperson --build-arg PATH_FILE_JAR=./target/ms-person-0.0.1-SNAPSHOT.jar --build-arg NEW_NAME_FILE_JAR=msperson.jar .`
