package br.com.bellaface.vendas.model.produto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBBFWPRODUTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	@Id
	@Column(name = "cdProduto")
	private Integer cdProduto;
	
	@Column(name = "nmProduto")
	private String nmProduto;
	
	@Column(name = "dsProduto")
	private String dsProduto;
	
	@Column(name = "vlProduto")
	private Double vlProduto;
	
	@Column(name = "dtCriacao")
	private LocalDateTime dtCriacao;
}
