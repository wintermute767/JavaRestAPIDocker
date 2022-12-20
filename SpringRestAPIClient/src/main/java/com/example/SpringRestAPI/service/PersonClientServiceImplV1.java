package com.example.SpringRestAPI.service;

import com.example.SpringRestAPI.model.PersonV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class PersonClientServiceImplV1 implements PersonClientService<PersonV1> {

    @Autowired
    RestTemplate restTemplate;

    final String urlAddress;

    public PersonClientServiceImplV1() {
        this.urlAddress = System.getenv("URLADDRESSED")+"/api/v1/person/";
        System.out.println( System.getenv());
    }


    public PersonV1 getById(Long id) {
        System.out.println(restTemplate.getForEntity(urlAddress + "/" + id, PersonV1.class));
        ResponseEntity<PersonV1> response = restTemplate.getForEntity(urlAddress  + id, PersonV1.class);
        return  response.getBody();
    }

    public HttpStatus addPerson(PersonV1 person) {
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(urlAddress, person, HttpStatus.class);
        return response.getBody();
    }

    public void updatePerson(Long id, PersonV1 person) {
        restTemplate.put(urlAddress+id, person);
    }

    public void deletePerson(Long id) {
        restTemplate.delete(urlAddress + id);

    }
}
