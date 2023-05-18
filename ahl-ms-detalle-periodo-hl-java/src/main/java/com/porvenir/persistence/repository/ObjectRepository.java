package com.porvenir.persistence.repository;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.persistence.entity.CtaCuentaAporteEntity;
import com.porvenir.persistence.entity.PersonEntity;

import com.porvenir.persistence.entity.VlaVidaLaboralAfpEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ObjectRepository extends CrudRepository<CtaCuentaAporteEntity, Integer> { // To change for model entity and dataType primary key

    @Query(value = "SELECT * FROM MCUENTAS.CTA_CUENTA_APORTE A WHERE A.CUENTA_ID = (?1)", nativeQuery = true)
    List<CtaCuentaAporteEntity> ctaCuentaAporte(Integer cuentaId);


}