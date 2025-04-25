package com.prueba.tecnicantt.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class SwaggerUrlImplement implements CommandLineRunner {

    private static final Logger logger  = Logger.getLogger(SwaggerUrlImplement.class.getName());

    @Value("${server.port}")
    private int serverPort;

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUiPath;

    @Override
    public void run(String... args) throws Exception {
        String baseUrl = "http://localhost:" + serverPort;
        String endpointsUrl = baseUrl + swaggerUiPath;
        logger.info("ACCESS_APIS_DOC: "+ endpointsUrl);
    }

}
