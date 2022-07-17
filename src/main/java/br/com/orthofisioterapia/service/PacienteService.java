package br.com.orthofisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.repository.PacienteRepository;
import br.com.orthofisioterapia.service.exceptions.DatabaseException;
import br.com.orthofisioterapia.service.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	
	/* Busca todos os pacientes*/
	public List<Paciente> findAll(){
		
		return pacienteRepository.findAll();
		
	}
	
	/* Busca os pacientes por ID*/
	@Transactional(readOnly = true)
	public Paciente findById(Long id) {
			return pacienteRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado! Id = " + id));
	}
	
	/*Cria um paciente*/
	public Paciente insert(Paciente obj) {
		obj.setIdPaciente(null);
		return obj = pacienteRepository.save(obj);
		 
	}
	
	public void delete(Long id) {
		try {
				pacienteRepository.deleteById(id);
				
		}  catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException("Cliente não encontrado! Id = " + id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DatabaseException("Integrity violation");
		}
	}
	
}
