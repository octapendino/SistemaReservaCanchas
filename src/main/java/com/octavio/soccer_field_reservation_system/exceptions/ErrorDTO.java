package com.octavio.soccer_field_reservation_system.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorDTO {
    private int statusCode;
    private String message;
}
