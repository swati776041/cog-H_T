package com.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.java.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService jwtUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // auth.inMemoryAuthentication();
        // auth.ldapAuthentication();
        // auth.jdbcAuthentication();


        auth.userDetailsService(jwtUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors();
        // We don't need CSRF for this example
        httpSecurity.csrf().disable()

                // dont authenticate this particular request
                .authorizeRequests()
                    .antMatchers("/authenticate").permitAll()
//					.antMatchers("/all/**").access("hasAnyRole('DIRECTOR','ADMIN')")
					.antMatchers("/java/books/block").access("hasRole('AUTHOR')")
					.antMatchers("/java/books/search").access("hasRole('GUEST', 'AUTHOR','READER')")
					.antMatchers("/java/books/subscribe").access("hasRole('READER')")
					.antMatchers("/java/books/unsubscribe").access("hasRole('READER')")
                // all other requests need to be authenticated
                .anyRequest().authenticated()
                .and()
                // make sure we use stateless session; session won't be
                // used to store user's state.
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
                // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(
                jwtRequestFilter,
                UsernamePasswordAuthenticationFilter.class);

                return httpSecurity.build();
    }
}