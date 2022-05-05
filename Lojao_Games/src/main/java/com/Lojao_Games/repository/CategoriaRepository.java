package com.Lojao_Games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lojao_Games.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria>findAllByDescricaoContainingIgnoreCase(String descricao);

}
