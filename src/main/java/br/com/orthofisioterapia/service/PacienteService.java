package br.com.orthofisioterapia.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.orthofisioterapia.dto.PacienteDTO;
import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.entities.Role;
import br.com.orthofisioterapia.mapper.PacienteMapper;
import br.com.orthofisioterapia.repository.PacienteRepository;
import br.com.orthofisioterapia.security.UserSS;
import br.com.orthofisioterapia.service.exceptions.AuthorizationException;
import br.com.orthofisioterapia.service.exceptions.DatabaseException;
import br.com.orthofisioterapia.service.exceptions.ObjectNotFoundException;
import br.com.orthofisioterapia.service.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder pe;
//	
	@Autowired
	private PacienteMapper pacienteMapper;

	//private Paciente obj;
	
	
	/* Busca todos os pacientes*/
	public List<Paciente> findAll(){
		
		//UserSS user = UserService.authenticated();
		//if(user == null || !user.hasRole(Role.ADMIN) && !id.equals(user.getId()))
		System.out.println("Listando");
		
		return pacienteRepository.findAll();
		
	}
	
	
	/* Busca os pacientes por ID*/
	@Transactional(readOnly = true)
	public Paciente findById(Integer id) {
		
		//Busca o usuario logado
		//UserSS user = UserService.authenticated();
		
		/*Verifica se o usuario for nulo ou for diferente de Role ADMIN e diferente do usuario logado*/
//		if(user == null || !user.hasRole(Role.ADMIN) && !id.equals(user.getId())) {
//			throw new AuthorizationException("Acesso negado");
//		}
	
		
			return pacienteRepository.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado! ou não existe com o Id = " + id));
	}
	

	public Paciente findByEmailPaciente(String email) {
		
		
		  
		  Paciente obj = pacienteRepository.findByEmailPaciente(email);
			 	
		  if (obj == null) {
			  	throw new ObjectNotFoundException( "Objeto não encontrado! Id " + obj.getIdPaciente() + ", Tipo: " +Paciente.class.getName());
		  }
		return obj;	
		}

	
	/*Cria um paciente*/
//	public Paciente insert(Paciente obj) {
//		Paciente paciente = new Paciente();
//		paciente.
//		paciente.setIdPaciente(null);
//		paciente.setCpfPaciente(obj.getCpfPaciente());
//		paciente.setCriadoEm(obj.getCriadoEm());
//		paciente.setDataNasc(obj.getDataNasc());
//		paciente.setEmailPaciente(obj.getEmailPaciente());
//		paciente.setNomePaciente(obj.getNomePaciente());
//		paciente.setPassword(pe.encode(obj.getPassword()));
//		paciente.setTipoPaciente(obj.getTipoPaciente());
//		
//		
//		return obj = pacienteRepository.save(paciente);
//		 
//	}
	
	public PacienteDTO insert(PacienteDTO dto) {
		
		dto.setCriadoEm(Instant.now());
		System.out.println("Chamou o insert no service");
		
		return this.pacienteMapper.toDTO(pacienteRepository.save(pacienteMapper.toEntity(dto)));
		 
	}
	
	public void delete(Integer id) {
		try {
				pacienteRepository.deleteById(id);
				
		}  catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException("Paciente não encontrado! Id = " + id);
		}
		catch (DataIntegrityViolationException e) {
			
			throw new DatabaseException("Integrity violation");
		}
	}
	
}