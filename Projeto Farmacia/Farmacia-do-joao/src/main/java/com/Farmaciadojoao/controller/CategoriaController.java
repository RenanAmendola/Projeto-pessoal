package com.Farmaciadojoao.controller;

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

import com.Farmaciadojoao.model.Categoria;
import com.Farmaciadojoao.repository.CategoriaRepository;

@RestController
@RequestMapping("/farmacia_jaoC")
@CrossOrigin("*")
public class CategoriaController {


	@Autowired
	private CategoriaRepository categoriaRe;

	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		
		return ResponseEntity.ok(categoriaRe.findAll());

}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaRe.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
		
@GetMapping("/categoria/{descricao}")
public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao){
	return ResponseEntity.ok(categoriaRe.findAllByDescricaoContainingIgnoreCase(descricao));

	
}

@PostMapping
public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(categoriaRe.save(categoria));

}

@PutMapping
public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
	return categoriaRe.findById(categoria.getId())
			.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(categoriaRe.save(categoria)))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
			
}


@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	Optional<Categoria> produto = categoriaRe.findById(id);
	
	if (produto.isEmpty())
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	
	categoriaRe.deleteById(id);
	
	
}







}
