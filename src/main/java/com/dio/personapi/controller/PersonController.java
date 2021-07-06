package com.dio.personapi.controller;

import com.dio.personapi.dto.response.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.model.Person;
import com.dio.personapi.service.PersonService;
import com.dio.personapi.util.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getPersonById()  {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable("id") Long personId) throws PersonNotFoundException {
        return personService.findById(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PutMapping("/{id}")
    public MessageResponse updatePerson(@PathVariable("id") Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.update(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable("id") Long personId) throws PersonNotFoundException {
        personService.deleteById(personId);
    }

    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<MessageResponse> handleResponseStatusException(ResponseStatusException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(new MessageResponse(exception));
    }

}
