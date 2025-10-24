package com.octavio.soccer_field_reservation_system.canchas.service;

import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaRequestDTO;
import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaResponseDTO;
import com.octavio.soccer_field_reservation_system.canchas.dto.CanchaUpdateRequestDTO;
import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import com.octavio.soccer_field_reservation_system.canchas.mappers.CanchaMapper;
import com.octavio.soccer_field_reservation_system.canchas.repository.CanchaRepository;
import com.octavio.soccer_field_reservation_system.complejos.dto.ComplejoResponseDTO;
import com.octavio.soccer_field_reservation_system.complejos.entity.Complejo;
import com.octavio.soccer_field_reservation_system.complejos.service.IComplejoService;
import com.octavio.soccer_field_reservation_system.exceptions.BadRequestException;
import com.octavio.soccer_field_reservation_system.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanchaService implements ICanchaService{

    private final CanchaRepository canchaRepository;
    private final CanchaMapper canchaMapper;
    private final IComplejoService complejoService;

    public CanchaService(CanchaRepository canchaRepository,
                         CanchaMapper canchaMapper,
                         IComplejoService complejoService){
        this.canchaRepository = canchaRepository;
        this.canchaMapper = canchaMapper;
        this.complejoService = complejoService;
    }


    @Override
    public CanchaResponseDTO getCanchaById(Long canchaId) {
        Cancha cancha = canchaRepository.findById(canchaId).orElseThrow(
                () -> new NotFoundException("Cancha no encontrada con id " + canchaId));
        CanchaResponseDTO canchaResponse = canchaMapper.canchaToResponseDTO(cancha);
        return canchaResponse;
    }

    @Override
    public List<CanchaResponseDTO> getCanchasByComplejoId(Long complejoId) {
        ComplejoResponseDTO complejo = complejoService.getComplejoById(complejoId);
        List<Cancha> canchasComplejo = canchaRepository.findByComplejoId(complejo.getId());

        return canchasComplejo.stream()
                .map(canchaMapper::canchaToResponseDTO)
                .toList();
    }

    @Override
    public CanchaResponseDTO createCancha(CanchaRequestDTO cancha) {
        Complejo complejo = complejoService.getEntityComplejoById(cancha.getComplejoId());
        Cancha canchaToSave = canchaMapper.DTORequestToCancha(cancha,complejo);
        Cancha canchaSaved = canchaRepository.save(canchaToSave);
        return canchaMapper.canchaToResponseDTO(canchaSaved);
    }

    @Override
    public CanchaResponseDTO updateCancha(Long canchaId, CanchaUpdateRequestDTO cancha) {

        Cancha currentCancha = canchaRepository.findById(canchaId).orElseThrow(
                () -> new NotFoundException("Cancha no encontrada con id " + canchaId));

        if(!cancha.getNombre().equalsIgnoreCase(currentCancha.getNombre()) &&
                canchaRepository.existsByNombreIgnoreCaseAndComplejoId(cancha.getNombre(),currentCancha.getComplejo().getId())){
            throw new BadRequestException("Ya existe una cancha con el nombre " + cancha.getNombre() + " para este complejo");
        }

        currentCancha.setNombre(cancha.getNombre());
        currentCancha.setTipoCancha(cancha.getTipoCancha());
        currentCancha.setTipoSuelo(cancha.getTipoSuelo());
        currentCancha.setCubierta(cancha.isCubierta());
        currentCancha.setIluminacion(cancha.isIluminacion());
        currentCancha.setPrecioPorHora(cancha.getPrecioHora());

        Cancha canchaUpdated = canchaRepository.save(currentCancha);

        return canchaMapper.canchaToResponseDTO(canchaUpdated);
    }

    @Override
    public void deleteCancha(Long canchaId) {
        Cancha canchaToDelete = canchaRepository.findById(canchaId).orElseThrow(
                () -> new NotFoundException("Cancha no encontrada con id " + canchaId));
        canchaRepository.delete(canchaToDelete);
    }
}
