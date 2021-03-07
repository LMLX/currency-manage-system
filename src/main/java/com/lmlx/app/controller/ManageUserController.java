package com.lmlx.app.controller;

import com.lmlx.app.model.Page;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.service.ManageUserService;
import com.lmlx.app.system.CheckLoginOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:19
 */
@RestController
@RequestMapping(value = "/user")
public class ManageUserController {

    @Autowired
    private ManageUserService manageUserService;

    @RequestMapping(value = "/checkLogin")
    public Object checkLogin(@RequestBody ManageUserInfoSo so) {
        Object result = manageUserService.checkLogin(so);
        return result;
    }

//    @CheckLoginOut
//    @RequestMapping(value = "/checkLoginOut")
//    public Object checkLoginOut() {
//        return true;
//    }

//    @CheckLoginOut
    @RequestMapping(value = "/qryAll")
    public Object qryAll(@Valid @RequestBody Page page) {
        Object result = manageUserService.qryAll(page);
        return result;
    }
}
