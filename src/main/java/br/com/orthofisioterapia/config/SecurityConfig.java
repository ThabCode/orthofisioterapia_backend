package br.com.orthofisioterapia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.orthofisioterapia.security.JWTAuthenticationFilter;
import br.com.orthofisioterapia.security.JWTAuthorizationFilter;
import br.com.orthofisioterapia.security.JWTUtil;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired 
	private JWTUtil jwtUtil;

	
	private static final String[] PUBLIC_MATCHERS = {
			
			"/h2/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_LIST = {
			
			"/api/v1/pacientes/list"
	};
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and().csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS).permitAll()
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_LIST).permitAll()
				.anyRequest().authenticated();
		
		 http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		 http.addFilter(new JWTAuthorizationFilter( authenticationManager(), jwtUtil,userDetailsService));
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	public void configure (AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {

	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	} 
}

