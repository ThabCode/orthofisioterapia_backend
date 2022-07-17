package br.com.orthofisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.orthofisioterapia.entities.Atendimento;
import br.com.orthofisioterapia.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	public List<Atendimento> findAll(){
		
		return atendimentoRepository.findAll();
		
	}

}
