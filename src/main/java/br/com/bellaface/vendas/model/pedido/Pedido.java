package br.com.bellaface.vendas.model.pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "nuPedido")
	private Integer nuPedido;
	
	@Column(name = "cdCliente")
	private Integer cdCliente;
	
	@Column(name = "vlTotalPedido")
	private Double vlTotalPedido;
	
	@Column(name = "dsObsPedido")
	private String dsObsPedido;
	 
	@Column(name = "flstatuspedido")
	private String flStatusPedido;
	
	@Column(name = "dtCriacao")
	private LocalDateTime dtCriacao;
	
	public void setFlStatusPedido(String flStatusPedido) {
	    this.flStatusPedido = flStatusPedido;
	}

	public void setDsObsPedido(String dsObsPedido) {
		this.dsObsPedido = dsObsPedido;
	}

	public void setVlTotalPedido(Double vlTotalPedido) {
		this.vlTotalPedido = vlTotalPedido;
	}
}
