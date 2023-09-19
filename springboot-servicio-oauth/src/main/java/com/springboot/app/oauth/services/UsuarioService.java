package com.springboot.app.oauth.services;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springboot.app.commons.usuarios.models.entity.Usuario;
import com.springboot.app.oauth.clients.IUsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {
	
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	private IUsuarioFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = client.findByUsername(username);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("No existe el usuario en el sistema ");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map( role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek( authorithy -> log.info("Role: " + authorithy.getAuthority()))
				.collect(Collectors.toList());
				
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(),true, true, true, authorities);
	}

}
