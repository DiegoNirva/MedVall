package com.medvoll.apirest.Controller;

import com.medvoll.apirest.Model.DatosRegistroMedico;
import com.medvoll.apirest.Model.Medico;
import com.medvoll.apirest.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico medicos){
        medicoRepository.save(new Medico(medicos));
        System.out.println("Registro guardado correctamente");
        System.out.println(medicos);
}

}
