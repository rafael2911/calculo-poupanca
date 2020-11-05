package br.com.crcarvalho.poupanca.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.crcarvalho.poupanca.dto.InvestimentoDTO;
import br.com.crcarvalho.poupanca.dto.RendimentoDTO;

public class CalculoDeRendimentoServiceImplTest {
	
	private CalculoDeRendimentoService service;
	
	@BeforeEach
	public void setUp() {
		service = new CalculoDeRendimentoServiceImpl();
	}
	
	@Test
	@DisplayName("realiza o calculo do investimento de 100 reais para 36 semanas")
	public void deveCalcularInvestimentoDeCemReais() {
		
		InvestimentoDTO investimento = new InvestimentoDTO("Rafael Carvalho", new BigDecimal("100.00"), 36);
		RendimentoDTO rendimentos = service.calcular(investimento);
		
		assertThat(rendimentos.getNome(), equalTo(investimento.getNome()));
		assertThat(rendimentos.getInvestimento(), equalTo(investimento.getValor()));
		assertThat(rendimentos.getSaldoFinal(), equalTo(new BigDecimal("103.02")));
	}
	
	@Test
	@DisplayName("Deve lancar exception para investimentos com valor igual a 0")
	public void naoDeveRealizarCalculoParaInvestimentoIgualAZero() {
		
		InvestimentoDTO investimento = new InvestimentoDTO("Rafael Carvalho", new BigDecimal("0.00"), 36);
		
		RuntimeException exception = assertThrows(ArithmeticException.class,
				() -> service.calcular(investimento));

		assertThat(exception.getMessage(), equalTo("Valor de investimento deve ser maior que 0!"));
	}
	
	@Test
	@DisplayName("Deve lancar exception para investimentos com valor menor que 0")
	public void naoDeveRealizarCalculoParaInvestimentoMenorQueZero() {
		
		InvestimentoDTO investimento = new InvestimentoDTO("Rafael Carvalho", new BigDecimal("-1.00"), 36);
		
		RuntimeException exception = assertThrows(ArithmeticException.class,
				() -> service.calcular(investimento));

		assertThat(exception.getMessage(), equalTo("Valor de investimento deve ser maior que 0!"));
	}
	
}
