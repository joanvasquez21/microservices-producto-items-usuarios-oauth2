package com.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.springboot.app.commons.usuarios.models.entity.*;

@RepositoryRestResource(path="usuarios")
public interface UsuarioDAO  extends  JpaRepository<Usuario, Long> {
	
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	
	/* select el objeto usuario donde donde el atributo "username" sea igual al valor proporcionado en el parámetro número 1 
	@Query(value="select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);*/
	
	
	
	
}
