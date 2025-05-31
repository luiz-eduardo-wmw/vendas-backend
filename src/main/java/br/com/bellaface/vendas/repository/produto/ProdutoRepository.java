package br.com.bellaface.vendas.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bellaface.vendas.model.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
