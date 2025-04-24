package com.prueba.tecnicantt.Auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter @Setter
public class RegisterRequest {
    String firstName;
    String lastName;
    String phone;
    String identityNumber;
    String address;
    Date birthDate;
    String email;
    String password;
}
