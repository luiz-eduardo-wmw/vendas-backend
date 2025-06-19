package br.com.bellaface.vendas.controller.pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bellaface.vendas.dto.pedido.CadastroDePedido;
import br.com.bellaface.vendas.model.pedido.Pedido;
import br.com.bellaface.vendas.repository.pedido.PedidoRepository;
import br.com.bellaface.vendas.service.pedido.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@Autowired
		private PedidoService pedidoService;
		
		@GetMapping
		public ResponseEntity<?> listaDePedidos() {
			List<Pedido> listaDePedidos = pedidoRepository.findAll();
			return ResponseEntity.ok().body(Collections.singletonMap("pedidos", listaDePedidos));
		}
		
		@GetMapping("/ativo/permitido")
		public ResponseEntity<?> verificarSePedidoPermitido() {
		    if (pedidoService.isFinalDeSemana()) {
		        return ResponseEntity.status(403).body(Map.of("erro", "O sistema não funciona nos finais de semana."));
		    }
		    return ResponseEntity.ok().build();
		}
		
		@PostMapping("/criarOuRecuperar")
		public ResponseEntity<?> criarOuRecuperarPedidoAberto(@RequestBody CadastroDePedido cadastroDePedido) {
		    Pedido pedidoAberto = pedidoRepository.findFirstByCdClienteAndFlStatusPedido(cadastroDePedido.cdCliente(), "A");
		    
		    if (pedidoAberto != null) {
		        return ResponseEntity.ok(pedidoAberto);
		    } else {
		        Pedido novoPedido = new Pedido(
		            null,
		            cadastroDePedido.cdCliente(),
		            0.0,
		            "",
		            "A",
		            LocalDateTime.now()
		        );
		        Pedido salvo = pedidoRepository.save(novoPedido);
		        return ResponseEntity.ok(salvo);
		    }
		}
		
		@PutMapping("/{nuPedido}")
		public ResponseEntity<?> atualizarPedido(@PathVariable Integer nuPedido, @RequestBody AtualizaPedido atualizaPedido) {
			Optional<Pedido> pedidoOpt = pedidoRepository.findById(nuPedido);
		    if (pedidoOpt.isEmpty()) {
		        return ResponseEntity.notFound().build();
		    }

		    Pedido pedido = pedidoOpt.get();
		    pedido.setFlStatusPedido(atualizaPedido.flStatusPedido());
		    if (atualizaPedido.vlTotalPedido() != null) {
		        pedido.setVlTotalPedido(atualizaPedido.vlTotalPedido());
		    }
		    pedidoRepository.save(pedido);
		    return ResponseEntity.ok(pedido);
		}
		
		
	    @PutMapping("/fechar/{nuPedido}")
	    public ResponseEntity<?> fecharPedido(@PathVariable Integer nuPedido, @RequestBody AtualizaPedido atualizaPedido) {
	    	
	        Optional<Pedido> pedidoOpt = pedidoRepository.findById(nuPedido);
	        if (pedidoOpt.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        Pedido pedido = pedidoOpt.get();
	        pedido.setFlStatusPedido(atualizaPedido.flStatusPedido());
	        pedido.setDsObsPedido(atualizaPedido.dsObsPedido());
	        pedido.setVlTotalPedido(atualizaPedido.vlTotalPedido());
	        pedidoRepository.save(pedido);
	        return ResponseEntity.ok().build();
	    }
	    
	    @PutMapping("/cancelar/{nuPedido}")
	    public ResponseEntity<?> cancelarPedido(@PathVariable Integer nuPedido) {
	        Optional<Pedido> pedidoOpt = pedidoRepository.findById(nuPedido);
	        if (pedidoOpt.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        Pedido pedido = pedidoOpt.get();
	        pedido.setFlStatusPedido("C");
	        pedidoRepository.save(pedido);
	        return ResponseEntity.ok().build();
	    }
}
