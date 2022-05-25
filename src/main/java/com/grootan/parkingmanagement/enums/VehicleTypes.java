package com.grootan.parkingmanagement.enums;

public enum VehicleTypes {
    CAR("car"),
    BIKE("bike");

    private final String type;

    VehicleTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
