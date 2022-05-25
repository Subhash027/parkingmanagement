package com.grootan.parkingmanagement.model.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Transactional
@Entity
public class ParkingSlotReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String parkingLot;

    private LocalDateTime inTime;

    private String vehicleNumber;

    private LocalDate bookingDate;

    private LocalDateTime outTime;

    private Double price;

    public ParkingSlotReservation(String parkingLot, LocalDateTime inTime, String vehicleNumber, LocalDate bookingDate, LocalDateTime outTime, Double price) {
        this.parkingLot = parkingLot;
        this.inTime = inTime;
        this.vehicleNumber = vehicleNumber;
        this.bookingDate = bookingDate;
        this.outTime = outTime;
        this.price = price;
    }
}
