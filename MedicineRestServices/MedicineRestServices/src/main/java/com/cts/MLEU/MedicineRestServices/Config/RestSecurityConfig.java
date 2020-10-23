package com.cts.MLEU.MedicineRestServices.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/medicine/**").hasAnyRole("USER")
		.antMatchers(HttpMethod.POST,"/medicine/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/medicine/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/medicine/**").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("{noop}user")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("{noop}admin")
			.roles("ADMIN");
	}

}
