package com.example.btlltw.service;

import com.example.btlltw.dto.LoginRequestDto;
import com.example.btlltw.dto.SignupRequestDto;
import com.example.btlltw.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenService {

    ResponseEntity<?> signup(SignupRequestDto signUpRequest);

    ResponseEntity<?> signin(LoginRequestDto loginRequest);
}
