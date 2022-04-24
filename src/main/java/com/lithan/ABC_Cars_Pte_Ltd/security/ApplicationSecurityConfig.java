package com.lithan.ABC_Cars_Pte_Ltd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordencoder;
    @Autowired
    UserDetailsService userservice;
	@Autowired
	UserDetailsService userdetail;
    @Autowired
    ApplicationSecurityConfig (PasswordEncoder encoder){
    	this.passwordencoder=encoder;
    }
    @Autowired
    RolesHandler roles;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.authorizeRequests()
		.antMatchers("/","home","/register","registration","/myreg","/admin/update/{id}","UpdateStore","/admin/update/StoreUpdate","/admin/listUser/update/{id}","UpdatelistUser","/admin/listUser/update/listUserUpdate","About","/about","Contact","/contact").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		.permitAll()
		.successHandler(roles)
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.clearAuthentication(true)
		.invalidateHttpSession(true);
	}
	@Autowired
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider  dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordencoder);
		dao.setUserDetailsService(userservice);
		
		return dao;
	}

}
