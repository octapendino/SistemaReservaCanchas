package com.octavio.soccer_field_reservation_system.complejos.dto;

import com.octavio.soccer_field_reservation_system.complejos.entity.Direccion;
import com.octavio.soccer_field_reservation_system.complejos.entity.Imagen;
import com.octavio.soccer_field_reservation_system.franjas_horarias.dto.FranjaHorariaRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ComplejoRequestDTO {

    @NotBlank(message = "El nombre del complejo es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripcion del complejo es obligatoria")
    private String descripción;

    @NotBlank(message = "El numero de telefono del complejo es obligatorio")
    private String telefono;

    @NotBlank(message = "La direccion es obligatoria")
    @Valid
    private Direccion direccion;

    @NotBlank(message = "La id del usuario es obligatoria")
    private Long usuarioId;

    @NotEmpty(message = "La lista de franjas horarias no puede estar vacía")
    @Valid
    private List<FranjaHorariaRequestDTO> franjasHorarias = new ArrayList<>();

    private String rutaImagen;

}
