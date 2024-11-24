package com.medvoll.apirest.Model;


public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion) {
}
