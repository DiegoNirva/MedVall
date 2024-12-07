package com.medvoll.apirest.Controller;

import com.medvoll.apirest.DTO.DatosResgistroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    @PostMapping
    public void registroPaciente(@RequestBody DatosResgistroPaciente paciente){
        System.out.println("Registro exitoso");
        System.out.println(paciente);
    }
}
