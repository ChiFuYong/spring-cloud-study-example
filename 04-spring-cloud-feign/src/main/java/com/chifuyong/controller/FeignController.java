package com.chifuyong.controller;

import com.chifuyong.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chify
 * @Date: 06/03/2020 20:52
 * @Description:
 */
@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/hello")
    public String hello(){
        String str = feignService.hello();
        System.out.println(str);
        return feignService.hello();
    }

}
