package br.com.orthofisioterapia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.repository.PacienteRepository;
import br.com.orthofisioterapia.security.UserSS;
import br.com.orthofisioterapia.service.exceptions.DatabaseException;
import br.com.orthofisioterapia.service.exceptions.ObjectNotFoundException;
import br.com.orthofisioterapia.service.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
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
	

	public Paciente findByEmailPaciente(String email) {
		
		
		  
		  Paciente obj = pacienteRepository.findByEmailPaciente(email);
			 	
		  if (obj == null) {
			  	throw new ObjectNotFoundException( "Objeto não encontrado! Id " + obj.getIdPaciente() + ", Tipo: " +Paciente.class.getName());
		  }	
		    return obj;
		}

	
	/*Cria um paciente*/
	public Paciente insert(Paciente obj) {
		Paciente paciente = new Paciente();
		paciente.setIdPaciente(null);
		paciente.setCpfPaciente(obj.getCpfPaciente());
		paciente.setCriadoEm(obj.getCriadoEm());
		paciente.setDataNasc(obj.getDataNasc());
		paciente.setEmailPaciente(obj.getEmailPaciente());
		paciente.setNomePaciente(obj.getNomePaciente());
		paciente.setSenha(pe.encode(obj.getSenha()));
		paciente.setTipoPaciente(obj.getTipoPaciente());
		
		
		return obj = pacienteRepository.save(paciente);
		 
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
