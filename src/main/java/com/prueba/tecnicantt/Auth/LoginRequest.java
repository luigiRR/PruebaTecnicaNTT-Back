package com.prueba.tecnicantt.Auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class LoginRequest {
    String email;
    String password;
}
