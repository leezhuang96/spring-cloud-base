package com.leezhuang.repository.impl;

import com.leezhuang.entity.Demo;
import com.leezhuang.repository.IDemoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DemoRepositoryImpl implements IDemoRepository {

    private static Map<Long, Demo> demoMap;

    static {
        demoMap = new HashMap<Long, Demo>();
        demoMap.put(1L, new Demo(1L, "Jordon"));
        demoMap.put(2L, new Demo(2L, "Vicky"));
    }

    @Override
    public Collection<Demo> findAll() {
        return demoMap.values();
    }

    @Override
    public Demo findById(long id) {
        return demoMap.get(id);
    }

    @Override
    public void saveOrUpdate(Demo demo) {
        demoMap.put(demo.getId(), demo);
    }

    @Override
    public void delete(long id) {
        demoMap.remove(id);
    }
}
