# Restful webservice

It provides some user management operations:

## HTTP Methods

### POST
```
/addUser
/updateUser
/getAllUser
/deleteUser
```

## Version of used technologies
```
java 1.8.0_31
SpringBoot 1.5.8.RELEASE
Gradlew 3.5.1
hibernate-core 5.0.12
hibernate-jpa-2.1-api-1.0.0.Final
jackson-core-2.8.10
MySQL 5.7.20.0
mysql-connector-java-5.1.44
```

## Other features

```
Hexagonal architecture
Custom and centralized handler Exceptions
Mockito
JPA (Hibernate: by default every time the webservice is deployed the model is rewriten to the database)
Some tests implemented to verify (Controller, DTOAssembler, ContextApplication)
```


