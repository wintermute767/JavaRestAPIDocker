FROM openjdk:17

WORKDIR /usr/src/app

RUN microdnf install git
RUN git clone https://github.com/wintermute767/SpringRestAPIServer.git .


RUN chown 777 ./mvnw && chmod +x ./mvnw && ./mvnw dependency:resolve

CMD ["./mvnw", "spring-boot:run"]