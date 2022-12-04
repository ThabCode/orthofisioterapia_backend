package br.com.orthofisioterapia.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.orthofisioterapia.entities.enums.TipoPaciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="paciente")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	private String nomePaciente;
	private String emailPaciente;
	private String cpfPaciente;
	private LocalDate dataNasc;
	private Integer tipo;
	//@JsonIgnore
	private String password;
		
	
	//@Column(columnDefinition = "TIMESTAP WITHOUT TIME ZONE")
	@CreatedDate
	private Instant criadoEm;
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Role")
	private Set<Integer> roles = new HashSet<>();
	
	
	
	public Set<Role> getRoles(){
			return roles
					.stream()
					.map(x -> Role.toEnum(x))
						.collect(Collectors.toSet());
		}

	public void addRole(Role role){
		roles.add(role.getCod());
		}

		
	
	public TipoPaciente getTipo() {
		return TipoPaciente.toEnum(tipo);
	}
	
	public void setTipo(TipoPaciente tipo) {
		if(tipo != null) {
			this.tipo = tipo.getCod();
		}
		
	}
	
}