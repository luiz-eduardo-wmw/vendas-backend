package br.com.bellaface.vendas.service.itemPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bellaface.vendas.dto.itemPedido.CadastroDeItemPedido;
import br.com.bellaface.vendas.repository.itemPedido.ItemPedidoRepository;
import br.com.bellaface.vendas.repository.pedido.PedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	public boolean existeNuPedidoNulo(List<CadastroDeItemPedido> listaDeItensDoPedido) {
		return listaDeItensDoPedido.stream()
		        .anyMatch(item -> item.nuPedido() == null);
	}
	
	public boolean existeCdItemPedidoNulo(List<CadastroDeItemPedido> listaDeItensDoPedido) {
		return listaDeItensDoPedido.stream()
		        .anyMatch(item -> item.cdItemPedido() == null);
	}
	
	public int proximoNuPedido() {
		int maxNuPedido = pedidoRepository.findMaxNuPedido();
	    return maxNuPedido + 1;
	}
	
	public int proximoCdItemPedido() {
		int maxCdItemPedido = itemPedidoRepository.findMaxCdItemPedido();
	    return maxCdItemPedido + 1;
	}
	
	
}
