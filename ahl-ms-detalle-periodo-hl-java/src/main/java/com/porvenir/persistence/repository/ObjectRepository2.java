package com.porvenir.persistence.repository;

import com.porvenir.persistence.entity.CtaCuentaAporteEntity;
import com.porvenir.persistence.entity.VlaVidaLaboralAfpEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository2 extends CrudRepository<VlaVidaLaboralAfpEntity, Integer> {

    @Query(value = "SELECT A.* FROM CSIAFP.VLA_VIDA_LABORAL_AFP A WHERE A.NUMERO_CUENTA =(?1)", nativeQuery = true)
    List<VlaVidaLaboralAfpEntity> vlaVidaLaboralAfp(Integer numeroCuenta);
}
