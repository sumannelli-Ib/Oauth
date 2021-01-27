package com.ideabytes.security.springsecurityauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
@EnableConfigurationProperties
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {


	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */
    
    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .csrf().disable() .authorizeRequests().anyRequest().authenticated()
		 * .and().httpBasic() .and().sessionManagement().disable();
		 */

		
		  http.requestMatchers() .antMatchers("/login", "/oauth/authorize") .and()
		  .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic();
		 
        
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	
    }
    
  
}
