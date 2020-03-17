FROM maven:3.6-jdk-14
RUN mkdir -p /recipe
WORKDIR /recipe/
COPY ./recipe /recipe/
RUN ls
RUN mvn clean install
# RUN mvn spring-boot:run -Dagentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:4000
