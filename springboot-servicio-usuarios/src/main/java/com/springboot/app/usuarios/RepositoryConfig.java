package com.springboot.app.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import com.springboot.app.commons.usuarios.models.entity.*;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		//Config para configurar el repositorio rest
		config.exposeIdsFor(Usuario.class, Role.class);
		}

	
	
}
