package br.com.bellaface.vendas.service.pedido;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	public boolean isFinalDeSemana() {
		LocalDate diaAtual = LocalDate.now();
        DayOfWeek diaDaSemana = diaAtual.getDayOfWeek();

        if (diaDaSemana == DayOfWeek.SATURDAY || diaDaSemana == DayOfWeek.SUNDAY) {
            return true;
        } 
        
        return false;
        
    }
}
