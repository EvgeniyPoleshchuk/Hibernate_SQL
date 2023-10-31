package ru.netology.hibernate_sql.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableWebSecurity()
@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user1 = User.withUsername("Petya")
                .password(encoder.encode("1233"))
                .roles("WRITE")
                .build();
        UserDetails user2 = User.withUsername("Grisha")
                .password(encoder().encode("1234"))
                .roles("READ")
                .build();
        UserDetails user3 = User.withUsername("Misha")
                .password(encoder().encode("12345"))
                .authorities("DELETE")
                .build();


        return new InMemoryUserDetailsManager(user1,user2,user3);
    }

//    @Bean
//    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
//        return http.formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET,"/persons/by-city")
//                        .hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET,"/persons/by-age")
//                        .hasRole("USER")
//                        .requestMatchers(HttpMethod.GET,"/persons/by-nameAndSurname")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .build();
// }


}
