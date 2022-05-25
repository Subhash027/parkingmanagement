package com.grootan.parkingmanagement.model.domain;

import lombok.Getter;

@Getter
public class UserResponse {
    private final String responseMessage;

    public UserResponse(String message) {
        this.responseMessage = message;
    }
}
