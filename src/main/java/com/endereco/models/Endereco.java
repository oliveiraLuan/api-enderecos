package com.endereco.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_endereco")
public class Endereco {
	@Id
	private String cep;
	@NotNull
	private String logradouro;
	@NotNull
	private String bairro;
	@NotNull
	private String cidade;
	@NotNull
	private String estado;
	@NotNull
	private String pais;
	
	//Getters
	public String getCep() {
		return cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getPais() {
		return pais;
	}
	
	//Setters
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}	
}
