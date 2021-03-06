package com.Lojao_Games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_Usuario")
public class Usuario {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@NotNull
@Size(min = 3)
private String nome;

@Size(max = 5000)
private String foto;

@NotNull
@Email
private String usuario;

@NotNull
@Size(min = 8)
private String senha;

@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List<Produto> produto;



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public List<Produto> getProduto() {
	return produto;
}

public void setProduto(List<Produto> produto) {
	this.produto = produto;
}

	
	
	
	
	

}
