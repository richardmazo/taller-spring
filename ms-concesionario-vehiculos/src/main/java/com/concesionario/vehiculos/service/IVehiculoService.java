package com.concesionario.vehiculos.service;

import com.concesionario.vehiculos.dto.VehiculoDto;
import com.concesionario.vehiculos.model.VehiculoEntity;
import org.springframework.http.ResponseEntity;

public interface IVehiculoService {

    ResponseEntity<VehiculoEntity> save(VehiculoDto vehiculoDto);

    ResponseEntity<?> delete(String id);

    ResponseEntity<?> update(VehiculoDto vehiculoDto, String id);

    ResponseEntity<?> findById(String id);

    ResponseEntity<VehiculoEntity> findByPlaca(String placa);

    ResponseEntity<?> findAll();


}
