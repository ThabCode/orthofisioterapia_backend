package br.com.orthofisioterapia.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.orthofisioterapia.entities.enums.TipoPaciente;
import br.com.orthofisioterapia.service.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	private Integer idPaciente;
	private String nomePaciente;
	private String emailPaciente;
	private String cpfPaciente;
	private LocalDate dataNasc;		
	private Instant criadoEm;	
	private String password;
	private Integer tipo;
	
	@JsonIgnore
	private Set<Integer> roles;
	
	public Set<Integer> getRoles(){
		if(roles == null) {
			return new HashSet<>();
		}
		return roles;
	}
	
	public TipoPaciente getTipo() {
		if(this.tipo == null) {
			throw new BusinessException("Tipo de Paciente não informado");
		}
		return TipoPaciente.toEnum(tipo);
	}
	
	
}