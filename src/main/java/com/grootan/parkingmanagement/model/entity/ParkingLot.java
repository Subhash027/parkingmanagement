package com.grootan.parkingmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grootan.parkingmanagement.enums.VehicleTypes;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String city;

    private boolean isEmpty;

    private VehicleTypes vehicleType;

    private Double price;
}
