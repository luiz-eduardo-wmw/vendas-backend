package br.com.bellaface.vendas.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.login.LoginDoUsuario;
import br.com.bellaface.vendas.model.cliente.Cliente;
import br.com.bellaface.vendas.service.infra.seguranca.TokenService;

@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity logar(@RequestBody LoginDoUsuario loginDoUsuario) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(loginDoUsuario.dsLogin(), loginDoUsuario.dsSenha());
		
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Cliente) auth.getPrincipal());
		
		return ResponseEntity.ok(token);
	}
	

}
