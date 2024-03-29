package br.com.orthofisioterapia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orthofisioterapia.dto.PacienteDTO;
import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.service.PacienteService;

@RequestMapping("/api/v1/pacientes")
@RestController
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	/*Busca TODOS os pacientes*/
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public List<Paciente> findAll(){
		
		System.out.println("Pacientes");
		return pacienteService.findAll();
	}
	
	/*Busca  os pacientes POR  id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findById(@PathVariable Integer id){
		
		Paciente paciente = pacienteService.findById(id);
		
		return ResponseEntity.ok().body(paciente);
	}
	
	/*Inserir um novo Paciente*/
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<PacienteDTO> insert(@RequestBody PacienteDTO dto){
		
		dto =  pacienteService.insert(dto);
		 
		 URI uri = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(dto.getIdPaciente())
				 .toUri();
		 
			return ResponseEntity.created(uri).body(dto);	
	}
	
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@ResponseStatus
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		pacienteService.delete(id);
	}
}