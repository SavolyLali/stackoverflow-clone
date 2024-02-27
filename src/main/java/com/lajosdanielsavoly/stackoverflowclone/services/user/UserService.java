package com.lajosdanielsavoly.stackoverflowclone.services.user;

import com.lajosdanielsavoly.stackoverflowclone.dtos.SignupRequest;
import com.lajosdanielsavoly.stackoverflowclone.dtos.UserDTO;

public interface UserService {
    UserDTO createUser(SignupRequest signupDTO);
}
