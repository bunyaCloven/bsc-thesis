package co.madran.beeride.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService service;

  /**
   * @see WebSecurityConfigurerAdapter#configure(HttpSecurity).
   */
  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("login", "signup").permitAll();
    http.authorizeRequests().anyRequest().authenticated();
    http.formLogin().defaultSuccessUrl("/cologin");// .realmName("Beeride");
    http.csrf().disable();
    // http.sessionManagement().invalidSessionUrl("/timeout");
    http.logout().logoutUrl("/logout").invalidateHttpSession(true);
    http.userDetailsService(service);
  }

  @Override
  public void configure(final WebSecurity web) throws Exception {
    final String[] ignoredPatterns = { "/signup", "/cologin" };
    web.ignoring().antMatchers(ignoredPatterns);
  }
}
