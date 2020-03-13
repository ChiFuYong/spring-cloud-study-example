package com.chifuyong.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: chify
 * @Date: 06/03/2020 22:35
 * @Description:
 */
@Service
public class FeignHystrixServiceImpl implements FeignService{

    @Override
    public String hello() {
        return "Sorry , Server Error !";
    }
}
