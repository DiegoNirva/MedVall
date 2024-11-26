package com.medvoll.apirest.DTO;

import com.medvoll.apirest.Model.Medico;

public record DatoListadoMedico(
        int id,
        String nombre,
        String especialidad,
        String documento,
        String email){

    public DatoListadoMedico(Medico medico ){
        this(
            medico.getId(),
            medico.getNombre(),
            medico.getEspecialidad().toString(),
            medico.getDocumento(),
            medico.getEmail());
    }
}
