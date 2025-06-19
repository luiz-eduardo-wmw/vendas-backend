package br.com.bellaface.vendas.model.cliente;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Cliente implements UserDetails{
	@Id
	@Column(name = "cdCliente")
	private Integer cdCliente;
	
	@Column(name = "nmRazaoSocial")
	private String nmRazaoSocial;
	
	@Column(name = "dsLogin")
	private String dsLogin;
	
	@Column(name = "dsSenha")
	private String dsSenha;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("CLIENTE"));
	}
	
	@Override
	public String getPassword() {
		return this.dsSenha;
	}
	
	@Override
	public String getUsername() {
		return this.dsLogin;
	}
}
