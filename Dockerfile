FROM openjdk:11
EXPOSE 8081
LABEL MAINTAINER="MARGRETH MARTINS "peggymeggy04@yahoo.com""
ENV spring.datasource.url=jdbc:mysql://mysqldb:3306/fashion_Blog
ENV spring.datasource.username=root
ENV spring.datasource.password=Agirllikeme04
COPY ./target/Blog_App-0.0.1-SNAPSHOT.jar /opt/Fashion_Blog-0.0.1.jar
COPY . /opt/
ENTRYPOINT ["java", "-jar", "/opt/Fashion_Blog-0.0.1.jar", "--server.port=8082", "--spring.config.location=file:/opt/src/main/resources/"]