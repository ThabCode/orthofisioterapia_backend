package br.com.orthofisioterapia.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter  {//extends BasicAuthenticationFilter {
//
//	private JWTUtil jwtUtil;
//	UserDetailsService userDetailsService;
//
//	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtutil,
//			UserDetailsService userDetailservice) {
//		super(authenticationManager);
//		this.jwtUtil = jwtutil;
//		this.userDetailsService = userDetailservice;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		String header = request.getHeader("Authorization");
//		if (header != null && header.startsWith("Bearer ")) {
//			UsernamePasswordAuthenticationToken auth = getAuthenticantion(header.substring(7));
//			if (auth != null) {
//
//				SecurityContextHolder.getContext().setAuthentication(auth);
//			}
//			chain.doFilter(request, response);
//		}
//	}
//	
//	private UsernamePasswordAuthenticationToken getAuthenticantion(String token) {
//		if(jwtUtil.tokenValido(token)) {
//			String username = jwtUtil.getUsername(token);
//			 UserDetails user = userDetailsService.loadUserByUsername(username);
//			 return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		}
//		return null;
//	}

}
