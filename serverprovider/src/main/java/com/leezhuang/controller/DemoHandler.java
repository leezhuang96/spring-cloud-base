package com.leezhuang.controller;

import com.leezhuang.entity.Demo;
import com.leezhuang.repository.IDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/demos")
public class DemoHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private IDemoRepository demoRepository;

    @GetMapping("/index")
    public String getIndex() {
        return port;
    }

    @GetMapping()
    public Collection<Demo> findAll() {
        return demoRepository.findAll();
    }

    @GetMapping("{id}")
    public Demo findById(@PathVariable("id") long id) {
        return demoRepository.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody Demo demo) {
        demoRepository.saveOrUpdate(demo);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Demo demo) {
        demoRepository.saveOrUpdate(demo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        demoRepository.delete(id);
    }
}
