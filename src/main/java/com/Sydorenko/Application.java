package com.Sydorenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
/** This class is the entry point of the application.
 * Aside from it defines the application run method
 * it also provides means for additional application
 * configuration. The annotation describes the class
 * as the one can be automatically configured by
 * Spring Boot and enables automatic components
 * scanning for registering them in the Spring
 * application context. The components should be marked
 * with the appropriate annotations.
 * @author Oleksandr Sydorenko
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setCacheSeconds(3600); // Refresh cache once per hour.
        return source;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

