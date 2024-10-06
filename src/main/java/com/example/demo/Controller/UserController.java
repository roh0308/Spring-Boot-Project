package com.example.demo.Controller;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    public UserController() {
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO){
       return userService.registerUser(userRegistrationDTO);
    }
    @PostMapping("/loginUser")
    public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO loginDTO){
        return userService.loginUser(loginDTO);
    }

}
