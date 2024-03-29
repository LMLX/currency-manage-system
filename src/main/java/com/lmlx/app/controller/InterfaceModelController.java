package com.lmlx.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.so.IntegrationAppInfoSo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.so.InterfaceModelInfoSo;
//import com.lmlx.app.model.so.QryModelTreeByAppIdSo;
import com.lmlx.app.service.InterfaceModelService;
import com.lmlx.app.system.CheckLoginOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/model")
public class InterfaceModelController {

    @Autowired
    private InterfaceModelService interfaceModelService;

//    @CheckLoginOut
//    @RequestMapping(value = "/qryModelTreeByAppId")
//    public Object qryModelTreeByAppId(@RequestBody QryModelTreeByAppIdSo so) {
//        return AjaxResult.markSuccess(interfaceModelService.qryModelTreeByAppId(so));
//    }

    @CheckLoginOut
    @RequestMapping(value = "/merge")
    public Object update(@RequestBody InterfaceModelInfoSo so) {
        return AjaxResult.markSuccess(interfaceModelService.merge(so));
    }

    @CheckLoginOut
    @RequestMapping(value = "/deleteByIds")
    public Object deleteByIds(@RequestBody List<Long> modelIdList) {
        interfaceModelService.deleteByIds(modelIdList);
        return AjaxResult.markSuccess();
    }
}
