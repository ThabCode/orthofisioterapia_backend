package br.com.orthofisioterapia.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="atendimento")
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atendimento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long idAtend;
	private String descAtend;
	
	@CreatedDate
	private Instant criadoEm;
	
	private Double valorAtend;
	
	@ManyToMany 
	@JoinTable(name = "ATENDIMENTO_TIPO_ATENDIMENTO", 
	  	joinColumns = @JoinColumn(name = "id_atend"), 
	  	inverseJoinColumns = @JoinColumn(name = "id_tipo_atend") ) 
	private List<TipoAtendimento> tipoAtendimentos;
}
