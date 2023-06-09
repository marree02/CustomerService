package com.example.customerservice.config;

import jakarta.servlet.DispatcherType;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(WebSecurityConfig.class);


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/customers/**").hasRole("USER")).httpBasic(Customizer.withDefaults());
        http.cors().disable().csrf().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{bcrypt}$2a$10$7k.Rocf4uX62GEdaSXEa1ebFZVaqOqbhIaVm7ldhOPKgV5ywlVafm")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

}
