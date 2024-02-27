package com.lajosdanielsavoly.stackoverflowclone.dtos;

public class AuthenticationResponse {
    public AuthenticationResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    private String jwtToken;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

}
