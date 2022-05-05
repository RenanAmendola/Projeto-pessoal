package com.Lojao_Games.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Lojao_Games.model.Produto;
import com.Lojao_Games.repository.ProdutoRepository;

@RestController
@RequestMapping("/Lojao_Games")
@CrossOrigin("*")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository proRe;
	
	@GetMapping
	public ResponseEntity<List<Produto>>GetAll(){
		
		return ResponseEntity.ok(proRe.findAll());
	}


@GetMapping("/{id}")
	public ResponseEntity<Produto> getbyId(@PathVariable Long id){
		return proRe.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
}
	
	
@GetMapping("/Produto/{nome}")
	public ResponseEntity<List<Produto>>getByNome(@PathVariable String nome){
		return ResponseEntity.ok(proRe.findAllByNomeContainingIgnoreCase(nome));
}
	
	
@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto produto){
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(proRe.save(produto));
}
	
@PutMapping
public ResponseEntity<Produto> put(@Valid @RequestBody Produto produto){
		return proRe.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(proRe.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
				}


@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	Optional<Produto> produto = proRe.findById(id);

		if(produto.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		proRe.deleteById(id);



}







}
