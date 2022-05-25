package com.grootan.parkingmanagement.model.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AuthenticateRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

    public AuthenticateRequest() {

    }

    public AuthenticateRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
