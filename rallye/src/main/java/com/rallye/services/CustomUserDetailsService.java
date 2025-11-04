package com.rallye.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("admin")) {
            return new User("admin", "{noop}password", Collections.emptyList());
            // {noop} = pas de cryptage pour simplifier les tests
        }

        throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
    }
}
