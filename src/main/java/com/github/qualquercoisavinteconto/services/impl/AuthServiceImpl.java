package com.github.qualquercoisavinteconto.services.impl;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.repositories.UserRepository;
import com.github.qualquercoisavinteconto.requests.SigninRequest;
import com.github.qualquercoisavinteconto.requests.SignupRequest;
import com.github.qualquercoisavinteconto.responses.SigninResponse;
import com.github.qualquercoisavinteconto.responses.SignupResponse;
import com.github.qualquercoisavinteconto.services.AuthService;
import com.github.qualquercoisavinteconto.services.TokenService;

@Service
public class AuthServiceImpl implements AuthService {
        private final AuthenticationManager authManager;
        private final TokenService tokenService;
        private final UserRepository userRepository;

        public AuthServiceImpl(
                        AuthenticationManager authManager,
                        TokenService tokenService,
                        UserRepository userRepository) {
                this.authManager = authManager;
                this.tokenService = tokenService;
                this.userRepository = userRepository;
        }

        @Override
        public SigninResponse signin(SigninRequest request) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword());

                Authentication authentication = this.authManager
                                .authenticate(usernamePasswordAuthenticationToken);

                var user = (User) authentication.getPrincipal();

                String token = tokenService.createToken(user);

                return SigninResponse.builder()
                                .accessToken(token)
                                .build();
        }

        @Override
        public SignupResponse signup(SignupRequest request) {
                Optional<User> user = this.userRepository.findByEmail(request.getEmail());

                if (user.isPresent())
                        throw new RuntimeException("User already exists");

                String encryptedPassword = new BCryptPasswordEncoder().encode(request.getPassword());

                User newUser = new User(request.getName(), request.getEmail(), encryptedPassword);

                this.userRepository.save(newUser);

                var response = new SignupResponse();

                response.setId(newUser.getId());

                return response;
        }
}
