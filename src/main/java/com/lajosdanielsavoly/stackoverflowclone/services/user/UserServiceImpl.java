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
    public UserDTO createUser(SignupRequest signupDTO) {
        User user = new User();
        user.setEmail(signupDTO.getEmail());
        user.setName(signupDTO.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO createdUserDTO = new UserDTO();
        createdUserDTO.setId(createdUser.getId());
        return createdUserDTO;
    }
}
