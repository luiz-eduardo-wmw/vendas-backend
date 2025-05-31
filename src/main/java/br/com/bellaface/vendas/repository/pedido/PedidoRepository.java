package br.com.bellaface.vendas.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bellaface.vendas.model.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
