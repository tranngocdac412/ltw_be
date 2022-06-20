package com.example.btlltw.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
