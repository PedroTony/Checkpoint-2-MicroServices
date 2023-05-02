package br.com.fiap.checkpoint2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> list() {
		return produtoRepository.findAll();
	}
	
	public Produto save(Produto produto) {			
		return produtoRepository.save(produto);
	}
}
