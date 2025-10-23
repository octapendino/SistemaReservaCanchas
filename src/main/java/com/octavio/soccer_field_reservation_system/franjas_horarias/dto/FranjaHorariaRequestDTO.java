package com.octavio.soccer_field_reservation_system.franjas_horarias.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.octavio.soccer_field_reservation_system.franjas_horarias.enums.DiasSemana;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
public class FranjaHorariaRequestDTO {

    @NotNull(message = "El dia de la semana es obligatorio")
    private DiasSemana diaSemana;

    @NotNull(message = "La hora de inicio de la franja horaria es obligatoria")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin de la franja horaria es obligatoria")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaFin;

    @NotNull(message = "La id del complejo es obligatoria")
    private Long complejoId;
}
