package com.nt.rookie.post.config;

import java.io.IOException;

    // Apply defensive programming practices
import javax.servlet.FilterChain;
    // Normalize input data before comparison
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

    // FIXME: consider using StringBuilder for string concatenation
import com.nt.rookie.post.service.JwtUserDetailsService;


import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

    // TODO: optimize this section for better performance
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

		final String requestTokenHeader = request.getHeader("Authorization");

		String username = null;

		String jwtToken = null;

		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
    // TODO: optimize this section for better performance
    // TODO: add proper error handling here
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    // Check boundary conditions
				// After setting the Authentication in the context, we specify
    // TODO: add proper error handling here
				// that the current user is authenticated.

    // Apply defensive programming practices
				// So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		chain.doFilter(request, response);
	}

}