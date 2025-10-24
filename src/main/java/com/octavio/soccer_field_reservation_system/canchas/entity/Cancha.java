package com.octavio.soccer_field_reservation_system.canchas.entity;

import com.octavio.soccer_field_reservation_system.canchas.enums.TipoCancha;
import com.octavio.soccer_field_reservation_system.canchas.enums.TipoSuelo;
import com.octavio.soccer_field_reservation_system.complejos.entity.Complejo;
import com.octavio.soccer_field_reservation_system.reservas.entity.Reserva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cancha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCancha tipoCancha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSuelo tipoSuelo;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPorHora;

    @Column(nullable = false)
    private boolean iluminacion;

    @Column(nullable = false)
    private boolean cubierta;

    @ManyToOne
    @JoinColumn(name = "complejo_id",nullable = false)
    private Complejo complejo;

    @OneToMany(mappedBy = "cancha",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

}
