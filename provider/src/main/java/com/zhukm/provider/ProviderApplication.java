package com.zhukm.provider;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by king on 2017/3/26.
 */
@SpringBootApplication
@ImportResource("classpath:dubbo-provider.xml")
public class ProviderApplication {
    private static final Logger logger = Logger.getLogger(ProviderApplication.class);
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProviderApplication.class);
        application.setRegisterShutdownHook(false);
        application.run(args);
        logger.info("provider start up success!");
    }
}
