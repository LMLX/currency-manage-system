package com.lmlx.app.service.impl;

import com.lmlx.app.dao.base.TestAMapper;
import com.lmlx.app.dao.base.TestBMapper;
import com.lmlx.app.service.TestAService;
import com.lmlx.app.service.TestBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class TestBServiceImpl implements TestBService {

    @Resource
    private TestBMapper testBMapper;


    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void saveB() {
        testBMapper.save(1);
        System.out.println(1/0);
        testBMapper.save(2);
    }
}
