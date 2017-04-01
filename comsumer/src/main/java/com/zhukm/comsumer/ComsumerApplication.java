package com.zhukm.comsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by king on 2017/3/26.
 */
@SpringBootApplication
@ImportResource("classpath:dubbo-comsumer.xml")
public class ComsumerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ComsumerApplication.class);
        application.run(args);
        System.out.println("comsumer started");
    }
}
