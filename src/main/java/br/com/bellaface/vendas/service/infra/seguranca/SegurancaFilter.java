package br.com.bellaface.vendas.service.infra.seguranca;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.bellaface.vendas.repository.cliente.ClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SegurancaFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		var token = this.recoveryToken(request);
		
		if(token != null) {
			var dsLogin = tokenService.validateToken(token);
			
			UserDetails cliente = clienteRepository.findByDsLogin(dsLogin);
			
			var authentication = new UsernamePasswordAuthenticationToken(cliente,  null, cliente.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String recoveryToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		
		if(authHeader == null ) return null;
		
		return authHeader.replace("Bearer ", "");
	}

}
