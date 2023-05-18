package com.porvenir.domain.service;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.persistence.entity.CtaCuentaAporteEntity;
import com.porvenir.persistence.entity.VlaVidaLaboralAfpEntity;

import java.util.ArrayList;
import java.util.List;

public interface ObjectService {

    List<CtaCuentaAporteEntity> functionCtaCuentaAporte(Integer cuentaId);
    List<VlaVidaLaboralAfpEntity> functionCtaCuentaAporte2(Integer cuentaId);

}