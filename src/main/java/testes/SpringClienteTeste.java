package testes;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.restful.api.models.Usuario;

public class SpringClienteTeste {
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplateBuilder()
				.rootUri("http://localhost:8080/v1/usuario/byid")
				.basicAuthentication("lincoln14", "strong").build();
		
		RestTemplate restTemplate2 = new RestTemplateBuilder()
				.rootUri("http://localhost:8080/v1/usuario")
				.basicAuthentication("lincoln14", "strong").build();
		
		
		Usuario usuario =  restTemplate.getForObject("/{id}", Usuario.class, 36);
		
		Usuario[] usuarios = restTemplate2.getForObject("/", Usuario[].class);
		ResponseEntity<Usuario> fEntity = restTemplate.getForEntity("/{id}",  Usuario.class, 36);
		System.out.println(usuario);
		System.out.println(fEntity.getBody());
		System.out.println(Arrays.toString(usuarios)+ "\n\n\n\n");
		
		
		ResponseEntity<List<Usuario>> exchange = restTemplate2.exchange("/", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Usuario>>() {
			
				});
		System.out.println(exchange.getBody());
		
	}

}
