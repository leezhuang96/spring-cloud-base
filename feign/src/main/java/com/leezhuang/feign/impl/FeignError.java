package com.leezhuang.feign.impl;

import com.leezhuang.entity.Demo;
import com.leezhuang.feign.IFeignProviderClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component //注入 IoC 容器中
public class FeignError implements IFeignProviderClient {
    @Override
    public Collection<Demo> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中...";
    }
}
