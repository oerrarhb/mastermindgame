FROM openjdk:11
MAINTAINER Othmane ERRARHBI (othmane.errarhbi@gmail.com)
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /deploy/pom.xml
COPY src /deploy/src
WORKDIR /deploy
RUN mvn clean package
ENTRYPOINT ["./target/tm-deploy/bin/play-game"]
