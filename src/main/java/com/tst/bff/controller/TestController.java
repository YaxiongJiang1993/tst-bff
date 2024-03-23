package com.tst.bff.controller;


import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yaxio
 */
@Slf4j
@RestController
@RequestMapping("/bff/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        log.info("hello name: {}", name);
        String res=restTemplate.getForObject("http://tst-user/user/test/hello?name={name}", String.class,
                ImmutableMap.of("name", name));
        return res;
    }

    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        log.info("hello name: {}", name);
        return name;
    }
}
