package br.com.orthofisioterapia.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}") 
	private Long expiration;
	
	
		
	public String generateToken( String username, String roles) {
		return Jwts.builder()
			.setSubject(username)
			.claim("roles", roles) //informação extra ("chave", valor)
			.setExpiration(new Date(System.currentTimeMillis() + expiration))
			.signWith(SignatureAlgorithm.HS512, secret.getBytes() )
			.compact();
		}
	
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);
		if(claims != null ) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now =  new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate));{
				return true;
			}
			
		}
			return false;
	}
	
	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if(claims != null ) {
			return claims.getSubject();
		}
		return null;
		
	}

	private Claims getClaims(String token) {
		try {
			
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}catch(Exception e ){
			return null;
		}
	}
}
