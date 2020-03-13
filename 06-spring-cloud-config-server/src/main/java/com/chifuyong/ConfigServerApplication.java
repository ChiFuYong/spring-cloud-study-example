package com.chifuyong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: chify
 * @Date: 07/03/2020 10:34
 * @Description:
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient //高可用分布式配置中心
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }

}
