package com.grootan.parkingmanagement.model.entity;

import com.grootan.parkingmanagement.enums.VehicleTypes;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerDetailsId;
    @NotNull
    private String vehicleNumber;
    @NotNull
    private VehicleTypes vehicleType;
    @Nullable
    private String mail;
    @NotNull
    private Long phoneNumber;
    @Nullable
    private Long whatsappNumber;


}