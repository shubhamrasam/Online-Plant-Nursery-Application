package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	 public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser = User.withUsername("ashish")
				.password(passwordEncoder().encode("root"))
				.roles("NORMAL").build();
		UserDetails adminUser = User.withUsername("ashish1")
				.password(passwordEncoder().encode("adminroot"))
				.roles("ADMIN").build();
		
		return null;
		
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeHttpRequests()
	//	.requestMatchers("/home/admin")
//		.hasAnyRole("ADMIN")
//		.requestMatchers("/home/normal")
//		.hasAnyRole("NORMAL")
	//	.requestMatchers("/home/public")
	//	.permitAll()
		.anyRequest()
				.authenticated().and().formLogin();

		return httpSecurity.build();

	}

}