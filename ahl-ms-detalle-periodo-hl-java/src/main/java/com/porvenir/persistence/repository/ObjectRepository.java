package com.porvenir.persistence.repository;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.persistence.entity.PersonEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Integer> { // To change for model entity and dataType primary key
    List<PersonEntity> findAll();

    PersonEntity getById(Long id);

    PersonEntity save(PersonDto personDto) throws Exception;

    void deleteById(Long id);

    @Query("SELECT p FROM PersonEntity p WHERE p.nombre = :nombre")
    PersonEntity getByName(@Param("nombre") String nombre);
}