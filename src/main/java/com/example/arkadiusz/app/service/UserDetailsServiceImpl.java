package com.example.arkadiusz.app.service;

import com.example.arkadiusz.app.dao.UserDao;
import com.example.arkadiusz.app.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService
    {
    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao)
        {
        this.userDao = userDao;
        }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException
        {
        Optional<UserEntity> userEntity = userDao.findByLoginIs(user);
        userEntity.orElseThrow(() -> new UsernameNotFoundException("user"));

        User userDetails = new User(userEntity.get().getLogin(), userEntity.get().getPassword(),
                new ArrayList<GrantedAuthority>()
                    {{
                    add(new SimpleGrantedAuthority("ROLE_USER"));
                    }});

        return userDetails;
        }
    }
