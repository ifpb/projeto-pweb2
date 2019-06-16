package br.edu.ifpb.apigateway.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                //.antMatchers("/**").hasRole("BANDA")
                .antMatchers(HttpMethod.POST, "/usuario-service/login").permitAll()
                // TODO Adicionar roles se necessário
                .antMatchers("/usuario-service/**").permitAll()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/video-service/**").hasAnyRole("ADMIN")
                .antMatchers("/rede-social-service/").hasAnyRole("ADMIN")
                .antMatchers("/rede-social-service/postagem").hasAnyAuthority("CRIAR_POSTAGEM", "EDITAR_POSTAGEM")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }
}
