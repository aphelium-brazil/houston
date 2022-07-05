package io.github.aphelium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean(name = "applicationName")
    public String APPLICATION_NAME(){ return "Houston"; };

    @Bean
    public String APPLICATION_VERSION(){ return "0.0.1"; };

    @Bean
    public String APPLICATION_DESCRIPTION(){ return "Houston is a simple, yet powerful, RESTful API framework for Java."; };

    @Bean
    public String APPLICATION_AUTHOR(){ return "Felipe Duque"; };

    @Bean
    public String APPLICATION_AUTHOR_EMAIL(){ return "felipe@duque.dev"; };
}
