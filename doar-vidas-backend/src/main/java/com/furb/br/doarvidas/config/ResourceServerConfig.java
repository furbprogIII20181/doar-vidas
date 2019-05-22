package com.furb.br.doarvidas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * This class defines each route and its permission
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .headers()
                .frameOptions()
                .disable()
                .and()
            .authorizeRequests()
            	// These routes don't need authentication
                .antMatchers("/rest/public/**").permitAll()
                // These needs authentication
                .antMatchers("/rest/private/**").authenticated();
    }


}