package com.concesionario.vehiculos.controller.v2.doc;

import com.concesionario.vehiculos.dto.VehiculoDto;
import com.concesionario.vehiculos.model.VehiculoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Vehicle", description = "API expuesta para la manipulacion de vehiculos")
@RequestMapping("/api/v2/vehicle")
public interface VehiculoDocV2 {

    @Operation(summary = "Crear vehiculo")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            description = "Vehiculo creado", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
                    @ApiResponse(responseCode = "400",
                            description = "Error al crear vehiculo", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @PostMapping
    ResponseEntity<VehiculoEntity> create(@RequestBody @Validated VehiculoDto vehicleDTO);

}
