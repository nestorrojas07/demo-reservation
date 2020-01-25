package com.nestorrojas07.democrud.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import ch.qos.logback.core.encoder.Encoder;

/**
 * Clase para manejar los temas de seguridad
 * 
 * @author nrojas
 *
 */

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Modificar el método configurar la página de login, error 
	 * y satisfacción las cuales se enlaza con el controlador Login.
	 */
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
	
	/**
	 * Configurar el método de autentificación, para lo cual utilizamos un método en memoria.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		builder.inMemoryAuthentication()
		.withUser("nestor")
		.password(encoder.encode("clave"))
		.roles("USER");
	}
	
	/**
	 * Configurar qué rutas de la aplicación se deben excluir del proceso de login, 
	 * en la cual están todos los recursos estáticos configurados anteriormente.
	 */
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring()
        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	

	

}
