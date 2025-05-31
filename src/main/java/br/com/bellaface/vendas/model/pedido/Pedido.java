package br.com.bellaface.vendas.model.pedido;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBBFWPEDIDO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	@Id
	@Column
	private Integer nuPedido;
	
	@Column(name = "cdCliente")
	private Integer cdCliente;
	
	@Column(name = "vlTotalPedido")
	private Double vlTotalPedido;
	
	@Column(name = "dsObsPedido")
	private String dsObsPedido;
	
	@Column(name = "flTipoAlteracao")
	private String flTipoAlteracao;
	
	@Column(name = "dtAlteracao")
	private LocalDate dtAlteracao;
	
	@Column(name = "dtCriacao")
	private LocalDate dtCriacao;
}
