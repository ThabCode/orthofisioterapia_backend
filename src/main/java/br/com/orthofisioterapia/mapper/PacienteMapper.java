package br.com.orthofisioterapia.mapper;

import org.springframework.stereotype.Component;

import br.com.orthofisioterapia.dto.PacienteDTO;
import br.com.orthofisioterapia.entities.Paciente;

@Component
public class PacienteMapper {

	public Paciente toEntity(PacienteDTO dto) {
		
		
		return Paciente.builder()
				.idPaciente(dto.getIdPaciente())
				.nomePaciente(dto.getNomePaciente())
				.emailPaciente(dto.getEmailPaciente())
				.cpfPaciente(dto.getCpfPaciente())
				.dataNasc(dto.getDataNasc())
				.criadoEm(dto.getCriadoEm())
				.password(dto.getPassword())
				.tipo(dto.getTipo().getCod())
				.build();
	}
	
	
public PacienteDTO toDTO(Paciente paciente) {
		
		
		return PacienteDTO.builder()
				.idPaciente(paciente.getIdPaciente())
				.nomePaciente(paciente.getNomePaciente())
				.emailPaciente(paciente.getEmailPaciente())
				.cpfPaciente(paciente.getCpfPaciente())
				.dataNasc(paciente.getDataNasc())
				.criadoEm(paciente.getCriadoEm())
				.password(paciente.getPassword())
				.tipo(paciente.getTipo().getCod())
				.build();
	}
}
