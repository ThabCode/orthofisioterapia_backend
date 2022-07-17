package br.com.orthofisioterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.orthofisioterapia.entities.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{

}
