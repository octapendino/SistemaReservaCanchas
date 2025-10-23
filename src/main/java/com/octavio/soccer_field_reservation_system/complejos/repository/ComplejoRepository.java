package com.octavio.soccer_field_reservation_system.complejos.repository;

import com.octavio.soccer_field_reservation_system.complejos.entity.Complejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplejoRepository extends JpaRepository<Complejo,Long> {
}
