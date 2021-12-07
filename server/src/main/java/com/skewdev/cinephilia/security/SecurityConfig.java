package com.skewdev.cinephilia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		// Guest
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/login").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users/register").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/movies").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/movies/{movieId}").permitAll();

		// Authenticated
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/movies").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/movies/{movieId}").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/movies/{movieId}").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/movies/{movieId}/reviews").authenticated();

		// Moderator
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/users").hasAnyRole("MODERATOR");
		http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/movies/{movieId}/reviews").hasAnyRole("MODERATOR");
		http.authorizeRequests().antMatchers("/roles").hasAnyRole("MODERATOR");
		http.httpBasic();
	}
}