package com.shone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient     //注解开启client
public class EurekaServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaServiceApplication.class,args);
    }
}
