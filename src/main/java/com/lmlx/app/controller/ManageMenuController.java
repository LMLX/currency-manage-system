package com.lmlx.app.controller;

import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.service.ManageMenuService;
import com.lmlx.app.system.CheckLoginOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiahao jin
 * @create 2020-12-25 14:59
 */
@RestController
@RequestMapping(value = "/menu")
public class ManageMenuController {

    @Autowired
    private ManageMenuService manageMenuService;

    @CheckLoginOut
    @RequestMapping(value = "/queMenuByUserId")
    public Object queMenuByUserId(@RequestBody ManageUserInfoSo so) {
        return AjaxResult.markSuccess(manageMenuService.queMenuByUserId(so));
    }
}
