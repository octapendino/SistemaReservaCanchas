package com.octavio.soccer_field_reservation_system.canchas.service;

import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaRequestDTO;
import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaResponseDTO;

import java.util.List;

public interface ICanchaService {

    CanchaResponseDTO getCanchaById (Long canchaId);
    List<CanchaResponseDTO> getCanchasByComplejoId (Long complejoId);
    CanchaResponseDTO createCancha (CanchaRequestDTO cancha);
    CanchaResponseDTO updateCancha (CanchaRequestDTO cancha);
    void deleteCancha (Long canchaId);
}
