package com.Lojao_Games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Lojao_Games.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto>findAllByNomeContainingIgnoreCase(String nome);

}
