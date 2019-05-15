package com.endereco.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endereco.models.Endereco;
import com.endereco.repository.EnderecoRepository;

@RestController
@RequestMapping(value="/api-enderecos")
public class EnderecoResource {
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@GetMapping(value="/enderecos")
	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}
	@GetMapping(value="/endereco/{cep}")
	public Endereco listarEndereco(@PathVariable(value="cep") String cep) {
		return enderecoRepository.findByCep(cep);
	}

	@PostMapping(value="/endereco")
	@ResponseBody
	public ResponseEntity<Endereco> adicionarEndereco(@RequestBody Endereco endereco) {
		try {
			Endereco novo = enderecoRepository.save(endereco);
			return ResponseEntity.status(201).body(novo);
		}catch(Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
	@DeleteMapping(value="endereco/{cep}")
	public ResponseEntity<Endereco> deletarEndereco(@PathVariable(value="cep") String cep) {
		try {
			Endereco cepBuscado = enderecoRepository.findByCep(cep);
			enderecoRepository.delete(cepBuscado);
			return ResponseEntity.status(204).body(cepBuscado);
		}catch(Exception e){
			return ResponseEntity.status(400).body(null);
		}
		
	}
	
	
}
