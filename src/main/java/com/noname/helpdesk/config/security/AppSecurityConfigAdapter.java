package com.noname.helpdesk.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 * AppSecurityConfigAdapter class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class AppSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Value("${app.public.path}")
	private String publicPath;

	@Autowired
    private UserDetailsService userDetailsService;

	/** {@inheritDoc} */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	/** {@inheritDoc} */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(publicPath).permitAll()
				.antMatchers("/dashboard/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/dashboard").permitAll()
					.defaultSuccessUrl("/helpdesk", true)
					.failureUrl("/dashboard#/login?error")
				.and()
				.logout().permitAll()
					.logoutSuccessUrl("/dashboard#/login?logout")
				.and()
				.csrf().disable();
	}
}
