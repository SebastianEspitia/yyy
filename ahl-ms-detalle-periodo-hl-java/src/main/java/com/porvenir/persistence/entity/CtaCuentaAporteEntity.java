package com.porvenir.persistence.entity;

import lombok.Data;
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
@Table(schema = "MCUENTAS", name = "CTA_CUENTA_APORTE")
public class CtaCuentaAporteEntity {
    @Id
    @Column(name = "CUENTA_APORTE_ID")
    private Integer CUENTA_APORTE_ID;
    @Column(name = "CUENTA_ID")
    private Integer CUENTA_ID;
    @Column(name = "FONDO_ID")
    private Integer FONDO_ID;
    @Column(name = "TIPO_ID_APORTANTE")
    private String TIPO_ID_APORTANTE;
    @Column(name = "NUMERO_ID_APORTANTE")
    private Integer NUMERO_ID_APORTANTE;
    @Column(name = "CODIGO_OPERACION_ID")
    private String CODIGO_OPERACION_ID;
    @Column(name = "FECHA_PAGO")
    private Date FECHA_PAGO;
    @Column(name = "ID_DISPONIBLE")
    private String ID_DISPONIBLE;
    @Column(name = "TIPO_COTIZANTE_ID")
    private String TIPO_COTIZANTE_ID;
    @Column(name = "PERIODO_PAGO")
    private Integer PERIODO_PAGO;
    @Column(name = "USUARIO_CREACION")
    private String USUARIO_CREACION;
    @Column(name = "FECHA_CREACION")
    private Date FECHA_CREACION;
    @Column(name = "MFONDOS_SCN")
    private Integer MFONDOS_SCN;
    @Column(name = "BANCO_PAGO")
    private String BANCO_PAGO;
    @Column(name = "OFICINA_PAGO")
    private String OFICINA_PAGO;
    @Column(name = "CAJA_PAGO")
    private Integer CAJA_PAGO;
    @Column(name = "FOLIO_PAGO")
    private Integer FOLIO_PAGO;
    @Column(name = "ENCABEZADO_PLANILLA_ID")
    private Integer ENCABEZADO_PLANILLA_ID;
    @Column(name = "SECUENCIA")
    private Integer SECUENCIA;
    @Column(name = "DEPOSITO_ID")
    private Integer DEPOSITO_ID;
    @Column(name = "SALARIO_BASE")
    private Integer SALARIO_BASE;
    @Column(name = "SALARIO_BASE_CAL")
    private Integer SALARIO_BASE_CAL;
    @Column(name = "DIAS_INFORMADO")
    private Integer DIAS_INFORMADO;
    @Column(name = "DIAS_CALCULADO")
    private Integer DIAS_CALCULADO;
    @Column(name = "CODIGO_AFP")
    private Integer CODIGO_AFP;
    @Column(name = "FECHA_PAGO_OTRO_FONDO")
    private Date FECHA_PAGO_OTRO_FONDO;
    @Column(name = "USUARIO_ULTIMA_MODIFICACION")
    private String USUARIO_ULTIMA_MODIFICACION;
    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    private Date FECHA_ULTIMA_MODIFICACION;
}
