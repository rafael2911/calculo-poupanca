package br.com.crcarvalho.poupanca.dto;

import java.math.BigDecimal;

public class RendimentoDTO {
	
	private String nome;
	
	private BigDecimal investimento;
	
	private BigDecimal saldoFinal;

	public RendimentoDTO(String nome, BigDecimal investimento, BigDecimal saldoFinal) {
		this.nome = nome;
		this.investimento = investimento;
		this.saldoFinal = saldoFinal;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getInvestimento() {
		return investimento;
	}

	public BigDecimal getSaldoFinal() {
		return saldoFinal;
	}
	
}
