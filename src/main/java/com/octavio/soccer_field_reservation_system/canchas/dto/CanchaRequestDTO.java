package com.octavio.soccer_field_reservation_system.canchas.dto;

import com.octavio.soccer_field_reservation_system.canchas.enums.TipoCancha;
import com.octavio.soccer_field_reservation_system.canchas.enums.TipoSuelo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class CanchaRequestDTO {

    @NotBlank(message = "El tipo de cancha es obligatorio")
    private TipoCancha tipoCancha;

    @NotBlank(message = "El tipo de suelo es obligatorio")
    private TipoSuelo tipoSuelo;

    @NotBlank(message = "El precio por hora es obligatorio")
    @Positive(message = "El precio debe ser un valor positivo")
    private BigDecimal precioHora;

    @NotBlank(message = "La iluminacion es obligatoria")
    private boolean iluminacion;

    @NotBlank(message = "El id del complejo es obligatorio")
    private Long complejoId;
}
