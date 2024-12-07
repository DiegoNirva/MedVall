package com.medvoll.apirest.Model;

import com.medvoll.apirest.DTO.DatoActualizarMedico;
import com.medvoll.apirest.DTO.DatosRegistroMedico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "medicos")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String email;
    private String documento;
    private String telefono;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico){
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.documento = datosRegistroMedico.documento();
        this.telefono = datosRegistroMedico.telefono();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }


    public Medico actualizarMedico(DatoActualizarMedico datoActualizarMedico) {
        if(datoActualizarMedico.nombre() != null){
            this.nombre = datoActualizarMedico.nombre();
        }
        if(datoActualizarMedico.documento() != null){
            this.documento = datoActualizarMedico.documento();
        }
        if(datoActualizarMedico.direccion() != null){
            this.direccion = direccion.actualizarDatos(datoActualizarMedico.direccion());
        }
        return this;
    }

    public void desactivarMedico(Medico medico) {
        this.activo = false;
    }
}
