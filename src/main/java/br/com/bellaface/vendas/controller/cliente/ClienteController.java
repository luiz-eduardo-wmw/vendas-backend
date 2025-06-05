package br.com.bellaface.vendas.controller.cliente;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.cliente.CadastroDeCliente;
import br.com.bellaface.vendas.model.cliente.Cliente;
import br.com.bellaface.vendas.repository.cliente.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
		@Autowired
		private ClienteRepository clienteRepository;
		
		@GetMapping
		public ResponseEntity<?> listaDeClientes() {
			List<Cliente> listaDeClientes = clienteRepository.findAll();
			return ResponseEntity.ok().body(Collections.singletonMap("clientes", listaDeClientes));
		}
		
		@PostMapping
		public Cliente cadastrar(@RequestBody CadastroDeCliente cadastroDeCliente) {
			// VALIDAÇÃO SERÁ NO FRONT
			// Alterar tudo para messages
			String flTipoAlteracao = "I"; 
			String flAtivo = "S";
			LocalDate dtAlteracao = LocalDate.now();
			LocalDate dtCriacao = LocalDate.now();
			
			String encryptedPassword = new BCryptPasswordEncoder().encode(cadastroDeCliente.dsSenha());
			
			return clienteRepository.save(new Cliente(cadastroDeCliente.cdCliente(), cadastroDeCliente.nmRazaoSocial(), cadastroDeCliente.dsLogin(), encryptedPassword, flTipoAlteracao, flAtivo, dtAlteracao, dtCriacao));
		}	

}
