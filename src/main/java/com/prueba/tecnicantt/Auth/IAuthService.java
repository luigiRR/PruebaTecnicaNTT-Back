package com.prueba.tecnicantt.Auth;

public interface IAuthService {
    public AuthResponse login(LoginRequest request) throws Exception;

    public AuthResponse register(RegisterRequest request) throws Exception;
}
