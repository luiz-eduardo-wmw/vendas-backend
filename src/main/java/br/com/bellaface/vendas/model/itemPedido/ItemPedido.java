package br.com.bellaface.vendas.model.itemPedido;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBBFWITEMPEDIDO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
	@Id
	@Column(name = "cdItemPedido")
	private Integer cdItemPedido;
	
	@Column(name = "cdProduto")
	private Integer cdProduto;
	
	@Column(name = "nuPedido")
	private Integer nuPedido;
	
	@Column(name = "qtdItem")
	private Integer qtdItem;
	
	@Column(name = "vlUnitario")
	private Double vlUnitario;
	
	@Column(name = "vlTotalItem")
	private Double vlTotalItem;
	
	@Column(name = "flTipoAlteracao")
	private String flTipoAlteracao;
	
	@Column(name = "flAtivo")
	private String flAtivo;
	
	@Column(name = "dtAlteracao")
	private LocalDate dtAlteracao;
	
	@Column(name = "dtCriacao")
	private LocalDate dtCriacao;
}
