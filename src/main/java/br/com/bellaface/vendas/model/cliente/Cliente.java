package br.com.bellaface.vendas.model.cliente;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBBFWCLIENTE")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	@Id
	@Column(name = "cdCliente")
	private Integer cdCliente;
	
	@Column(name = "nmRazaoSocial")
	private String nmRazaoSocial;
	
	@Column(name = "dsLogin")
	private String dsLogin;
	
	@Column(name = "dsSenha")
	private String dsSenha;
	
	@Column(name = "flTipoAlteracao")
	private String flTipoAlteracao;
	
	@Column(name = "flAtivo")
	private String flAtivo;
	
	@Column(name = "dtAlteracao")
	private LocalDate dtAlteracao;
	
	@Column(name = "dtCriacao")
	private LocalDate dtCriacao;
}
