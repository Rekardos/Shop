FROM openjdk:11
ARG JAR_FILE
RUN mkdir -p /apps
COPY ./target/${JAR_FILE} /apps/app.jar
CMD ["java","-jar","apps/app.jar"]