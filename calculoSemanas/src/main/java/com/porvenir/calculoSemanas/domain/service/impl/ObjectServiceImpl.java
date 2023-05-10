package com.porvenir.calculoSemanas.domain.service.impl;

import com.porvenir.calculoSemanas.persistence.bean.GetDetallesSemanas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl {
    @Autowired
    GetDetallesSemanas getDetallesSemanas;
 public void getAllDetalleSemanas(Integer reqNumeroCuenta){
     getDetallesSemanas.generateSecuencia(reqNumeroCuenta);
 }

}
