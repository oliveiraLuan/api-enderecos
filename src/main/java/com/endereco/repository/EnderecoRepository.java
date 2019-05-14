package com.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endereco.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
	Endereco findByCep(String cep);
}
