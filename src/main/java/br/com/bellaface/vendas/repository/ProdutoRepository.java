package br.com.bellaface.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bellaface.vendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
