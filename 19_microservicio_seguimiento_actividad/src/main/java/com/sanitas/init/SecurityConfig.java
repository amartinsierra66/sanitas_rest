package com.sanitas.init;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sanitas.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${clave}")
	private String clave;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USER")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("USER", "ADMIN")
          .and()
        .withUser("user2")
          .password("{noop}user2")
          .roles("OPERATOR");*/
		
		/*lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		String pw1=new BCryptPasswordEncoder().encode("user1");
		System.out.println(pw1);
		  auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password("{bcrypt}"+pw1)
	          //.password(pw1)
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password("{bcrypt}"+new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		/*la siguiente configuración será para el caso de 
		 * usuarios en una base de datos*/
		   
		   auth.jdbcAuthentication().passwordEncoder(pwdEncoder()).dataSource(dataSource())
        	.usersByUsernameQuery("select user, pwd, enabled"
            	+ " from users where user=?")
        	.authoritiesByUsernameQuery("select user, rol "
            	+ "from roles where user=?");
		 
	}
	private PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	public DataSource dataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.cj.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3307/springsecurity?serverTimezone=UTC");
		data.setUsername("root");
		data.setPassword("root");
		return data;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()		
		.antMatchers("actividad/**","actividades/**").authenticated()
		.and()
		.addFilter(new JwtFilter(authenticationManagerBean(),clave));
	}

}

