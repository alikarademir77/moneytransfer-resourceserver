package com.westerunion.moneytransferpoc.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MoneyTransferSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();

//        http
//            .authorizeRequests(authorizeRequests ->
//                    authorizeRequests
//                            .antMatchers(HttpMethod.GET, "/resource-server/**")
//                            .authenticated()
//                    .anyRequest().authenticated())
//            .oauth2ResourceServer().jwt();
    }
}
