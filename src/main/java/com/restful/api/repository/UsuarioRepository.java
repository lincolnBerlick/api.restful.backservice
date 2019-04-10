package com.restful.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.restful.api.models.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
	
	Usuario findById(long id);
	
	Usuario findByusername(String username);
	
}
	
	
