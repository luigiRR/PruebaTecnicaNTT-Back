package com.prueba.tecnicantt.Auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class AuthResponse {
    String token;
    String firstname;
    String lastname;
    Integer roleId;

}
