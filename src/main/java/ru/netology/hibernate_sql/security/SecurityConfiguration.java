package ru.netology.hibernate_sql.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("Petya")
                .password(encoder.encode("1233"))
                .roles("Admin")
                .build();
        UserDetails user = User.withUsername("Grisha")
                .password(encoder().encode("1234"))
                .roles("Guest")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        return http.formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET,"/persons/by-city")
                        .hasRole("Admin")
                        .requestMatchers(HttpMethod.GET,"/persons/by-age")
                        .hasRole("Guest")
                        .requestMatchers(HttpMethod.GET,"/persons/by-nameAndSurname")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .build();

    }


}
