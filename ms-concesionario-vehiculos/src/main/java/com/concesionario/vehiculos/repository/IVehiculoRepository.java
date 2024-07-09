package com.concesionario.vehiculos.repository;

import com.concesionario.vehiculos.model.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IVehiculoRepository  extends JpaRepository<VehiculoEntity, String> {

    Optional<VehiculoEntity> findByPlaca(String placa);

}
