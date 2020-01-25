package com.nestorrojas07.democrud.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Clase para manejar los temas de seguridad
 * 
 * @author nrojas
 *
 */

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/app/login").permitAll()//llama al recurso
		.failureUrl("/app/login?error=true")
		.defaultSuccessUrl("/app/home");
	}

	

}
