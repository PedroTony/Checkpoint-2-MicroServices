package br.com.fiap.checkpoint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> list() {
        return pedidoRepository.findAll();
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

}