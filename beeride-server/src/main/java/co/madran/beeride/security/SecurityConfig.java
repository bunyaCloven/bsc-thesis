package co.madran.beeride.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService service;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(service);
	}

	/** @see WebSecurityConfigurerAdapter#configure(HttpSecurity) */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
				.loginProcessingUrl("/authentication/login/process");
		// .loginPage("/login_page.jsp");
		http.csrf().disable();
		http.sessionManagement().invalidSessionUrl("/timeout");
	}
}
