package com.concesionario.vehiculos.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {

    @NotBlank
    @NotEmpty
    private String placa;

    @NotBlank
    @NotEmpty
    private String modelo;

    private boolean status;


}
