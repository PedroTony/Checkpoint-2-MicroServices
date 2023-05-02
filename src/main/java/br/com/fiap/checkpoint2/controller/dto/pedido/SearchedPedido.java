package br.com.fiap.checkpoint2.controller.dto.pedido;

import br.com.fiap.checkpoint2.model.Pedido;


public class SearchedPedido {
    private Long numero_pedido, codigo_cliente;

    public Long getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Long numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Long getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    public static SearchedPedido toDto(Pedido pedido){
        SearchedPedido dto = new SearchedPedido();
        dto.setNumero_pedido(pedido.getNumero_pedido());
        dto.setCodigo_cliente(pedido.getCodigo_cliente());
        return dto;
    }
}
