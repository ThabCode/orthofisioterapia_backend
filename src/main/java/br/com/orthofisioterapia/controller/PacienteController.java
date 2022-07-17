package br.com.orthofisioterapia.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.service.PacienteService;

@RequestMapping("/api/v1/pacientes")
@RestController
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	
	
	/*Busca TODOS os pacientes*/
	@GetMapping
	public List<Paciente> findAll(){
		
		System.out.println("Pacientes");
		return pacienteService.findAll();
	}

	
	/*Busca  os pacientes POR  id*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findById(@PathVariable Long id){
		
		Paciente paciente = pacienteService.findById(id);
		
		return ResponseEntity.ok().body(paciente);
		
	}
	
	/*Inserir um novo Paciente*/
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Paciente paciente){
		 pacienteService.insert(paciente);
		 
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
			return ResponseEntity.created(uri).build();	
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		pacienteService.delete(id);
	}

	
}
