package br.com.fiap.checkpoint2.controller.dto.itempedido;

import br.com.fiap.checkpoint2.model.ItemPedido;


public class SearchedItemPedido {
    private Long sequencia;
	private Long numero_pedido;
	private Long codigo_produto;
	

	public Long getSequencia() {
		return sequencia;
	}


	public void setSequencia(Long sequencia) {
		this.sequencia = sequencia;
	}

	public Long getNumero_pedido() {
		return numero_pedido;
	}


	public void setNumero_pedido(Long numero_pedido) {
		this.numero_pedido = numero_pedido;
	}


	public Long getCodigo_produto() {
		return codigo_produto;
	}


	public void setCodigo_produto(Long codigo_produto) {
		this.codigo_produto = codigo_produto;
	}



	public static SearchedItemPedido toDto(ItemPedido itemPedido) {
		SearchedItemPedido dto = new SearchedItemPedido();
		dto.setSequencia(itemPedido.getSequencia());
		dto.setCodigo_produto(itemPedido.getCodigo_produto());
		dto.setNumero_pedido(itemPedido.getNumero_pedido());		
		return dto;
	}


}
