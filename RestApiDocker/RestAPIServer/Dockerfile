FROM openjdk:17

WORKDIR /usr/src/app

RUN microdnf install git
RUN git clone https://github.com/wintermute767/SpringRestAPIServer.git .

ENV SPRING_PROFILES_ACTIVE=dev
ENV LOGGER=detail
RUN chown 777 ./mvnw && chmod +x ./mvnw && ./mvnw dependency:resolve

CMD env SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE,LOGGER=$LOGGER  ./mvnw spring-boot:run
