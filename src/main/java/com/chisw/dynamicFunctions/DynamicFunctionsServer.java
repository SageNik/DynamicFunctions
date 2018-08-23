package com.chisw.dynamicFunctions;

import com.chisw.dynamicFunctions.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka)
 * if needed
 */
@SpringBootApplication
@EnableDiscoveryClient
@Import(AppConfiguration.class)
public class DynamicFunctionsServer {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "dynamic_functions-server");
        SpringApplication application = new SpringApplication(DynamicFunctionsServer.class);
        application.setAdditionalProfiles("dev");
        application.run();
    }
}
