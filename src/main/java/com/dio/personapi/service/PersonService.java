package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.response.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.model.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.util.MessageResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponse create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        return new MessageResponse("Person successfully created with ID", savedPerson.getId());
    }

    public PersonDTO findById(Long personId) throws PersonNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
        return personMapper.toDTO(person);
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponse update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person person = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(person);

        return new MessageResponse("Person successfully updated with ID", updatedPerson.getId());
    }

    public void deleteById(Long personId) throws PersonNotFoundException {
        personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));

        personRepository.deleteById(personId);
    }

}
