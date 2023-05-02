package br.com.fiap.checkpoint2.controller.dto.itempedido;

public class ItemPedidoRequestUpdate {
	
	private Long sequencia;
	private Long numero_pedido;
	private Long codigo_produto;
	private int quantidade;
	private double valor_total;
	
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}


}
