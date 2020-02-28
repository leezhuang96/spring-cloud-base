package com.leezhuang.controller;

import com.leezhuang.entity.Demo;
import com.leezhuang.feign.IFeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/v1/demos")
public class DemoHandler {

    @Autowired
    private IFeignProviderClient feignProviderClient;

    @GetMapping()
    public Collection<Demo> findAll() {
        return feignProviderClient.findAll();
    }

    @GetMapping("index")
    public String index() {
        return feignProviderClient.index();
    }
}
