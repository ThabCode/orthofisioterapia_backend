package br.com.orthofisioterapia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.orthofisioterapia.entities.Paciente;
import br.com.orthofisioterapia.repository.PacienteRepository;
import br.com.orthofisioterapia.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private PacienteRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Paciente pac = repo.findByEmailPaciente(email);
		if(pac == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(pac.getIdPaciente(), pac.getEmailPaciente(), pac.getSenha(), pac.getRoles());
	}
}
