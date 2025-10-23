package com.octavio.soccer_field_reservation_system.complejos.entity;

import com.octavio.soccer_field_reservation_system.canchas.entity.Cancha;
import com.octavio.soccer_field_reservation_system.franjas_horarias.entity.FranjaHoraria;
import com.octavio.soccer_field_reservation_system.servicios.entity.Servicio;
import com.octavio.soccer_field_reservation_system.usuarios.entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Complejo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String telefono;

    @Embedded
    private Direccion direccion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "complejo_servicio",
            joinColumns = @JoinColumn(name = "complejo_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "servicio_id", nullable = false)
    )
    private Set<Servicio> servicios = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "complejo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Cancha> canchas = new HashSet<>();

    @OneToMany(mappedBy = "complejo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FranjaHoraria> franjasHorarias = new ArrayList<>();

    @OneToOne(mappedBy = "complejo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Imagen imagen;

}
