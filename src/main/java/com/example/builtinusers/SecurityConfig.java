package com.example.builtinusers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        /*Prior to Spring Security 5.0 the default PasswordEncoder was
NoOpPasswordEncoder which required plain text passwords.
In Spring Security 5, the default is DelegatingPasswordEncoder, which required Password Storage Format.
That's why {noop} is needed*/

        auth
                .inMemoryAuthentication()
                    .withUser("user")
                        .password("{noop}password")
                        .authorities("ROLE_USER")
                    .and()
                    .withUser("admin")
                        .password("{noop}password")
                        .authorities("ROLE_ADMIN");

    }
}
