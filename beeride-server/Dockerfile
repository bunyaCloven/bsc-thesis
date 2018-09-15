FROM maven:3.5.4-jdk-8-alpine

# TODO: copy m2 folder.

# 
RUN mkdir ~/beeride
WORKDIR ~/beeride

COPY ./pom.xml ./pom.xml
RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY ./src ./src
RUN mvn -B package

ENTRYPOINT ls target && java -Djava.net.preferIPv4Stack=true -jar ./target/beeride.jar