package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.cliente.ClienteRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.cliente.SearchedCliente;
import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.repository.ClienteRepository;
import br.com.fiap.checkpoint2.service.ClienteService;




@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<SearchedCliente> listAll() {
		List<SearchedCliente> result = 
				clienteService.list()
				.stream()
				.map(SearchedCliente::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping	
	public Cliente create(@RequestBody ClienteRequestCreate dto) {

		
		Cliente cliente = new Cliente();
		
		cliente.setNome(dto.getNome());
		cliente.setCep(dto.getCep());	
		cliente.setInscricao_federal(dto.getInscricao_federal());
		
		Cliente result = clienteService.save(cliente);
		return result;
	}

	@PutMapping
	public Cliente update(@RequestBody ClienteRequestUpdate dto) {
		
		boolean exists =
				clienteRepository.existsById(dto.getCodigo_cliente());
		
		if (!exists) {
			throw new RuntimeException("Id não encontrado " 
							+ dto.getCodigo_cliente());			
		}
		Cliente cliente = new Cliente();

		cliente.setCodigo_cliente(dto.getCodigo_cliente());
		cliente.setNome(dto.getNome());
		cliente.setCep(dto.getCep());	
		cliente.setInscricao_federal(dto.getInscricao_federal());

		Cliente result = clienteService.save(cliente);
		return result;
	}

	@DeleteMapping(value = "{codigo_cliente}")
	public void delete(@PathVariable Long codigo_cliente) {
		clienteRepository.deleteById(codigo_cliente);		
	}

}
