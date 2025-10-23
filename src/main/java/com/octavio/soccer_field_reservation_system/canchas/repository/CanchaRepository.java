package com.octavio.soccer_field_reservation_system.canchas.repository;

import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {
}
