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

import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.pedido.PedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.pedido.SearchedPedido;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public List<SearchedPedido> listall() {
		List<SearchedPedido> searchedPessoa = pedidoService.list().stream().map(SearchedPedido::toDto)
				.collect(Collectors.toList());
		return searchedPessoa;
	}

	@PostMapping
	public Pedido create(@RequestBody PedidoRequestCreate dto) {
		Pedido pedido = new Pedido();
		pedido.setCodigo_cliente(dto.getCodigo_cliente());
		pedido.setData_pedido(dto.getData_pedido());
		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@PutMapping
	public Pedido update(@RequestBody PedidoRequestUpdate dto) {
		
		boolean exists =
				pedidoRepository.existsById(dto.getNumero_pedido());
		
		if (!exists) {
			throw new RuntimeException("Id nÃ£o encontrado " 
							+ dto.getNumero_pedido());			
		}
		
		Pedido pedido = new Pedido();
		pedido.setCodigo_cliente(dto.getCodigo_cliente());
		pedido.setData_pedido(dto.getData_pedido());
		pedido.setNumero_pedido(dto.getNumero_pedido());
		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@DeleteMapping(value = "{numero_pedido}")
	public void delete(@PathVariable Long numero_pedido) {
		pedidoRepository.deleteById(numero_pedido);
	}

}