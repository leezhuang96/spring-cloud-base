package com.leezhuang.controller;

import com.leezhuang.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/v1/rest/demos")
public class DemoHandler {

    private String url1 = "http://localhost:8010/";
    private String url = "http://provider/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String index() {
        return restTemplate.getForEntity(url+"v1/demos/index", String.class).getBody();
    }

    @GetMapping()
    public Collection<Demo> findAll() {
        return restTemplate.getForEntity(url+"v1/demos", Collection.class).getBody();
    }

    @GetMapping("/backup")
    public Collection<Demo> findAllForObject() {
        return restTemplate.getForObject(url+"v1/demos", Collection.class);
    }

    @GetMapping("/{id}")
    public Demo findById(@PathVariable("id") long id) {
        return restTemplate.getForEntity(url+"v1/demos/{id}", Demo.class).getBody();
    }

    @GetMapping("/{id}/backup")
    public Demo findByIdForObject(@PathVariable("id") long id) {
        return restTemplate.getForObject(url+"v1/demos/{id}", Demo.class);
    }

    @PostMapping()
    public void save(Demo demo) {
        restTemplate.postForEntity(url+"v1/demos", demo,null);
    }

    @PostMapping("/backup")
    public void saveForObject(@RequestBody Demo demo) {
        restTemplate.postForObject(url+"v1/demos", demo,null);
    }

    @PutMapping("/{id}/backup")
    public void update(@RequestBody Demo demo) {
        restTemplate.put(url+"v1/demos", demo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        restTemplate.delete(url+"v1/demos/{id}", id);
    }
}
