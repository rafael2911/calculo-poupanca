package br.com.crcarvalho.poupanca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crcarvalho.poupanca.dto.InvestimentoDTO;
import br.com.crcarvalho.poupanca.dto.RendimentoDTO;
import br.com.crcarvalho.poupanca.service.CalculoDeRendimentoService;

@RestController
@RequestMapping("/")
public class CalculoDeRendimentoController {
	
	@Autowired
	private CalculoDeRendimentoService calculoDeRendimentosService;
	
	@PostMapping
	public RendimentoDTO calculoDeRendimentos(@RequestBody InvestimentoDTO investimento) {
		return calculoDeRendimentosService.calcular(investimento);
	}
	
}
