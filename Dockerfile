FROM bellsoft/liberica-openjdk-alpine-musl:17
MAINTAINER wsosna
COPY target/expenses-0.0.1-SNAPSHOT.jar expenses-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/expenses-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080