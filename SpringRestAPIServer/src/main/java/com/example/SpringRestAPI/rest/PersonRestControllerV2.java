package com.example.SpringRestAPI.rest;


import com.example.SpringRestAPI.model.PersonV1;
import com.example.SpringRestAPI.model.PersonV2;
import com.example.SpringRestAPI.service.PersonService;
import com.example.SpringRestAPI.service.logService.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2/person/")
public class PersonRestControllerV2 {
    @Autowired
    Logger logger;
    @Autowired
    private PersonService<PersonV2> personService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonV1> getPerson(@PathVariable("id") Integer id) {

        logger.log("GET", id.toString());

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PersonV1 person = this.personService.read(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonV2> savePerson(@Validated @RequestBody PersonV2 person) {

        logger.log("POST", person.toString());

        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonV2> updatePerson(@PathVariable("id") Integer id, @Validated @RequestBody  PersonV2 person) {

        logger.log("PUT", id.toString() + " " + person.toString());

        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            this.personService.update(id, person);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonV2> deletePerson(@PathVariable("id") Integer id) {

        logger.log("DELETE", id.toString());

        PersonV2 person = this.personService.read(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
