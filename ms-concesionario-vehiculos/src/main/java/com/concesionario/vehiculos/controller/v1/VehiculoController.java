package com.concesionario.vehiculos.controller.v1;

import com.concesionario.vehiculos.dto.VehiculoDto;
import com.concesionario.vehiculos.model.VehiculoEntity;
import com.concesionario.vehiculos.service.IVehiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vehiculo")
@AllArgsConstructor
public class VehiculoController {

    private final IVehiculoService iVehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoEntity> create(@RequestBody @Valid VehiculoDto vehiculoDto){
        return this.iVehiculoService.save(vehiculoDto);
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<VehiculoEntity> getByPlaca(@PathVariable String placa){
        return this.iVehiculoService.findByPlaca(placa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return this.iVehiculoService.delete(id);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<?> update(@RequestBody VehiculoDto vehiculoDto,@PathVariable("id") String id){
        return this.iVehiculoService.update(vehiculoDto, id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return this.iVehiculoService.findById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return this.iVehiculoService.findAll();
    }

}
