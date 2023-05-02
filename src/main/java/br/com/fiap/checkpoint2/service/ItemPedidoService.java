package br.com.fiap.checkpoint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itempedidoRepository;

	public List<ItemPedido> list() {
		return itempedidoRepository.findAll();
	}
	
	public ItemPedido save(ItemPedido itemPedido) {			
		return itempedidoRepository.save(itemPedido);
	}
}
