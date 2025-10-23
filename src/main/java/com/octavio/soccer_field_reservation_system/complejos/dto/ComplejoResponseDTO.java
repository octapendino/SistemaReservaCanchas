package com.octavio.soccer_field_reservation_system.complejos.dto;

import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import com.octavio.soccer_field_reservation_system.complejos.entity.Direccion;
import com.octavio.soccer_field_reservation_system.franjas_horarias.entity.FranjaHoraria;
import com.octavio.soccer_field_reservation_system.servicios.entity.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class ComplejoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Direccion direccion;
    private Set<Servicio> servicios = new HashSet<>();
    private Set<Cancha> canchas = new HashSet<>();
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();
}
