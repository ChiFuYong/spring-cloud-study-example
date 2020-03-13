package com.chifuyong.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: chify
 * @Date: 06/03/2020 20:52
 * @Description:
 */
@FeignClient(value = "spring-cloud-client",fallback = FeignHystrixServiceImpl.class)
public interface FeignService {

    @RequestMapping(value = "/hello")
    public String hello();

}
