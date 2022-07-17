package br.com.orthofisioterapia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name="tipo_paciente")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class TipoPaciente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoPaciente;
	private String nomeTipoPaciente;
	
	public TipoPaciente() {}

	public TipoPaciente(Long idTipoPaciente, String nomeTipoPaciente) {
		super();
		this.idTipoPaciente = idTipoPaciente;
		this.nomeTipoPaciente = nomeTipoPaciente;
	}
	
	
	

}
