package br.com.bellaface.vendas.model;

import java.time.LocalDate;

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
	
	@Column(name = "flTipoAlteracao")
	private String flTipoAlteracao;
	
	@Column(name = "flAtivo")
	private String flAtivo;
	
	@Column(name = "dtAlteracao")
	private LocalDate dtAlteracao;
	
	@Column(name = "dtCriacao")
	private LocalDate dtCriacao;
}
