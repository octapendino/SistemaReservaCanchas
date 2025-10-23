package com.octavio.soccer_field_reservation_system.complejos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreArchivo;

    @Column(nullable = false, unique = true)
    private String url;

    @OneToOne
    @JoinColumn(name = "complejo_id", nullable = false)
    private Complejo complejo;
}
