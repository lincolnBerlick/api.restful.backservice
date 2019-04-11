package com.restful.api;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restful.api.models.Usuario;
import com.restful.api.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {
	
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void createShouldersistData() {
		
		Usuario usuario = new Usuario();
		
		usuario.setUsername("Lincoln");
		usuario.setEmaill("lincoln@lincoln.com");
		this.usuarioRepository.save(usuario);
	
		assertThat(usuario.getUser_id()).isNotNull();
		assertThat(usuario.getUsername()).isEqualTo("Lincoln");
		assertThat(usuario.getEmail()).isEqualTo("lincoln@lincoln.com");
		
		
		
	}
	
	
	@Test
	public void Delete () {
		Usuario usuario = new Usuario();
		

		usuario.setUsername("Lincoln");
		usuario.setEmaill("lincoln@lincoln.com");
		this.usuarioRepository.save(usuario);
		usuarioRepository.delete(usuario);
		assertThat(usuarioRepository.findById(usuario.getUser_id())).isNull();;
		
		
		
	}
	

	

}
