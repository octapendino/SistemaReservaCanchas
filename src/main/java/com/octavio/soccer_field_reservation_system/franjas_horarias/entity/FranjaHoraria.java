package com.octavio.soccer_field_reservation_system.franjas_horarias.entity;

import com.octavio.soccer_field_reservation_system.complejos.entity.Complejo;
import com.octavio.soccer_field_reservation_system.franjas_horarias.enums.DiasSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FranjaHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DiasSemana diaSemana;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "complejo_id")
    private Complejo complejo;
}
