package br.com.orthofisioterapia.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="tipo_atendimento")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoAtendimento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long idTipoAten;
	private String nomeTipoAtend;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "tipoAtendimentos")
	private List<Atendimento> atendimentos = new ArrayList<>();
	
	/*
	public TipoAtendimento() {
		
	}

	public TipoAtendimento(Long idTipoAten, String nomeTipoAtend) {
		super();
		this.idTipoAten = idTipoAten;
		this.nomeTipoAtend = nomeTipoAtend;
	}
	*/
}
