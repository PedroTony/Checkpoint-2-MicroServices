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

import br.com.fiap.checkpoint2.controller.dto.itempedido.ItemPedidoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.itempedido.ItemPedidoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.itempedido.SearchedItemPedido;
import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.repository.ItemPedidoRepository;
import br.com.fiap.checkpoint2.service.ItemPedidoService;



@RestController
@RequestMapping("/itempedidos")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@GetMapping
	public List<SearchedItemPedido> listAll() {
		List<SearchedItemPedido> result = 
				itemPedidoService.list()
				.stream()
				.map(SearchedItemPedido::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping	
	public ItemPedido create(@RequestBody ItemPedidoRequestCreate dto) {
		
		ItemPedido itemPedido = new ItemPedido();
		
		
		itemPedido.setCodigo_produto(dto.getCodigo_produto());		
		itemPedido.setNumero_pedido(dto.getNumero_pedido());
		itemPedido.setQuantidade(dto.getQuantidade());		
		itemPedido.setValor_total(dto.getValor_total());		

		
		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@PutMapping
	public ItemPedido update(@RequestBody ItemPedidoRequestUpdate dto) {
		
		boolean exists =
				itemPedidoRepository.existsById(dto.getSequencia());
		
		if (!exists) {
			throw new RuntimeException("Codigo do Produto não encontrado " 
							+ dto.getCodigo_produto());			
		}
		ItemPedido itemPedido = new ItemPedido();

		itemPedido.setSequencia(dto.getSequencia());
		itemPedido.setCodigo_produto(dto.getCodigo_produto());		
		itemPedido.setNumero_pedido(dto.getNumero_pedido());
		itemPedido.setQuantidade(dto.getQuantidade());		
		itemPedido.setValor_total(dto.getValor_total());		

		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@DeleteMapping(value = "{sequencia}")
	public void delete(@PathVariable Long sequencia) {
		itemPedidoRepository.deleteById(sequencia);		
	}

}
