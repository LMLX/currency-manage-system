package com.lmlx.app.controller;

import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.service.InterfaceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/interface-model")
public class InterfaceModelController {

    @Autowired
    private InterfaceModelService interfaceModelService;

    //    @CheckLoginOut
    @RequestMapping(value = "/qryDetailList")
    public Object qryDetailList(@RequestBody InterfaceInfoSo so) {
        return AjaxResult.markSuccess(interfaceModelService.qryDetailList(so));
    }
}
