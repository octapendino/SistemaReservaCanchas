package com.octavio.soccer_field_reservation_system.canchas.dto;

import com.octavio.soccer_field_reservation_system.canchas.enums.TipoCancha;
import com.octavio.soccer_field_reservation_system.canchas.enums.TipoSuelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CanchaResponseDTO {
    private Long id;
    private String nombre;
    private TipoCancha tipoCancha;
    private TipoSuelo tipoSuelo;
    private BigDecimal precioHora;
    private boolean iluminacion;
}
