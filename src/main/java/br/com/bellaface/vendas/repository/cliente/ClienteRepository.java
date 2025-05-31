package br.com.bellaface.vendas.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bellaface.vendas.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
