package com.dio.personapi.dto.mapper;

import com.dio.personapi.dto.response.PhoneDTO;
import com.dio.personapi.model.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toModel(PhoneDTO dto);

    PhoneDTO toDTO(Phone dto);
}
