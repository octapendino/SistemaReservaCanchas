package com.octavio.soccer_field_reservation_system.canchas.mappers;

import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaResponseDTO;
import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import org.springframework.stereotype.Component;

@Component
public class CanchaMapper {

    public CanchaResponseDTO canchaToResponseDTO(Cancha cancha){
        return CanchaResponseDTO.builder()
                .id(cancha.getId())
                .nombre(cancha.getNombre())
                .tipoCancha(cancha.getTipoCancha())
                .tipoSuelo(cancha.getTipoSuelo())
                .precioHora(cancha.getPrecioPorHora())
                .iluminacion(cancha.isIluminacion())
                .build();
    }
}
