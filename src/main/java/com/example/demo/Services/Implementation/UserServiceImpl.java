package com.example.demo.Services.Implementation;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.Entity.Item;
import com.example.demo.Entity.User;
import com.example.demo.Repository.ItemRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public ResponseEntity<String> registerUser(UserRegistrationDTO userRegistrationDTO) {

        if(userRepository.existsByEmail(userRegistrationDTO.getEmail())){
            return ResponseEntity.status(403).body("User email exists!!");
        }

        User user = new User(userRegistrationDTO.getUserName(),userRegistrationDTO.getEmail(),userRegistrationDTO.getPassword());
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return ResponseEntity.status(200).body("Registration Successful");
    }
    @Override
    public ResponseEntity<String> loginUser(LoginDTO loginDTO) {
        Optional<User> user = userRepository.findUserByName(loginDTO.getUsername());
//        if(user.isEmpty()){
//           return ResponseEntity.status(400).body("Username not found");
//        }else{
//            if(user.get().getPassword().equals(loginDTO.getPassword())){
//                return ResponseEntity.ok("Login Successful");
//            }else{
//                return ResponseEntity.status(403).body("Login Failed");
//            }
//        }
        if(user.isEmpty()){
            return ResponseEntity.status(400).body("Username not found");
        }
        boolean passwordMatches = passwordEncoder.matches(loginDTO.getPassword(),user.get().getPassword());
        if(passwordMatches){
            return ResponseEntity.status(200).body("Login Successful");
        }else{
            return ResponseEntity.status(403).body("Login Failed");
        }
//        if(user == null){
//            return ResponseEntity.status(400).body("Username not found");
//        }
//        if(Objects.equals(user.get().getPassword(), loginDTO.getPassword())){
//            return ResponseEntity.ok("Login Successful");
//        }else{
//            return ResponseEntity.status(403).body("Login Failed");
//        }
    }
}
