package com.prueba.tecnicantt.Auth;

import com.prueba.tecnicantt.Jwt.JwtService;
import com.prueba.tecnicantt.Model.Role;
import com.prueba.tecnicantt.Model.Status;
import com.prueba.tecnicantt.Model.User;
import com.prueba.tecnicantt.Repository.UserRepository;
import com.prueba.tecnicantt.Util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword())
        );
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        User userModel = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .firstname(userModel.getFirstName())
                .lastname(userModel.getLastName())
                .roleId(userModel.getRole().getId())
                .build();
    }

    public AuthResponse register(RegisterRequest request){
        Role role = new Role(Util.ADMIN_ROLE);
        Status status = new Status(Util.CREATED_STATE);
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .birthdate(request.getBirthDate())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .status(status)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
