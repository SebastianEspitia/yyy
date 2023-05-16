package com.porvenir.domain.service.impl;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.domain.dto.ErrorDto;
import com.porvenir.domain.service.ObjectService;
import com.porvenir.persistence.repository.ObjectRepository;
import com.porvenir.persistence.entity.PersonEntity;
import com.porvenir.persistence.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    // Maximum 7 atributte declarations
    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private PersonMapper personMapper;

    /**
     * Describe method with java docs
     * @return
     */
     @Override
    public List<PersonDto> findAll() {
        List<PersonEntity> personEntity = objectRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (PersonEntity person: personEntity){
            personDtoList.add(personMapper.personEntityToDto(person));
        }
        return personDtoList;
    }

    /**
     * Describe method with java docs
     * @return
     */
    @Override
    public PersonDto getById(Long id) {
        return personMapper.personEntityToDto(objectRepository.getById(id));
    }

    /**
     * Describe method with java docs
     * @return
     */
    @Override
    public PersonDto save(PersonDto personDto) throws Exception {
        PersonEntity personEntity = objectRepository.save(personDto);
        return personMapper.personEntityToDto(personEntity);
    }

    /**
     * Describe method with java docs
     * @return
     */
    @Override
    public void deleteById(Long id) {
        objectRepository.deleteById(id);
    }
}