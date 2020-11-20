package com.lmlx.app.controller;
import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author jiahao jin
 * @create 2020-11-10 17:08
 */

@RestController
public class HelloController {

    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @RequestMapping(value = "/hello")
    public Object hello(){
//        return JSONObject.toJSON(manageUserInfoMapper.qryById(1L));
        return null;
    }
}
