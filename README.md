# expenses
![example workflow](https://github.com/wsosna/expenses/actions/workflows/test.yml/badge.svg)

Simple API to manage expenses with Its categories.

## Requirements
- Java 17
- Maven
- Docker

## Run locally
### Setup database
To setup database please go to directory `docker` and run
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


