package com.medvoll.apirest.Controller;

import com.medvoll.apirest.DTO.DatoActualizarMedico;
import com.medvoll.apirest.DTO.DatoListadoMedico;
import com.medvoll.apirest.DTO.DatosRegistroMedico;
import com.medvoll.apirest.Model.Medico;
import com.medvoll.apirest.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listarMedicos")
    HttpEntity<PagedModel <DatoListadoMedico>>listaMedicos(Pageable pageable, PagedResourcesAssembler assembler){
        Page<Medico> pageListadoMedicos =  medicoRepository.findByActivoTrue(pageable);
        Page<DatoListadoMedico> datoListadoMedico = pageListadoMedicos.map(DatoListadoMedico::new);
        return ResponseEntity.ok(assembler.toModel(datoListadoMedico));
    }

    @PutMapping("/actualizarMedico")
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatoActualizarMedico datoActualizarMedico){
        Medico medico = medicoRepository.getReferenceById(datoActualizarMedico.id());
        medico.actualizarMedico(datoActualizarMedico);
    }

    @DeleteMapping("/eliminarMedico/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable int id){
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico(medico);
    }

}
