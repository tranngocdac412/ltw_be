package com.example.btlltw.controller;

import com.example.btlltw.dto.LoginRequestDto;
import com.example.btlltw.dto.SignupRequestDto;
import com.example.btlltw.entity.User;
import com.example.btlltw.repository.UserRepository;
import com.example.btlltw.service.AuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/authen")
public class AuthenControler {

    @Autowired
    AuthenService authenService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDto signUpRequest) {
        System.out.println("000000000000");
        return authenService.signup(signUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        return authenService.signin(loginRequest);
    }
}
