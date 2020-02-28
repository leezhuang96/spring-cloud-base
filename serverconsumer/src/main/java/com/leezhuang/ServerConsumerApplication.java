package com.leezhuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServerConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced //声明一个基于 Ribbon 的负载均衡。
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
