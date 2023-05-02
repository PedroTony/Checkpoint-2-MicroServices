package br.com.fiap.checkpoint2.controller.dto.pedido;

import java.time.LocalDate;


public class PedidoRequestCreate {
    private Long codigo_cliente;
    private LocalDate data_pedido;
    
    public Long getCodigo_cliente() {
        return codigo_cliente;
    }
    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    public LocalDate getData_pedido() {
        return data_pedido;
    }
    public void setData_pedido(LocalDate data_pedido) {
        this.data_pedido = data_pedido;
    }
    
}
