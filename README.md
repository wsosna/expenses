# expenses
![example workflow](https://github.com/wsosna/expenses/actions/workflows/test.yml/badge.svg)

Simple API to manage expenses with Its categories.

## Requirements
- Java 17
- Maven
- Docker

## Run locally
### Docker
To run application and Its database with one command you can use docker. 
Just go to `/docker` directory and execute
```shell
docker-compose up
```

### Setup database
To setup database and decide later to run application with docker or with local maven please go to directory `/docker` 
and run
```shell
docker-compose up -d db
```

### Run application
Next you should go back to root folder and build project with
```shell
mvn install
```
And run application with
```shell
mvn spring-boot:run
```

## API Documentation
This project implements Open API (Swagger), so you can access full API documentation at this url

http://localhost:8080/swagger-ui.html



