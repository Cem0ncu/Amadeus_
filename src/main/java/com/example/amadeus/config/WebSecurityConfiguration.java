package com.example.amadeus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        requests ->
                                requests
                                        .requestMatchers(HttpMethod.GET)
                                        .hasRole("USER")
                                        .requestMatchers(RegexRequestMatcher.regexMatcher("/resource/[A-Za-z0-9]+"))
                                        .hasRole("ADMIN")
                                        .anyRequest()
                                        .authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2y$12$aIUrXyneQh7mHAobhzThfuTBzlrau/6i4cTnlsBWib5XWOzk329r6")//user
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                //.password("{bcrypt}$2y$12$4CqrcxI1x.7DBlFLVNTqLOfi7KswGOztl69yUvAZgJZ1JyuMiFQge")//admin
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}