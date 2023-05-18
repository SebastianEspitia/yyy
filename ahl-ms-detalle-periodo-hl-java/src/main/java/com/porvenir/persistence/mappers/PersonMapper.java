package com.porvenir.persistence.mappers;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.persistence.entity.PersonEntity;

public interface PersonMapper {
    PersonDto personEntityToDto(PersonEntity personEntity);
    PersonEntity personDtoToEntity(PersonDto personDto);
}