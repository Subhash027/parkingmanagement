package com.grootan.parkingmanagement.model.domain;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class AuthenticateResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -8091879091924046844L;

    private final String accessToken;

    public AuthenticateResponse(String jwt) {
        this.accessToken = jwt;
    }
}
