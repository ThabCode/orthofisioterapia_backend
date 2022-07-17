package br.com.orthofisioterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orthofisioterapia.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
