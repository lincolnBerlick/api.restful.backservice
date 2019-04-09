package com.restful.api.sources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/usuario")
	@ApiOperation(value ="retorna lista de usuarios")
	public List<Usuario> listaUsers(){
		
		return usuariorepository.findAll();
		
		
	}
	
	@ApiOperation(value ="retorna um usuario")
	@GetMapping("/usuario/{id}")
	public Usuario listaUser(@PathVariable(value="id") long id){
	
		return usuariorepository.findById(id);
		
		
	}
	
	@ApiOperation(value ="salva um usuario")
	@PostMapping("/usuario")
	public Usuario salvarUsuario(@RequestBody Usuario usuario) {
		return usuariorepository.save(usuario);
		
	}
	
	@ApiOperation(value ="deleta um usuario")
	@DeleteMapping("/usuario")
	public void deleterUsuario(@RequestBody Usuario usuario) {
		usuariorepository.delete(usuario);
	}
	
	@ApiOperation(value ="atualiza um usuario")
	@PutMapping("/usuario")
	public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
		return usuariorepository.save(usuario);
	}
	
	
	

}
