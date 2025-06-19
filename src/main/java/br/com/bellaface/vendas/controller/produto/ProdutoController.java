package br.com.bellaface.vendas.controller.produto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.produto.CadastroDeProduto;
import br.com.bellaface.vendas.model.produto.Produto;
import br.com.bellaface.vendas.repository.produto.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<?> listaDeProdutos() {
		List<Produto> listaDeProdutos = produtoRepository.findAll();
		return ResponseEntity.ok().body(Collections.singletonMap("produtos", listaDeProdutos));
	}
	
	@PostMapping
	public Produto cadastrar(@RequestBody CadastroDeProduto cadastroDeProduto) {
		return produtoRepository.save(new Produto(cadastroDeProduto.cdProduto(), cadastroDeProduto.nmProduto(), cadastroDeProduto.dsProduto(), cadastroDeProduto.vlProduto(), LocalDateTime.now()));
	}
	

}
