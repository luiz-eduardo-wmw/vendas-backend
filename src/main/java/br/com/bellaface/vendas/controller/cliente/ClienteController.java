package br.com.bellaface.vendas.controller.cliente;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	    public ResponseEntity<Cliente> getClienteByDsLogin(@RequestParam String dsLogin) {
	        Cliente cliente = (Cliente) clienteRepository.findByDsLogin(dsLogin);

	        if (cliente == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(cliente);
	    }
		
		@GetMapping("listaDeClientes")
		public ResponseEntity<?> listaDeClientes() {
			List<Cliente> listaDeClientes = clienteRepository.findAll();
			return ResponseEntity.ok().body(Collections.singletonMap("clientes", listaDeClientes));
		}
		
		@PostMapping
		public Cliente cadastrar(@RequestBody CadastroDeCliente cadastroDeCliente) {
			String encryptedPassword = new BCryptPasswordEncoder().encode(cadastroDeCliente.dsSenha());
			
			return clienteRepository.save(new Cliente(cadastroDeCliente.cdCliente(), cadastroDeCliente.nmRazaoSocial(), cadastroDeCliente.dsLogin(), encryptedPassword));
		}	

}
