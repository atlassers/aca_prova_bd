package it.euris.exam.teslabattery_bd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Busterna Davide
 * @since 2021-09-29
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("*")
        .allowedMethods("OPTIONS", "GET", "PUT", "POST", "PATCH")
        .allowedOrigins("*")
        .allowedHeaders("*");
  }
}


