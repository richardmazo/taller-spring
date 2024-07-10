package com.concesionario.vehiculos.controller.v2;

import com.concesionario.vehiculos.controller.v2.doc.VehiculoDocV2;
import com.concesionario.vehiculos.dto.VehiculoDto;
import com.concesionario.vehiculos.model.VehiculoEntity;
import com.concesionario.vehiculos.service.IVehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VehiculoControllerV2 implements VehiculoDocV2 {

    private final IVehiculoService iVehiculoService;

    @Override
    public ResponseEntity<VehiculoEntity> create(VehiculoDto vehicleDTO) {
        return this.iVehiculoService.save(vehicleDTO);
    }
}
