package com.giovanni.services;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.giovanni.entities.JwtUserDetails;
import com.giovanni.entities.UserEntity;
import com.giovanni.repositories.UserRepository;

public class JwtUserDetailsService implements UserDetailsService {
    public static final String USER = "USER";
    public static final String ROLE_USER = "ROLE_" + USER;

    private UserRepository userRepository;

    @Override
    public JwtUserDetails loadUserByUsername(final String username) {
        try {
            final UserEntity user = userRepository.findByUsername(username);
            final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            return new JwtUserDetails(user.getId(), username, user.getHash(), roles);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        
    }
}
