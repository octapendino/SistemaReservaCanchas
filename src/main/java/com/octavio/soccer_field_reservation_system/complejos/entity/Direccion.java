package com.octavio.soccer_field_reservation_system.complejos.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Direccion {

    private String provincia;
    private String localidad;
    private String calle;
    private String numero;

}
