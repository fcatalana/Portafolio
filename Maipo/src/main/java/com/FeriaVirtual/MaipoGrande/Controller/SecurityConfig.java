package com.FeriaVirtual.MaipoGrande.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder encriptarClave() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).
		passwordEncoder(encriptarClave());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/")   se quito esto
			//todos los usuarios pueden ver el index
			//.hasAnyRole("PRODUCTOR","ADMIN","CLIENTE_INTERNO","CLIENTE_EXTERNO","TRANSPORTISTA","CONSULTOR")
			.antMatchers("/main-menu/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/main-menuProductor/**").hasAnyRole("PRODUCTOR")
			.antMatchers("/main-menuProveedor/**").hasAnyRole("COMERCIANTE")
			.antMatchers("/listaCliente/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/listaContrato/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/listaProducto/**").hasAnyRole("PRODUCTOR")
			.antMatchers("/listaProductor/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/listaSubasta/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/listaVenta/**").hasAnyRole("ADMINISTRADOR","COMERCIANTE")
			.antMatchers("/agregarProducto/**").hasAnyRole("PRODUCTOR")
			.antMatchers("/agregarProductor/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/agregarCliente/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/agregarVenta/**").hasAnyRole("ADMINISTRADOR","COMERCIANTE")
			.antMatchers("/agregarSubasta/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/agregarContrato/**").hasAnyRole("ADMINISTRADOR")
			.antMatchers("/solicitud/**").hasAnyRole("CLIENTE_EXTERNO")	
			.and()
				.formLogin()
					.loginPage("/inicio")
			.and()  //se agrega para el cierre de sesion
				.logout()
					.logoutSuccessUrl("/login")
			.and()
				.exceptionHandling().accessDeniedPage("/errores/403")
			;
	}

}
