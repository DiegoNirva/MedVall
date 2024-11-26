package com.medvoll.apirest.DTO;

public record DatosResgistroPaciente(
        String nombre,
        String email,
        String telefono,
        String documentoIdentidad,
        DatosDireccion direccion
)
 {
}
