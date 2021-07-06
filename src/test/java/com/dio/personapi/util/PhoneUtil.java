package com.dio.personapi.util;

import com.dio.personapi.dto.response.PhoneDTO;
import com.dio.personapi.enums.PhoneType;
import com.dio.personapi.model.Phone;

public class PhoneUtil {

    private static final String PHONE_NUMBER = "(11)91111-2222";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .phoneType(PHONE_TYPE)
                .build();
    }
}
