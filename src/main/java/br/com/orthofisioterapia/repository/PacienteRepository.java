package br.com.orthofisioterapia.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.orthofisioterapia.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	@Transactional(readOnly=true)
	Paciente findByEmailPaciente(String email);

}
