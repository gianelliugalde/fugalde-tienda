/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/**
 *
 * @author giane
 */
@Configuration
public class SecurityConfig {

    private static final String[] PUBLIC_URLS = {
        "/",
        "/index",
        "/errores/**",
        "/css/**",
        "/js/**",
        "/webjars/**",
        "/images/**",
        "/img/**",
        "/fonts/**",
        "/consultas/listado"
    };

    private static final String[] ADMIN_URLS = {
        "/categoria/nuevo",
        "/categoria/guardar",
        "/categoria/eliminar/**",
        "/categoria/modificar/**",
        "/producto/nuevo",
        "/producto/guardar",
        "/producto/eliminar/**",
        "/producto/modificar/**",
        "/usuario/**"
    };

    private static final String[] ADMIN_OR_VENDEDOR_URLS = {
        "/categoria/listado",
        "/producto/listado",
        "/consultas/**"
    };

    private static final String[] USUARIO_URLS = {
        "/carrito/**",
        "/facturar/**",
        "/pago/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(PUBLIC_URLS).permitAll()
                .requestMatchers(ADMIN_URLS).hasRole("ADMIN")
                .requestMatchers(ADMIN_OR_VENDEDOR_URLS).hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers(USUARIO_URLS).hasRole("USUARIO")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/acceso_denegado")
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.builder()
                .username("juan")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails vendedor = User.builder()
                .username("rebeca")
                .password(passwordEncoder.encode("123"))
                .roles("VENDEDOR")
                .build();

        UserDetails usuario = User.builder()
                .username("pedro")
                .password(passwordEncoder.encode("123"))
                .roles("USUARIO")
                .build();

        return new InMemoryUserDetailsManager(admin, vendedor, usuario);
    }
}

