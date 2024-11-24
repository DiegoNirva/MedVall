package com.medvoll.apirest.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Direccion {

    private String calle;
    private String districto;
    private String ciudad;
    private String numero;
    private String complemento;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.districto = direccion.districto();
        this.ciudad = direccion.ciudad();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }
}
