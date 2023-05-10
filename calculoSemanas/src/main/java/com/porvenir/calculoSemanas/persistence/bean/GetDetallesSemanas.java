package com.porvenir.calculoSemanas.persistence.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
@Log4j2
public class GetDetallesSemanas {
/*

    private DataSource datasource;
*/

    public void generateSecuencia(Integer numeroCuenta) {
/*
        String sentence = "select * from mhistoria.semanas_historia_laboral.get_detalles_y_semanas(" + numeroCuenta + ")";
        Connection connection = null;
        try {
            connection = datasource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sentence);
            ResultSet rs = ps.executeQuery();
            rs.next();
        } catch (Exception e) {
        }
*/
    }


}
