package com.lajosdanielsavoly.stackoverflowclone.dtos;

import lombok.Data;

@Data
public class SignupRequest {

    private Long id;
    private String name;
    private String password;
    private String email;
}
