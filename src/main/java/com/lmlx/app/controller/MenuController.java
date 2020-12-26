package com.lmlx.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiahao jin
 * @create 2020-12-25 14:59
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "/getAll")
    public Object getAll() {
        return 0;
    }
}
