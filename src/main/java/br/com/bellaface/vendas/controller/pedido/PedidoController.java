package br.com.bellaface.vendas.controller.pedido;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.pedido.CadastroDePedido;
import br.com.bellaface.vendas.model.pedido.Pedido;
import br.com.bellaface.vendas.repository.pedido.PedidoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
			@Autowired
			private PedidoRepository pedidoRepository;
			
			@GetMapping
			public ResponseEntity<?> listaDePedidos() {
				List<Pedido> listaDePedidos = pedidoRepository.findAll();
				return ResponseEntity.ok().body(Collections.singletonMap("pedidos", listaDePedidos));
			}
			
			@PostMapping
			public Pedido cadastrar(@RequestBody CadastroDePedido cadastroDePedido) {
				// VALIDAÇÃO SERÁ NO FRONT
				// Alterar tudo para messages
				String flTipoAlteracao = "I"; 
				LocalDate dtAlteracao = LocalDate.now();
				LocalDate dtCriacao = LocalDate.now();
				
				return pedidoRepository.save(new Pedido(cadastroDePedido.nuPedido(), cadastroDePedido.cdCliente(), cadastroDePedido.vlTotalPedido(), cadastroDePedido.dsObsPedido(), flTipoAlteracao, dtAlteracao, dtCriacao));
			}
}
