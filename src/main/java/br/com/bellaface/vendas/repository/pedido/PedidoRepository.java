package br.com.bellaface.vendas.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bellaface.vendas.model.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query("SELECT COALESCE(MAX(p.nuPedido), 0) FROM Pedido p")
    int findMaxNuPedido();
	
	Pedido findFirstByCdClienteAndFlStatusPedido(Integer cdCliente, String flStatusPedido);

}
