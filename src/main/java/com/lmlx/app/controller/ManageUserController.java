package com.lmlx.app.controller;

import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageUserInfoVo;
import com.lmlx.app.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
