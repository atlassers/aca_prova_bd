/*******************************************************************************
 * Copyright (c) ArubaCC - All Rights Reserved.
 *******************************************************************************/
package it.euris.exam.teslabattery_bd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import com.google.common.collect.ImmutableList;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers("/actuator/*", "/swagger-ui.html**", "/webjars/**", "/v3/**").authenticated()

        .antMatchers("/components/**").hasRole("supervisor")
        
        .and()
        .httpBasic();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final CorsConfiguration configuration = new CorsConfiguration();

    configuration.setAllowedOrigins(ImmutableList.of("*"));
    configuration.setAllowedMethods(ImmutableList.of("GET", "POST", "PUT")); // DELETE has been disabled
    configuration.setAllowCredentials(false);
    configuration
        .setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
