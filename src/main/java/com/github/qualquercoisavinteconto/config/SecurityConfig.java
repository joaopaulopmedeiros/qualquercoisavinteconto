package com.github.qualquercoisavinteconto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.github.qualquercoisavinteconto.services.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**", "/webjars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/signin").permitAll()
                        .requestMatchers(HttpMethod.POST, "/signup").permitAll()
                        
                        .requestMatchers("/categories").hasAnyRole("ADMIN")
                        .requestMatchers("/categories/**").hasAnyRole("ADMIN")
                        
                        .requestMatchers("/products").hasAnyRole("ADMIN", "SELLER")
                        .requestMatchers("/products/**").hasAnyRole("ADMIN", "SELLER")

                        .requestMatchers("/address").hasAnyRole("ADMIN", "CUSTOMER")
                        .requestMatchers("/address/**").hasAnyRole("ADMIN", "CUSTOMER")

                        .requestMatchers("/ads").hasAnyRole("ADMIN", "ADVERTISER")
                        .requestMatchers("/ads/**").hasAnyRole("ADMIN", "ADVERTISER")

                        .requestMatchers("/purchase").hasAnyRole("ADMIN", "CUSTOMER")                        
                        .requestMatchers("/purchase/**").hasAnyRole("ADMIN", "CUSTOMER")

                        .requestMatchers("/purchaseitem").hasAnyRole("ADMIN", "CUSTOMER")
                        .requestMatchers("/purchaseitem/**").hasAnyRole("ADMIN", "CUSTOMER")

                        .requestMatchers("/review").hasAnyRole("ADMIN", "CUSTOMER")                        
                        .requestMatchers("/review/**").hasAnyRole("ADMIN", "CUSTOMER")

                        .requestMatchers("/roles").hasRole("ADMIN")                        
                        .requestMatchers("/roles/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}