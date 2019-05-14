package com.endereco.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.endereco.response.ResponseTransfer;

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
	public ResponseTransfer adicionarEndereco(@RequestBody Endereco endereco) {
		try {
			enderecoRepository.save(endereco);
			return new ResponseTransfer("Sucesso","Endereço cadastrado com sucesso");
		}catch(Exception e) {
			return new ResponseTransfer("Erro", e.getMessage().toString());
		}
	}
	@DeleteMapping(value="endereco/{cep}")
	public ResponseTransfer deletarEndereco(@PathVariable(value="cep") String cep) {
		try {
			enderecoRepository.delete(enderecoRepository.findByCep(cep));
			return new ResponseTransfer("Sucesso", "Endereço deletado com sucesso");
		}catch(Exception e){
			return new ResponseTransfer("Erro", e.getMessage().toString());
		}
		
	}
	
	
}
