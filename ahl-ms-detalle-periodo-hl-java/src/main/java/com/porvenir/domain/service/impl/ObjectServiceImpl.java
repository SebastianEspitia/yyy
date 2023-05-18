package com.porvenir.domain.service.impl;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.domain.dto.ErrorDto;
import com.porvenir.domain.service.ObjectService;
import com.porvenir.persistence.entity.CtaCuentaAporteEntity;
import com.porvenir.persistence.entity.VlaVidaLaboralAfpEntity;
import com.porvenir.persistence.repository.ObjectRepository;
import com.porvenir.persistence.entity.PersonEntity;
import com.porvenir.persistence.mappers.PersonMapper;
import com.porvenir.persistence.repository.ObjectRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {


    @Autowired
    private ObjectRepository objectRepository;



    @Override
    public List<CtaCuentaAporteEntity> functionCtaCuentaAporte(Integer cuentaId) {
        return objectRepository.ctaCuentaAporte(cuentaId);
    }

    @Autowired
    private ObjectRepository2 objectRepository2;

    @Override
    public List<VlaVidaLaboralAfpEntity> functionCtaCuentaAporte2(Integer cuentaId) {
        return objectRepository2.vlaVidaLaboralAfp(cuentaId);
    }

}