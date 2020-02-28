package com.leezhuang.repository;

import com.leezhuang.entity.Demo;

import java.util.Collection;

public interface IDemoRepository {
    public Collection<Demo> findAll();
    public Demo findById(long id);
    public void saveOrUpdate(Demo demo);
    public void delete(long id);
}
