package com.logger;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class ApiConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("USER").and().httpBasic();
		
		//http.httpBasic().authenticationEntryPoint(entrypoint);
		
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
}
