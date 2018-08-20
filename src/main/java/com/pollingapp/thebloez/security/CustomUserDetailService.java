package com.pollingapp.thebloez.security;

import com.pollingapp.thebloez.model.User;
import com.pollingapp.thebloez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by thebloez on 04/06/18.
 */
@Service
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // login pake username atau email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return UserPrincipal.create(user);
    }

    // method ini dipakai di JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with ID : " + id)
                );
        return UserPrincipal.create(user);
    }
}
