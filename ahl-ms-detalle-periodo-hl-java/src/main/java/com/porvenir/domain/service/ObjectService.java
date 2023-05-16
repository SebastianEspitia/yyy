package com.porvenir.domain.service;

import com.porvenir.domain.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

public interface ObjectService {

    List<PersonDto> findAll();

    PersonDto getById(Long id);

    PersonDto save(PersonDto personDto) throws Exception ;

    void deleteById(Long id);
}