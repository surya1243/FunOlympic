package com.pofil.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pofil.model.AppUser;
import com.pofil.model.Role;
import com.pofil.repository.RoleRepository;
import com.pofil.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    public AppUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    
    public void saveUser(AppUser user, String roles) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole(roles);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
    
    public void updateUser(AppUser user, String roles) {
        Role userRole = roleRepository.findByRole(roles);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser user = userRepository.findByEmail(email);  
        if(user != null  && user.isEnabled()) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        if (userRoles == null) {
            logger.warn("userRoles is null");
            return new ArrayList<>(roles);
        }
        
        userRoles.forEach(role -> {
            if (role == null) {
                logger.warn("Encountered null role in userRoles");
            } else {
                String roleString = role.getRole();
                if (roleString == null) {
                    logger.warn("Role {} returned null for getRole()", role);
                } else {
                    roles.add(new SimpleGrantedAuthority(roleString));
                }
            }
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(AppUser user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}
