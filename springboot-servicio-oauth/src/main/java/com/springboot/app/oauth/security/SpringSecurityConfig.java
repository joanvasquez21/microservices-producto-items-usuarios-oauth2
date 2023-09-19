package com.springboot.app.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*Registramos en el authenticacion manager de springsecurity la clase servie (UsuarioService)
 * para que se pueda realizar el proceso de authenticacion en springsecurity usando el cliente
 * feign mediante la comunicacion apirest
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	private UserDetailsService usuarioService;
	
	//metodo para encriptar contraseñas y @bean para que se guarde en el contenedor de spring
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	
	
	
	

}
