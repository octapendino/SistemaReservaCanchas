package com.octavio.soccer_field_reservation_system.canchas.service;

import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaRequestDTO;
import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaResponseDTO;
import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import com.octavio.soccer_field_reservation_system.canchas.mappers.CanchaMapper;
import com.octavio.soccer_field_reservation_system.canchas.repository.CanchaRepository;
import com.octavio.soccer_field_reservation_system.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaService implements ICanchaService{

    private final CanchaRepository canchaRepository;
    private final CanchaMapper canchaMapper;

    public CanchaService(CanchaRepository canchaRepository,
                         CanchaMapper canchaMapper){
        this.canchaRepository = canchaRepository;
        this.canchaMapper = canchaMapper;
    }


    @Override
    public CanchaResponseDTO getCanchaById(Long canchaId) {
        Cancha cancha = canchaRepository.findById(canchaId).orElseThrow(() -> new NotFoundException("Cancha no encontrada"));
        CanchaResponseDTO canchaResponse = canchaMapper.canchaToResponseDTO(cancha);
        return canchaResponse;
    }

    @Override
    public List<CanchaResponseDTO> getCanchasByComplejoId(Long complejoId) {
        return List.of();
    }

    @Override
    public CanchaResponseDTO createCancha(CanchaRequestDTO cancha) {
        return null;
    }

    @Override
    public CanchaResponseDTO updateCancha(CanchaRequestDTO cancha) {
        return null;
    }

    @Override
    public void deleteCancha(Long canchaId) {

    }
}
