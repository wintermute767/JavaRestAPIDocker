package com.example.SpringRestAPI.service;

import com.example.SpringRestAPI.model.PersonV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class PersonClientServiceImplV2 implements PersonClientService<PersonV2> {

    @Autowired
    RestTemplate restTemplate;

    final String urlAddress;
    @Autowired
    public PersonClientServiceImplV2(   ) {
        this.urlAddress = System.getenv("URLADDRESSED")+"/api/v2/person/";
        System.out.println( System.getenv());
    }


    public PersonV2 getById(Long id) {
        System.out.println(restTemplate.getForEntity(urlAddress  + id, PersonV2.class));
        ResponseEntity<PersonV2> response = restTemplate.getForEntity(urlAddress + "/" + id, PersonV2.class);
        return response.getBody();
    }

    public HttpStatus addPerson(PersonV2 person) {
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(urlAddress, person, HttpStatus.class);
        return response.getBody();
    }

    public void updatePerson(Long id, PersonV2 person) {
        restTemplate.put(urlAddress+id, person);
    }

    public void deletePerson(Long id) {
        restTemplate.delete(urlAddress + id);

    }
}
