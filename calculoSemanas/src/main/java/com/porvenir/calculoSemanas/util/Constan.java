package com.porvenir.calculoSemanas.util;

public interface Constan {

    //mensajes salida para servicio

    String NO_CONTENT = "No se encontraron coincidencias para la consulta.";

    String NOT_ACCEPTABLE = "Error en los parametros de entrada, los datos no son validos.";

    String TIMEOUT = "La peticion tomo mas tiempo de lo esperado";

    String INTERNAL_SERVER_ERROR = "Errores Internos o no controlados: ";

    String SUCCESS = "Peticion procesada exitosamente.";
    Integer CODE_SUCCESS = 201;

    String INVALID_INPUT = "Error en los parametros de entrada, los datos no son validos";
    Integer CODE_INVALID_INPUT = 400;
    String NO_CONTINUE = "No se encontraron datos de contacto para procesar la solicitud";

}
