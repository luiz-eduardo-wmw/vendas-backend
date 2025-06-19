package br.com.bellaface.vendas.repository.itemPedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bellaface.vendas.model.itemPedido.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

	List<ItemPedido> findByNuPedido(Integer nuPedido);
	
	@Query("SELECT COALESCE(MAX(i.cdItemPedido), 0) FROM ItemPedido i")
    int findMaxCdItemPedido();

}
