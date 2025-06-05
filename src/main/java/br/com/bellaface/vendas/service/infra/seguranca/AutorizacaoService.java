package br.com.bellaface.vendas.service.infra.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import br.com.bellaface.vendas.repository.cliente.ClienteRepository;

@Service
public class AutorizacaoService implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public UserDetails loadUserByUsername(String dsLogin) throws UsernameNotFoundException {
		return clienteRepository.findByDsLogin(dsLogin);
	}
}
