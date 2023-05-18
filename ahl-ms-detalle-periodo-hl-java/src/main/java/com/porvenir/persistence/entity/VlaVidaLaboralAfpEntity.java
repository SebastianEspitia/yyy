package com.porvenir.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(schema = "CSIAFP", name = "VLA_VIDA_LABORAL_AFP")
public class VlaVidaLaboralAfpEntity {
    @Id
    @Column(name = "NUMERO_CUENTA")
    private Integer NUMERO_CUENTA;
    @Column(name = "TIPO_ID_APORTANTE")
    private String TIPO_ID_APORTANTE;
    @Column(name = "NUM_ID_APORTANTE")
    private Integer NUM_ID_APORTANTE;
    @Column(name = "PERIODO_PAGO")
    private Integer PERIODO_PAGO;
    @Column(name = "SALARIO_BASE")
    private Integer SALARIO_BASE;
    @Column(name = "CONSECUTIVO_VIDA_LABORAL")
    private Integer CONSECUTIVO_VIDA_LABORAL;
    @Column(name = "DIAS_COTIZADOS")
    private Integer DIAS_COTIZADOS;
    @Column(name = "VALOR_COTIZACION_OBLIGATORIA")
    private Integer VALOR_COTIZACION_OBLIGATORIA;
    @Column(name = "AFP_REPORTE")
    private String AFP_REPORTE;
    @Column(name = "TIPO_AFILIADO")
    private Integer TIPO_AFILIADO;
    @Column(name = "PERIODO_FINAL")
    private Date PERIODO_FINAL;
    @Column(name = "PERIODO_INICIAL")
    private Date PERIODO_INICIAL;
    @Column(name = "RAZON_SOCIAL_APORTANTE")
    private String RAZON_SOCIAL_APORTANTE;
    @Column(name = "TIPO_ID_AFILIADO")
    private String TIPO_ID_AFILIADO;
    @Column(name = "NUM_ID_AFILIADO")
    private Integer NUM_ID_AFILIADO;
    @Column(name = "SALARIO_BASE_CALCULADO")
    private Integer SALARIO_BASE_CALCULADO;
    @Column(name = "DIAS_CALCULADOS")
    private Integer DIAS_CALCULADOS;

}
