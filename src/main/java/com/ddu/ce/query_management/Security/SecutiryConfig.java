package com.ddu.ce.query_management.Security;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecutiryConfig {

	public SecutiryConfig() {
		// TODO Auto-generated constructor stub
	}
	@Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/Comment").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/Comment/query/{QueryId}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/Comment").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/Comment").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/Comment/{commentId}").hasRole("ADMIN")
                        
                        
                        .requestMatchers(HttpMethod.GET, "/api/Query").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/query/{QueryId}").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/Query").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/Query").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/Query/{queryId}").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}














