package com.iamkhangg.skyclothingapi.models;

import java.time.LocalDate;

import com.iamkhangg.skyclothingapi.enums.Gender;
import com.iamkhangg.skyclothingapi.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String fullName;
    private String email;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String password;
    private Role role;
}
