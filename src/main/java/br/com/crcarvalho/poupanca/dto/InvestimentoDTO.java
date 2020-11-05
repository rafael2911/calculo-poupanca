package br.com.crcarvalho.poupanca.dto;

import java.math.BigDecimal;

public class InvestimentoDTO {
	
	private String nome;
	
	private BigDecimal valor;
	
	private Integer semanas;

	public InvestimentoDTO(String nome, BigDecimal valor, Integer semanas) {
		this.nome = nome;
		this.valor = valor;
		this.semanas = semanas;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getSemanas() {
		return semanas;
	}
	
}
