/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.paymentchain.billing.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author SantiagoSRP
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] NO_AUTH_LIST = {
            "/v3/api-docs", //
            "/configuration/ui", //
            "/swagger-resources", //
            "/configuration/security", //
            "/webjars/**", //
            "/login",
            "/h2-console/**" };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        SecurityFilterChain config = defaultSecurityFilterChain(http);

        return config;
    }

    private SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection. This is typically done for APIs or non-browser
                // clients.
                .csrf(csrf -> csrf.disable())
                // Configure authorization rules. Require authentication for any request.
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                // Enable HTTP Basic authentication.
                .httpBasic(withDefaults())
                // Enable form-based login with default settings.
                .formLogin(withDefaults());

        return http.build();
    }
}
