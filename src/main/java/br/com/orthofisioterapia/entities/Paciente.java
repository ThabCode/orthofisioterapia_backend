package br.com.orthofisioterapia.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


//@Builder
@Table(name="paciente")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long idPaciente;
	private String nomePaciente;
	private String emailPaciente;
	private String cpfPaciente;
	private LocalDate dataNasc;
		
	@CreatedDate
	private Instant criadoEm;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_paciente")
    private TipoPaciente tipoPaciente;
	
	//@JsonIgnore
	private String senha;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Role")
	private Set<Integer> roles = new HashSet<>();
	
	
	public Paciente() {
		addRole(Role.PACIENTE);
}

	
	
	public Set<Role> getRoles(){
			return roles
					.stream()
					.map(x -> Role.toEnum(x))
						.collect(Collectors.toSet());
		}

	public void addRole(Role role){
		roles.add(role.getCod());
}

    /*
	public  Paciente() {}

	public Paciente(Long idPaciente, String nomePaciente, String emailPaciente, String cpfPaciente, LocalDate dataNasc,
			Instant criadoEm, TipoPaciente tipoPaciente) {
		super();
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.emailPaciente = emailPaciente;
		this.cpfPaciente = cpfPaciente;
		this.dataNasc = dataNasc;
		this.criadoEm = criadoEm;
		this.tipoPaciente = tipoPaciente;
	}
	*/
}
