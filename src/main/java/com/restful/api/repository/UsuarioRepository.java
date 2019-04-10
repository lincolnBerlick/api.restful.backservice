package com.restful.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findById(long id);
	
	Usuario findByusername(String username);
	
}
	
	
