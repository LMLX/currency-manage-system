package com.lmlx.app.service.impl;

import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.dao.base.TestAMapper;
import com.lmlx.app.service.TestAService;
import com.lmlx.app.service.TestBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.TreeMap;

@Slf4j
@Service
public class TestAServiceImpl implements TestAService {

    @Resource
    private TestBService testBService;


    @Resource
    private TestAMapper testAMapper;

//    TransactionInterceptor
    @Override
//    TreeMap
//    @Transactional(propagation= Propagation.REQUIRED)
    public void saveA() {

        testAMapper.save(1);
        testAMapper.save(2);
                    testBService.saveB();
//        System.out.println(1/0);
        testAMapper.save(3);
        testAMapper.save(4);
    }
}
