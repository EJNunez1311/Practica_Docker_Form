package com.example.practicadocker.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by vacax on 27/09/16.
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {


    //Opción JPA
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * La autentificación de los usuarios.
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Clase para encriptar contraseña
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        //Configuración JPA.
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios
        http
                .authorizeRequests()
                .antMatchers("/","/css/**", "/js/**", "/actuator/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll()
               // .antMatchers("/admin/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/barcamp/**").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/barcamp/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/barcamp/**").permitAll()
                .anyRequest().permitAll() //cualquier llamada debe ser validada
                .and()
                .formLogin()
                .loginPage("/login") //indicando que usario mi propio login no el que viene por defecto.
                //.failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina, esta url la utilizare para
                // indicar cuando hay algun error en la aplicacion y mandare la pagina que aqui designe
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }
}
