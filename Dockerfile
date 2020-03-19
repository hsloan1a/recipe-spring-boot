FROM maven:3.6-jdk-14
RUN mkdir -p /recipe
WORKDIR /recipe/
COPY ./recipe /recipe/
RUN mvn clean install
