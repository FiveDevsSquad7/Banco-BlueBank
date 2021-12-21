FROM openjdk:18-slim
#WORKDIR /app
ARG JAR_FILE
#COPY target/${JAR_FILE} /app/bluebank_api.jar
ADD target/${JAR_FILE} bluebank.jar
EXPOSE 8080
#EXPOSE 8443
#CMD ["java", "-jar", "bluebank_api.jar"]
CMD ["java", "-jar", "bluebank.jar"]