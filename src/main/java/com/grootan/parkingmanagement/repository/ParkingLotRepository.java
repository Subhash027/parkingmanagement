package com.grootan.parkingmanagement.repository;


import com.grootan.parkingmanagement.enums.VehicleTypes;
import com.grootan.parkingmanagement.model.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    List<ParkingLot> findParkingLotByVehicleType(VehicleTypes vehicleType);

    Optional<ParkingLot> findPriceByName(String name);

    @Query("select ParkingLot from ParkingLot ParkingLot where ParkingLot.isEmpty= ?1")
    List<ParkingLot> findAllParkingLotByIsEmpty(boolean aBoolean);
}
