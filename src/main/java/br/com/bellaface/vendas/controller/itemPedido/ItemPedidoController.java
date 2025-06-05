package br.com.bellaface.vendas.controller.itemPedido;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.itemPedido.CadastroDeItemPedido;
import br.com.bellaface.vendas.model.itemPedido.ItemPedido;
import br.com.bellaface.vendas.repository.itemPedido.ItemPedidoRepository;

@RestController
@RequestMapping("itemPedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@GetMapping
	public ResponseEntity<?> listaDeItensPedido() {
		List<ItemPedido> listaDeItensPedido = itemPedidoRepository.findAll();
		return ResponseEntity.ok().body(Collections.singletonMap("itenspedido", listaDeItensPedido));
	}
	
	@GetMapping("nuPedido")
	public ResponseEntity<?> listaItensPedidoByNuPedido(@RequestParam Integer nuPedido) {
		List<ItemPedido> listaDeItensPedido = itemPedidoRepository.findByNuPedido(nuPedido);
		return ResponseEntity.ok().body(Collections.singletonMap("itenspedido", listaDeItensPedido));
	}
	
	@PostMapping
	public ItemPedido cadastrar(@RequestBody CadastroDeItemPedido cadastroDeItemPedido) {
		// VALIDAÇÃO SERÁ NO FRONT
		// Alterar tudo para messages
		String flTipoAlteracao = "I"; 
		String flAtivo = "S";
		LocalDate dtAlteracao = LocalDate.now();
		LocalDate dtCriacao = LocalDate.now();
		
		return itemPedidoRepository.save(new ItemPedido(cadastroDeItemPedido.cdItemPedido(), cadastroDeItemPedido.cdProduto(), cadastroDeItemPedido.nuPedido(), cadastroDeItemPedido.qtdItem(), cadastroDeItemPedido.vlUnitario(), cadastroDeItemPedido.vlTotalItem(), flTipoAlteracao, flAtivo, dtAlteracao, dtCriacao));
	}
}