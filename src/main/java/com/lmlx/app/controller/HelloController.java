package com.lmlx.app.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author jiahao jin
 * @create 2020-11-10 17:08
 */

@RestController
public class HelloController {


    @RequestMapping(value = "/hello")
    public Object hello(){
        return new Date();
    }
}
