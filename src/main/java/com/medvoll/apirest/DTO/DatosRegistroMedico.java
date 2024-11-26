package com.medvoll.apirest.DTO;


import com.medvoll.apirest.Model.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroMedico(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{0,8}")
        String documento,
        @NotBlank
        String telefono,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion) {
}
