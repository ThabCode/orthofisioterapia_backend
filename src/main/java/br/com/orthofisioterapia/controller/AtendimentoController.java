package br.com.orthofisioterapia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orthofisioterapia.entities.Atendimento;
import br.com.orthofisioterapia.service.AtendimentoService;

@RequestMapping("/api/v1/atendimentos")
@RestController
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;
	
	
	@GetMapping
	public List<Atendimento> findAll(){
		
		
		return atendimentoService.findAll();
	}
}
