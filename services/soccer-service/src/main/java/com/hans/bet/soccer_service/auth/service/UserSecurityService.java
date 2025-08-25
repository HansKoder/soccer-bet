package com.hans.bet.soccer_service.auth.service;

import com.hans.bet.soccer_service.auth.entity.UserEntity;
import com.hans.bet.soccer_service.auth.entity.UserRoleEntity;
import com.hans.bet.soccer_service.auth.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

        String[] roles = userEntity.getRoles()
                .stream()
                .map(UserRoleEntity::getRole)
                .toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(grantedAuthorities(roles))
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }

    private String[] getAuthorities (String role) {
        if ("BOOK_MAKER".equals(role)) {
            return new String[] {"FINISH_MATCH"};
        }

        return new String[] {};
    }

    private List<GrantedAuthority> grantedAuthorities (String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String auth : getAuthorities(role))
                authorities.add(new SimpleGrantedAuthority(auth));
        }

        return authorities;
    }

}
