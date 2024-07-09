package com.concesionario.vehiculos.service.impl;

import com.concesionario.vehiculos.dto.VehiculoDto;
import com.concesionario.vehiculos.exception.MyHandlerException;
import com.concesionario.vehiculos.model.VehiculoEntity;
import com.concesionario.vehiculos.repository.IVehiculoRepository;
import com.concesionario.vehiculos.service.IVehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    @Override
    public ResponseEntity<VehiculoEntity> save(VehiculoDto vehiculoDto) {

        //this.findByPlaca(vehiculoDto.getPlaca());

        String uuid = UUID.randomUUID().toString();
        VehiculoEntity vehiculo = VehiculoEntity
                .builder()
                .id(uuid)
                .placa(vehiculoDto.getPlaca())
                .modelo(vehiculoDto.getModelo())
                .status(true)
                .build();

        var newVehiculo = this.vehiculoRepository.save(vehiculo);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newVehiculo);
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        this.vehiculoRepository.findById(id).orElseThrow(() -> new MyHandlerException("Este vehiculo no existe."));
        this.vehiculoRepository.deleteById(id);
        return ResponseEntity.ok("Eliminado");
    }

    @Override
    public ResponseEntity<?> update(VehiculoDto vehiculoDto, String id) {
        var vehicule = this.vehiculoRepository.findById(id).orElseThrow(() -> new MyHandlerException("Este vehiculo no existe."));

        vehicule.setModelo(vehiculoDto.getModelo());
        vehicule.setPlaca(vehiculoDto.getPlaca());
        vehicule.setStatus(vehiculoDto.isStatus());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.vehiculoRepository.save(vehicule));
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        var vehiculoOpt = this.vehiculoRepository.findById(id);
        if (vehiculoOpt.isPresent()){
            return ResponseEntity.ok(vehiculoOpt.get());
        }
        throw new MyHandlerException("No se encontro el vehiculo por ese id");
    }

    @Override
    public ResponseEntity<VehiculoEntity> findByPlaca(String placa) {

        var vehiculoOpt = this.vehiculoRepository.findByPlaca(placa);

        if (vehiculoOpt.isPresent()){
            return ResponseEntity.ok(vehiculoOpt.get());
        }

        throw new MyHandlerException("No se encontro el vehiculo por esa placa");
    }

    @Override
    public ResponseEntity<List<?>> findAll() {
        var vehiculoOpt = this.vehiculoRepository.findAll();

        if (!vehiculoOpt.isEmpty()){
            return ResponseEntity.ok(vehiculoOpt);
        }

        throw new MyHandlerException("No se encontro el vehiculo por esa placa");
    }
}
