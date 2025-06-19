package br.com.bellaface.vendas.controller.itemPedido;

import java.util.ArrayList;
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
import br.com.bellaface.vendas.service.itemPedido.ItemPedidoService;

@RestController
@RequestMapping("itemPedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@GetMapping("listaItensPorNuPedido")
	public ResponseEntity<?> listaItensPedidoByNuPedido(@RequestParam Integer nuPedido) {
		List<ItemPedido> listaDeItensPedido = itemPedidoRepository.findByNuPedido(nuPedido);
		return ResponseEntity.ok().body(Collections.singletonMap("itenspedido", listaDeItensPedido));
	}
	
	@GetMapping("listaItensPorNuPedidoECdProduto")
	public ResponseEntity<?> listaItensPedidoByNuPedidoAndCdProduto(@RequestParam Integer nuPedido, @RequestParam Integer cdProduto) {
		List<ItemPedido> listaDeItensPedido = itemPedidoRepository.findByNuPedido(nuPedido);
		return ResponseEntity.ok().body(Collections.singletonMap("itenspedido", listaDeItensPedido));
	}
	
	@PostMapping
	public List<ItemPedido> insereItensNoPedido(@RequestBody List<CadastroDeItemPedido> itensPedido) {
		Integer proximoNuPedido = null;
		Integer proximoCdItemPedido = null;
		
	    if (itemPedidoService.existeNuPedidoNulo(itensPedido)) {
	        proximoNuPedido = itemPedidoService.proximoNuPedido();
	    }
	    
	    if (itemPedidoService.existeCdItemPedidoNulo(itensPedido)) {
	    	proximoCdItemPedido = itemPedidoService.proximoCdItemPedido();
	    }
		
	    List<ItemPedido> itensSalvos = new ArrayList<>();

	    for (CadastroDeItemPedido dto : itensPedido) {
	        Integer nuPedido = dto.nuPedido() != null ? dto.nuPedido() : proximoNuPedido;

	        ItemPedido item = new ItemPedido(
	            proximoCdItemPedido++, 
	            dto.cdProduto(),
	            nuPedido,
	            dto.qtdItem(),
	            dto.vlUnitario(),
	            dto.vlTotalItem()
	        );

	        itensSalvos.add(itemPedidoRepository.save(item));
	    }

	    return itensSalvos;
	}
}