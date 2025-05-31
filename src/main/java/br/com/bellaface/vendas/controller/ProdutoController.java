package br.com.bellaface.vendas.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.CadastroDeProduto;
import br.com.bellaface.vendas.model.Produto;
import br.com.bellaface.vendas.repository.ProdutoRepository;

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
		// VALIDAÇÃO SERÁ NO FRONT
		// Alterar tudo para messages
		String flTipoAlteracao = "I"; 
		String flAtivo = "S";
		LocalDate dtAlteracao = LocalDate.now();
		LocalDate dtCriacao = LocalDate.now();
		
		return produtoRepository.save(new Produto(cadastroDeProduto.cdProduto(), cadastroDeProduto.nmProduto(), cadastroDeProduto.dsProduto(), cadastroDeProduto.vlProduto(), flTipoAlteracao, flAtivo, dtAlteracao, dtCriacao));
	}
	

}
