package com.furb.br.doarvidas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Responsable for configure the Security of the application
 * 
 * @author Marcelo Wippel (mawippel2@hotmail.com)
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService customUserDetailsService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;    
        
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder);    
    }
    
    @Bean
    public FilterRegistrationBean corsFilter() {
      FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(corsConfigurationSource()));
      bean.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER);
      return bean;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOrigin("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      source.registerCorsConfiguration("/**", config);
      return source;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	http
	        .authorizeRequests()
	            .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
	            .anyRequest().authenticated()
	            .and()
	        .httpBasic()
	            .and()
	        .cors().disable()
	        .csrf().disable();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }    

}