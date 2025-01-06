package com.iamkhangg.skyclothingapi.models;

public class AuthenticationResponse {
    private final String jwt;
    private final String fullName;

    public AuthenticationResponse(String jwt, String fullName) {
        this.jwt = jwt;
        this.fullName = fullName;
    }

    public String getJwt() {
        return jwt;
    }

    public String getFullName() {
        return fullName;
    }
}
