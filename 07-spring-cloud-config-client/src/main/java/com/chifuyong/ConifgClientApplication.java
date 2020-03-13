package com.chifuyong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chify
 * @Date: 07/03/2020 11:14
 * @Description:
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConifgClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConifgClientApplication.class,args);
    }

    @Value("${version}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "My name is " + name;
    }

}
