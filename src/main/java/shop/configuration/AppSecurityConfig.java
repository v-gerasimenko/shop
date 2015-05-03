package shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("tom").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
	  http.authorizeRequests()
		.antMatchers("/menu-admin**").access("hasRole('ROLE_ADMIN')")
              .antMatchers("/product/add**").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().defaultSuccessUrl("/menu")
              .and().csrf().disable();
	}

}
