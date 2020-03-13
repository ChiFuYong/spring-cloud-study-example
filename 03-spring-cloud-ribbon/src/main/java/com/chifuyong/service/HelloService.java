package com.chifuyong.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: chify
 * @Date: 06/03/2020 19:43
 * @Description:
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(){
        //调用服务
        String str = restTemplate.getForObject("http://spring-cloud-client/hello",String.class);
        System.out.println(str);
        return str;
    }

    public String helloError(){
        return "Sorry , Server Error !";
    }

}
