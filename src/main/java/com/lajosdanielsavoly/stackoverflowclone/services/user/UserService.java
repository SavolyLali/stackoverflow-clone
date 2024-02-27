package com.lajosdanielsavoly.stackoverflowclone.services.user;

import com.lajosdanielsavoly.stackoverflowclone.dtos.SignupRequest;
import com.lajosdanielsavoly.stackoverflowclone.dtos.UserDTO;

public interface UserService {
    UserDTO createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
