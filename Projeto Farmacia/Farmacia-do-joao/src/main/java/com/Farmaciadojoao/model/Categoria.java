package com.Farmaciadojoao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_Categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max = 150)
	private String descricao;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String tipo;
	
	@NotNull
	@Size(min = 1,max = 4)
	private String generico;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String usar;
	
	@NotNull
	@Size(min = 1,max = 4)
	private String tarja_preta;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")	
	private List<Produto> produto;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public String getUsar() {
		return usar;
	}

	public void setUsar(String usar) {
		this.usar = usar;
	}

	public String getTarja_preta() {
		return tarja_preta;
	}

	public void setTarja_preta(String tarja_preta) {
		this.tarja_preta = tarja_preta;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}