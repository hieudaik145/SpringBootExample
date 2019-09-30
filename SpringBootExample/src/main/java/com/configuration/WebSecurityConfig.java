package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// endblewebsecurity se kich hoat viec tich howp Springsecurity vs SpringMvc
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests()
				//setting url don't need login 
				.antMatchers("/register").permitAll()
				//setting url has role member
				.antMatchers("/").hasRole("MEMBER")
				//setting url has role admin
				.antMatchers("/admin").hasRole("ADMIN")
				.and()
			.formLogin()
				//duong dan toi trang chua form dang nhap
				.loginPage("/login")
				//trong spring mac dinh neu khong khai bao loginProcessingurl thi mac dinh xu ly submit form laf /login
				.loginProcessingUrl("/dangnhap")
				//setting parameter username
				.usernameParameter("email")
				//setting parameter password
				.passwordParameter("password")
				//setting url success login
				.defaultSuccessUrl("/")
				//setting url fail login
				.failureUrl("/login?error")
				.and()
			//setting page redirect when exception hadling
			.exceptionHandling()
				.accessDeniedPage("/403");
	}


	
}
