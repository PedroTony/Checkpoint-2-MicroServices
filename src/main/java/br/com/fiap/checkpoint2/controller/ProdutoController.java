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

import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestCreate;
import br.com.fiap.checkpoint2.controller.dto.produto.ProdutoRequestUpdate;
import br.com.fiap.checkpoint2.controller.dto.produto.SearchedProduto;
import br.com.fiap.checkpoint2.model.Produto;
import br.com.fiap.checkpoint2.repository.ProdutoRepository;
import br.com.fiap.checkpoint2.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<SearchedProduto> listAll() {
		List<SearchedProduto> result = 
				produtoService.list()
				.stream()
				.map(SearchedProduto::toDto)
				.collect(Collectors.toList());
		return result;
	}

	@PostMapping	
	public Produto create(@RequestBody ProdutoRequestCreate dto) {
		
		Produto produto = new Produto();
		
		
		produto.setNome(dto.getNome());		
		produto.setPreco(dto.getPreco());
		produto.setData_garantia(dto.getData_garantia());		
		produto.setData_validade(dto.getData_validade());
		produto.setEmEstoque(dto.isEmEstoque());		

		
		Produto result = produtoService.save(produto);
		return result;
	}

	@PutMapping
	public Produto update(@RequestBody ProdutoRequestUpdate dto) {
		
		boolean exists =
				produtoRepository.existsById(dto.getCodigo_produto());
		
		if (!exists) {
			throw new RuntimeException("Codigo do Produto não encontrado " 
							+ dto.getCodigo_produto());			
		}
		Produto produto = new Produto();

		produto.setCodigo_produto(dto.getCodigo_produto());
		produto.setNome(dto.getNome());		
		produto.setPreco(dto.getPreco());
		produto.setData_garantia(dto.getData_garantia());		
		produto.setData_validade(dto.getData_validade());
		produto.setEmEstoque(dto.isEmEstoque());	

		Produto result = produtoService.save(produto);
		return result;
	}

	@DeleteMapping(value = "{$codigo_produto}")
	public void delete(@PathVariable Long codigo_produto) {
		produtoRepository.deleteById(codigo_produto);		
	}
	


}
