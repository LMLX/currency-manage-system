package com.lmlx.app.controller;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.Page;
import com.lmlx.app.model.so.InterfaceModelInfoSo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.so.ManageUserQuery;
import com.lmlx.app.service.ManageUserService;
import com.lmlx.app.system.CheckLoginOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.validation.Valid;
import java.io.IOException;

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

    @CheckLoginOut
    @RequestMapping(value = "/qryAll")
    public Object qryAll(@RequestBody ManageUserQuery page) {
        Object result = manageUserService.qryAll(page);
        return AjaxResult.markSuccess(result);
    }

    @CheckLoginOut
    @RequestMapping(value = "/merge")
    public Object merge(@RequestBody ManageUserInfoSo so) {
        System.out.println(JSONObject.toJSONString(so));
        manageUserService.merge(so);
        return AjaxResult.markSuccess();
    }

    @CheckLoginOut
    @RequestMapping(value = "/delete")
    public Object delete(@RequestBody ManageUserInfoSo so) {
        System.out.println(JSONObject.toJSONString(so));
        manageUserService.delete(so);
        return AjaxResult.markSuccess();
    }

    @CheckLoginOut
    @RequestMapping(value = "/upload")
    public Object update(MultipartFile file) {

        String base64EncoderImg = null;
        try {
            base64EncoderImg = "data:img/jpg;base64," + (Base64.encodeStr(file.getBytes(), true, false).replaceAll("\r\n", ""));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.markSuccess(base64EncoderImg);
    }

}
