package br.com.crcarvalho.poupanca.service;

import br.com.crcarvalho.poupanca.dto.InvestimentoDTO;
import br.com.crcarvalho.poupanca.dto.RendimentoDTO;

public interface CalculoDeRendimentoService {
	
	RendimentoDTO calcular(InvestimentoDTO investimento);

}
