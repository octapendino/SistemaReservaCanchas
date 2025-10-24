package com.octavio.soccer_field_reservation_system.canchas.repository;

import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {
    List<Cancha> findByComplejoId(Long complejoId);
    boolean existsByNombreIgnoreCaseAndComplejoId(String nombre, Long complejoId);
}
