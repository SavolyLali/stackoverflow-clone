package com.lajosdanielsavoly.stackoverflowclone.services.user;

import com.lajosdanielsavoly.stackoverflowclone.dtos.SignupRequest;
import com.lajosdanielsavoly.stackoverflowclone.dtos.UserDTO;
import com.lajosdanielsavoly.stackoverflowclone.entities.User;
import com.lajosdanielsavoly.stackoverflowclone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setId(createdUser.getId());
        return createdUserDTO;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
