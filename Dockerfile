FROM openjdk:11


RUN mkdir -p /apps


COPY ./target/shop-0.0.1-SNAPSHOT.jar /apps/app.jar

EXPOSE 8080

CMD ["java","-jar","apps/app.jar"]