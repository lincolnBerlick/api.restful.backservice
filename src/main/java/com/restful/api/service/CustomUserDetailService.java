package com.restful.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.restful.api.models.Usuario;
import com.restful.api.repository.UsuarioRepository;

@Component
public class CustomUserDetailService  implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	
	
	
	@Autowired
	public CustomUserDetailService(UsuarioRepository usuarioRepository) {
		
		this.usuarioRepository = usuarioRepository;
	}





	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByusername(username);
		List<GrantedAuthority> authorityListAdmin =AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser =AuthorityUtils.createAuthorityList("ROLE_USER");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUser_Senha(), authorityListAdmin);
		
		
	}

}
