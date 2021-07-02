package com.lmlx.app.controller;

import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.service.InterfaceDetailService;
import com.lmlx.app.system.CheckLoginOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:14
 */
@RestController
@RequestMapping(value = "/interface")
public class InterfaceDetailController {

    @Autowired
    private InterfaceDetailService interfaceDetailInfoService;

    @CheckLoginOut
    @RequestMapping(value = "/qryDetailList")
    public Object qryDetail(@RequestBody InterfaceInfoSo so) {
        return AjaxResult.markSuccess(interfaceDetailInfoService.qryDetailList(so));
    }

    @CheckLoginOut
    @RequestMapping(value = "/qryDetailById")
    public Object qryDetailById(@RequestBody InterfaceInfoSo so) throws Exception {
        return AjaxResult.markSuccess(interfaceDetailInfoService.qryDetailById(so));
    }
}
