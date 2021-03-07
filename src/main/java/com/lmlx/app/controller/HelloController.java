package com.lmlx.app.controller;
import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.webSocket.OneWebSocket;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OneWebSocket socket;
    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @RequestMapping(value = "/hello")
    public Object hello(){
//        return JSONObject.toJSON(manageUserInfoMapper.qryById(1L));
//        System.out.println(1/0);
        String[] index = new String[]{"aaa", "bbb", "ccc"};
        new Thread(new Runnable() {
            @SneakyThrows
            public void run() {
                while (true) {
                    String userName = index[0];
                    socket.send(userName, index[(int )Math.round((float)2*Math.random())]);
                    Thread.sleep(1000);
                }
            }
        }).start();
        return AjaxResult.markSuccess();
    }
}
