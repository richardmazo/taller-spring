package com.concesionario.vehiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

    @Id
    private String id;

    private String placa;

    private String modelo;

    private boolean status;


}
