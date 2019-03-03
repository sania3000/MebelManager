package com.Sydorenko.service.security;

import com.Sydorenko.dao.UserRepository;
import com.Sydorenko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    //метод вызывается при сабмите логин формы
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if (user==null)
            throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),grantedAuthorities);
    }
}
