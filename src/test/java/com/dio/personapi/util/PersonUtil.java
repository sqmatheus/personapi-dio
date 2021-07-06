package com.dio.personapi.util;

import com.dio.personapi.dto.response.PersonDTO;
import com.dio.personapi.model.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class PersonUtil {

    private static final String FIRST_NAME = "José";
    private static final String LAST_NAME = "Oliveira";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1977, 3, 5);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("01-01-2001")
                .phones(Collections.singletonList(PhoneUtil.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtil.createFakeEntity()))
                .build();
    }
}
