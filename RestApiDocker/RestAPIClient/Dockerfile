FROM openjdk:17

WORKDIR /usr/src/app

RUN microdnf install git
RUN git clone https://github.com/wintermute767/SpringRestAPIClient.git  .


ENV URLADDRESSED=http://server:8443

RUN chown 777 ./mvnw && chmod +x ./mvnw && ./mvnw dependency:resolve

CMD env URLADDRESSED=$URLADDRESSED  ./mvnw spring-boot:run
