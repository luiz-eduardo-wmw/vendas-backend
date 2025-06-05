package br.com.bellaface.vendas.repository.itemPedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bellaface.vendas.model.itemPedido.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

	List<ItemPedido> findByNuPedido(Integer nuPedido);

}
