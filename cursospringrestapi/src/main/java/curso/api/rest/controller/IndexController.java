package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping(value="/{id}/codigovenda/{venda}",produces="application/json")
	public ResponseEntity<Usuario> relatorio(@PathVariable (value = "id") Long id,@PathVariable (value = "venda") Long venda )	{	
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	
	}
	
	
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id )	{	
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	
	}
	
	@GetMapping(value = "/",produces="application/json")
	public ResponseEntity<List<Usuario>> todos(){
		
		
		List<Usuario> usuario = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);
	}
	
	/**
	 * Endpoint responsável por cadastrar um novo usuário e seus telefones.
	 * 
	 * Ao receber o JSON, o método associa cada telefone ao usuário antes de salvar,
	 * garantindo que o campo usuario_id da tabela telefone seja preenchido.
	 */
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

	    // Verifica se há telefones antes de percorrer a lista
	    if (usuario.getTelefones() != null && !usuario.getTelefones().isEmpty()) {

	        // Percorre cada telefone e define o "pai" (usuario)
	        for (int pos = 0; pos < usuario.getTelefones().size(); pos++) {
	            usuario.getTelefones().get(pos).setUsuario(usuario);
	        }
	    }

	    // Salva o usuário (e em cascata, os telefones)
	    Usuario usuarioSalvo = usuarioRepository.save(usuario);

	    // Retorna 201 (Created) com o JSON do usuário salvo
	    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	
	
	@PutMapping(value = "/", produces="application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
	    if (usuario.getId() == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }

	    Usuario usuarioAtualizado = usuarioRepository.save(usuario);
	    return ResponseEntity.ok(usuarioAtualizado);
	}
	
	
	@DeleteMapping(value = "/{id}", produces="application/json")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
	    if (!usuarioRepository.existsById(id)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Usuário não encontrado para exclusão.");
	    }

	    usuarioRepository.deleteById(id);
	    return ResponseEntity.ok("Usuário deletado com sucesso.");
	}
	
}
