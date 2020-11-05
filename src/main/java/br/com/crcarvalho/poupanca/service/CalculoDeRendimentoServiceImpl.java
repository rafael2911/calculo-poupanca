package br.com.crcarvalho.poupanca.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.crcarvalho.poupanca.dto.InvestimentoDTO;
import br.com.crcarvalho.poupanca.dto.RendimentoDTO;
import ch.obermuhlner.math.big.BigDecimalMath;

@Service
public class CalculoDeRendimentoServiceImpl implements CalculoDeRendimentoService {

	@Override
	public RendimentoDTO calcular(InvestimentoDTO investimento) {
		
		if(investimento.getValor().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ArithmeticException("Valor de investimento deve ser maior que 0!");
		}
		
		BigDecimal percentualAnual = new BigDecimal("104.25").divide(new BigDecimal(100));
			
		Integer diasUteis = investimento.getSemanas()*5;
		
		BigDecimal periodoDoInvestimento = new BigDecimal(diasUteis).divide(new BigDecimal(252), 100, RoundingMode.UP);
		
		BigDecimal percentualDoPeriodo = BigDecimalMath.pow(percentualAnual, periodoDoInvestimento, new MathContext(100));
		
		BigDecimal saldoFinal = investimento.getValor().multiply(percentualDoPeriodo).setScale(2, RoundingMode.UP);
		
		return new RendimentoDTO(investimento.getNome(), investimento.getValor(), saldoFinal);
	}

}