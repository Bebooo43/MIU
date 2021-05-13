package cs544.team7.project.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	private static final String USERNAME_QUERY = "SELECT p.username, p.password, 1 AS enabled"
			+ "  FROM person p WHERE p.username = ?";
	
	private static final String ROLES_BY_USERNAME_QUERY = "SELECT p.username, CONCAT('ROLE_', r.type) as role"
			+ "  FROM person p"
			+ "  INNER JOIN person_role pr ON pr.person_id = p.id"
			+ "  INNER JOIN role r ON pr.role_id = r.id"
			+ "  WHERE p.username =?";
 
    @Autowired
    private DataSource dataSource;
	
    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    	PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication()
        	.passwordEncoder(encoder)
	        .dataSource(dataSource)
	        .usersByUsernameQuery(USERNAME_QUERY)
	        .authoritiesByUsernameQuery(ROLES_BY_USERNAME_QUERY);
	        }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http		
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/admin/sessions/available").permitAll()
			.antMatchers("/client/**").hasAnyRole("CLIENT", "ADMIN")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/provider/**").hasAnyRole("PROVIDER", "ADMIN")
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
		.httpBasic();
		
	}
}