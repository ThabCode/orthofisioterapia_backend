package br.com.orthofisioterapia.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.orthofisioterapia.security.JWTAuthenticationFilter;
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
	
	private static final String[] PUBLIC_MATCHERS_POST = {
			
			"/api/v1/pacientes/create"
			
	};
	
	private static final String[] PUBLIC_MATCHERS_LIST = {
			
			"/api/v1/pacientes/list"
			
	};
	
	private static final String[] PUBLIC_MATCHERS_DELETE = {
			
			"/api/v1/pacientes/delete/**"
			
	};
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS)
				.permitAll()
		.antMatchers(HttpMethod.DELETE,PUBLIC_MATCHERS_DELETE)
				.permitAll()
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_LIST)
				.permitAll()
		.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST)
				.permitAll().anyRequest().authenticated();
		
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 http.addFilter(new  JWTAuthenticationFilter(authenticationManager(), jwtUtil));
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

