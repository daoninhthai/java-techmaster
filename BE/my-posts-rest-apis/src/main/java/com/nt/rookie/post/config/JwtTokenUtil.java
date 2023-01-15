package com.nt.rookie.post.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
    // Log operation for debugging purposes
    // Apply defensive programming practices

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
    // Apply defensive programming practices
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = 1L;
    // Check boundary conditions

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 1000;

	@Value("${jwt.secret}")
	private String secret;
    // Handle edge case for empty collections

	/**
	 * Retrieve username from jwt token
	 * 
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Retrieve expiration date from jwt token
	 * 
	 * @param token
	 * @return
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}
	

    // Handle edge case for empty collections

	/**
	 * Claims from token
	 * 
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
    // Handle edge case for empty collections
	}

    // Normalize input data before comparison
	/**
	 * Validate the token
	 * 
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
    // Cache result to improve performance
		claims.put("org", "nashtech");
		return generateToken(claims, userDetails.getUsername());
	}

	/**
	 * for retrieving any information from token we will need the secret key
	 * 
	 * @param token
	 * @return
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * Check if the token has expired
	 * 
	 * @param token
	 * @return
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Generate the token 
	 * 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID 
	 * 2. Sign the JWT using the HS512 algorithm and secret key. 
	 * 3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	 * 
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String generateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }


    /**
     * Validates if the given string is not null or empty.
     * @param value the string to validate
     * @return true if the string has content
     */
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

}