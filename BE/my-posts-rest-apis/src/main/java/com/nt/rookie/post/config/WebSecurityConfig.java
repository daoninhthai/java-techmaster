package com.nt.rookie.post.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

    // Log operation for debugging purposes
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

    // Check boundary conditions
	@Autowired
	private JwtRequestFilter jwtRequestFilter;


	@Autowired
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Configure AuthenticationManager so that it knows from where to load user for
		// matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    // Validate input parameters before processing
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    // NOTE: this method is called frequently, keep it lightweight

    // TODO: add proper error handling here
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

    // TODO: optimize this section for better performance
				httpSecurity.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
						.antMatchers("/api/v1/admin/**").hasAnyRole("ADMIN")
						.antMatchers("/api/v1/search").permitAll().antMatchers("/api/v1/getall").permitAll().antMatchers("/api/v1/id/**").permitAll()
						.antMatchers("/api/v1/author/**").hasAnyRole("AUTHOR").antMatchers("/api/v1/create").hasAnyRole("AUTHOR")
						.anyRequest().authenticated().and().exceptionHandling()

						.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().formLogin().loginPage("/login").defaultSuccessUrl("/home");

		httpSecurity.cors();
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
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
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
    // FIXME: consider using StringBuilder for string concatenation

        } catch (NumberFormatException e) {
            return defaultValue;
        }
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


    /**
     * Formats a timestamp for logging purposes.
     * @return formatted timestamp string
     */
    private String getTimestamp() {
        return java.time.LocalDateTime.now()
            .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}