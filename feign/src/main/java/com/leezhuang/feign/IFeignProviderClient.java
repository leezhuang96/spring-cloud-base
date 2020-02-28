package com.leezhuang.feign;

import com.leezhuang.entity.Demo;
import com.leezhuang.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "provider", fallback = FeignError.class)
public interface IFeignProviderClient {

    @GetMapping("/v1/demos")
    public Collection<Demo> findAll();

    @GetMapping("/v1/demos/index")
    public String index();
}
