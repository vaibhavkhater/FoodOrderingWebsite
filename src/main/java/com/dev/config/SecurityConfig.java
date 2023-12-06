package com.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;
import static org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance;

//nopasswordencoder
//import static org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getInstance());
    }

    // Roles are ADMIN, RESTAURANT, CUSTOMER, DRIVER
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/signin", "/signup","/login","/css/login.css", "/register","/css/*","/js/*","/pics/*").permitAll()
                        .requestMatchers("/restaurants").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/signin")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)

                )
                .httpBasic(withDefaults());
        return http.csrf(AbstractHttpConfigurer::disable).build();

    }
}