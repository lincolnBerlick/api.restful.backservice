package com.restful.api.sources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.api.models.Usuario;
import com.restful.api.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value="/api")
@Api(value="API EstoqueDB")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuariorepository;
	
	
	
	@GetMapping(path="/usuario/byid/{id}")
	public ResponseEntity<?> getuserbyid(@PathVariable(value ="id") long id, @AuthenticationPrincipal UserDetails userDetails){
		
		Usuario usuario = usuariorepository.findById(id);
		System.out.println(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
		
		
		
	}
	
	@GetMapping("/usuario")
	@ApiOperation(value ="retorna lista de usuarios")
	public List<Usuario> listaUsers(){
		
		return (List<Usuario>) usuariorepository.findAll();
		
		
	}
	
	@ApiOperation(value ="retorna um usuario")
	@GetMapping("/usuario/{name}")
	public Usuario listaUser(@PathVariable(value="name") String name){
	
		return usuariorepository.findByusername(name);
		
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value ="salva um usuario")
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		BCryptPasswordEncoder passencode = new BCryptPasswordEncoder();
		usuario.setUser_Senha(passencode.encode(usuario.getUser_Senha()));
		return usuariorepository.save(usuario);
		
	}
	
	@ApiOperation(value ="deleta um usuario")
	@DeleteMapping("/usuario")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleterUsuario(@RequestBody Usuario usuario) {
		usuariorepository.delete(usuario);
	}
	
	
	@ApiOperation(value ="atualiza um usuario")
	@PutMapping("/usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		return usuariorepository.save(usuario);
	}
	
	
	

}