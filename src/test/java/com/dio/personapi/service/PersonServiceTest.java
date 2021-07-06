package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.response.PersonDTO;
import com.dio.personapi.model.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.util.MessageResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.dio.personapi.util.PersonUtil.createFakeDTO;
import static com.dio.personapi.util.PersonUtil.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponse expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
        MessageResponse successMessage = personService.create(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponse createExpectedSuccessMessage(Long savedPersonId) {
        return new MessageResponse("Person successfully created with ID", savedPersonId);
    }

}
