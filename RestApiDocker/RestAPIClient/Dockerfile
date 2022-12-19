FROM openjdk:17

WORKDIR /usr/src/app

RUN microdnf install git && microdnf install curl
RUN git clone https://github.com/wintermute767/SpringRestAPIClient.git .

RUN chown 777 ./mvnw && chmod +x ./mvnw && ./mvnw dependency:resolve
RUN ./mvnw spring-boot:run
CMD ["app"]