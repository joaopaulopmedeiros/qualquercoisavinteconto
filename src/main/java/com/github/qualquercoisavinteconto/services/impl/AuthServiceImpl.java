package com.github.qualquercoisavinteconto.services.impl;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.exceptions.UserAlreadyExistsException;
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
                var usernamePassword = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

                var auth = this.authManager.authenticate(usernamePassword);

                var token = tokenService.createToken((User) auth.getPrincipal());

                return SigninResponse.builder()
                                .accessToken(token)
                                .build();
        }

        @Override
        public SignupResponse signup(SignupRequest request) throws UserAlreadyExistsException {
                Optional<User> user = this.userRepository.findByEmail(request.getEmail());

                if (user.isPresent()) throw new UserAlreadyExistsException();

                String encryptedPassword = new BCryptPasswordEncoder().encode(request.getPassword());

                User newUser = new User(request.getName(), request.getEmail(), encryptedPassword);

                this.userRepository.save(newUser);

                var response = new SignupResponse();

                response.setId(newUser.getId());

                return response;
        }
}
