package com.example.arkadiusz.app.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class AuthenticationManagerProvider extends WebSecurityConfigurerAdapter
    {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
        {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
        }

    @Bean
    @Override
    @Primary
    public AuthenticationManager authenticationManagerBean() throws Exception
        {
        return super.authenticationManagerBean();
        }

    // TODO: 08.05.2019 must add new encoder before endpoint with reg.

    @Bean
    public PasswordEncoder encoder()
        {
        return new PasswordEncoder()
            {
            @Override
            public String encode(CharSequence charSequence)
                {
                return charSequence.toString();
                }

            @Override
            public boolean matches(CharSequence charSequence, String s)
                {
                return true;
                }
            };
        }
    }
