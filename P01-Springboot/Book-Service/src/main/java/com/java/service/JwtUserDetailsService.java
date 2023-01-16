package com.java.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user from database where user = :username
        // userRepo.findByUsername(username);// username, password, roles
        if ("user1".equals(username)) {
            Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "GUEST"));
            return new User(
                    "user1",
                    "$2a$10$5Q/UZBQH.ArDrvXZfIZrveep0Im/E6rdGRj17uEROHDzRqcWYdI1O",
                    authorities
                );
            } else if ("user2".equals(username)) {
                Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
    	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "READER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
                return new User(
                        "user2",
                        "$2a$10$5Q/UZBQH.ArDrvXZfIZrveep0Im/E6rdGRj17uEROHDzRqcWYdI1O",
                        authorities
                    );
            } else if ("user3".equals(username)) {
                Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
                return new User(
                        "user3",
                        "$2a$10$5Q/UZBQH.ArDrvXZfIZrveep0Im/E6rdGRj17uEROHDzRqcWYdI1O",
                        authorities
                    );
            } else {
                throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}