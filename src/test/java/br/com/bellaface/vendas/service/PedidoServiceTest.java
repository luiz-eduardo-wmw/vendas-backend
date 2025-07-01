package br.com.bellaface.vendas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bellaface.vendas.dto.itemPedido.CadastroDeItemPedido;
import br.com.bellaface.vendas.model.itemPedido.ItemPedido;
import br.com.bellaface.vendas.repository.itemPedido.ItemPedidoRepository;
import br.com.bellaface.vendas.repository.pedido.PedidoRepository;
import br.com.bellaface.vendas.service.pedido.PedidoService;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

	@Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ItemPedidoRepository itemPedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

 	@Test
    public void deveCalcularValorTotalPedidoAoFecharPedido() {
        int nuPedido = 1;

        CadastroDeItemPedido cadastroDeItemPedido = new CadastroDeItemPedido(1, 1, nuPedido, 10, 100.00, 1000.00);
        ItemPedido itemPedido = toEntity(cadastroDeItemPedido);

        when(itemPedidoRepository.findByNuPedido(nuPedido)).thenReturn(List.of(itemPedido));

        Double vlTotalPedido = pedidoService.validaTotalPedido(nuPedido);

        assertEquals(1000.00, vlTotalPedido);
    }
	
	@Test
    public void deveCalcularValorTotalPedidoIncorretoAoFecharPedido() {
        int nuPedido = 1;

        CadastroDeItemPedido cadastroDeItemPedido = new CadastroDeItemPedido(1, 1, nuPedido, 10, 100.00, 1000.00);
        ItemPedido itemPedido = toEntity(cadastroDeItemPedido);

        when(itemPedidoRepository.findByNuPedido(nuPedido)).thenReturn(List.of(itemPedido));

        Double vlTotalPedido = pedidoService.validaTotalPedido(nuPedido);

        assertNotEquals(1500.00, vlTotalPedido);
    }

	private ItemPedido toEntity(CadastroDeItemPedido cadastroDeItemPedido) {
	    return new ItemPedido(
			cadastroDeItemPedido.cdItemPedido(),
			cadastroDeItemPedido.cdProduto(),
			cadastroDeItemPedido.nuPedido(),
			cadastroDeItemPedido.qtdItem(),
			cadastroDeItemPedido.vlUnitario(),
			cadastroDeItemPedido.vlTotalItem()
	    );
	}
}
