package com.medvoll.apirest.DTO;

public record DatoActualizarMedico(
        int id,
        String nombre,
        String documento,
        DatosDireccion direccion) {

}
