package com.lmlx.app.controller;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.service.IntegrationAppService;
import com.lmlx.app.service.TestAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author jiahao jin
 * @create 2020-11-10 17:08
 */

@RestController
public class HelloController {

    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @Autowired
    private TestAService testAService;


    @RequestMapping(value = "/hello")
    public Object hello(){
//        testAService.saveA();
//        return JSONObject.toJSON(manageUserInfoMapper.qryById(1L));
//        System.out.println(1/0);
//        String[] index = new String[]{"aaa", "bbb", "ccc"};
//        new Thread(new Runnable() {
//            @SneakyThrows
//            public void run() {
//                while (true) {
//                    String userName = index[0];
//                    socket.send(userName, index[(int )Math.round((float)2*Math.random())]);
//                    Thread.sleep(1000);
//                }
//            }
//        }).start();
//        RestTemplate restTemplate = new RestTemplate();
//        String s= restTemplate.getForObject("http://localhost:8101/park/model/camera-info/qryLRUCameraInfoTop", String.class);
//        Node n1 = new Node();
//        Node n2 = new Node();
//        n1.next = n2;
//        Node n3 = new Node();
//        n2.next = n3;
//        n3.next = n1;
//        Node current = n1;
//        while (null != current) {
//            current = current.next;
//        }
//        System.out.println(1/0);
        return AjaxResult.markSuccess();
    }
    private static class Node {
        public Node next;
    }
}
