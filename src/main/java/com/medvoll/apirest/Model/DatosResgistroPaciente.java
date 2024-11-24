package com.medvoll.apirest.Model;

public record DatosResgistroPaciente(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad,
        DatosDireccion direccion
)
 {
}
