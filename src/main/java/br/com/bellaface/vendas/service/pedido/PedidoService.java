package br.com.bellaface.vendas.service.pedido;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bellaface.vendas.model.itemPedido.ItemPedido;
import br.com.bellaface.vendas.repository.itemPedido.ItemPedidoRepository;

@Service
public class PedidoService {
	
	public static PedidoService instance;
	
	public static PedidoService getInstance() {
		if (instance == null) {
			instance = new PedidoService();
		}
		return instance;
	}
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public boolean isFinalDeSemana() {
		LocalDate diaAtual = LocalDate.now();
        DayOfWeek diaDaSemana = diaAtual.getDayOfWeek();

        if (diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY) {
            return true;
        } 
        
        return false;
        
    }
	
	public Double validaTotalPedido(int nuPedido) {
		List<ItemPedido> itens = itemPedidoRepository.findByNuPedido(nuPedido);
		int itensNoPedido = itens.size();
		Double vlTotalItensNoPedido = 0.0;
		
		if(itens == null || itensNoPedido == 0) {
			return 0.0;
		}
		
		for (int i = 0; i < itensNoPedido; i++ ) {
			Double vlUnitario = itens.get(i).getVlUnitario();
			int qtdItem = itens.get(i).getQtdItem();
			
			Double vlTotalItem = qtdItem * vlUnitario;
			vlTotalItensNoPedido = vlTotalItensNoPedido + vlTotalItem;
		}
		
		return vlTotalItensNoPedido;
	}
}
