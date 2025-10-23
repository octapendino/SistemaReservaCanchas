package com.octavio.soccer_field_reservation_system.complejos.service;

import com.octavio.soccer_field_reservation_system.canchas.enums.TipoCancha;
import com.octavio.soccer_field_reservation_system.complejos.dto.ComplejoRequestDTO;
import com.octavio.soccer_field_reservation_system.complejos.dto.ComplejoResponseDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IComplejoService {

    ComplejoResponseDTO getComplejoById (Long complejoId);
    List<ComplejoResponseDTO> getAllComplejos();
    List<ComplejoResponseDTO> getComplejosByUserId (Long userId);
    List<ComplejoResponseDTO> getComplejosConCanchasDisponiblesPorFechaYTipo (LocalDate fecha, LocalTime horaInicio, TipoCancha tipoCancha, String localidad);
    ComplejoResponseDTO createComplejo (ComplejoRequestDTO complejo);
    ComplejoResponseDTO updateComplejo (ComplejoRequestDTO complejo);
    void deleteComplejo (Long complejoId);

}
