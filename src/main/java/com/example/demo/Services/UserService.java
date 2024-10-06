package com.example.demo.Services;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import org.springframework.http.ResponseEntity;

//@Service
public interface UserService {
    ResponseEntity<String> registerUser(UserRegistrationDTO userRegistrationDTO);
    ResponseEntity<String> loginUser(LoginDTO loginDTO);
 }
