package com.iamkhangg.skyclothingapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticationResponse {
    private String jwt;
    private String fullName;
}
