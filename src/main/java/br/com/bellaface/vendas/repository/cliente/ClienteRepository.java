package br.com.bellaface.vendas.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.bellaface.vendas.model.cliente.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	UserDetails findByDsLogin(String dsLogin);

}
