package com.lmlx.app.controller;

import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.Page;
import com.lmlx.app.model.so.IntegrationAppInfoSo;
import com.lmlx.app.service.IntegrationAppService;
import com.lmlx.app.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-07 15:49
 */

@RestController
@RequestMapping(value = "/app")
public class IntegrationAppController {

    @Autowired
    private IntegrationAppService integrationAppService;

    @RequestMapping(value = "/qryAll")
    public Object qryAll(@Valid @RequestBody IntegrationAppInfoSo so, HttpServletRequest req) {

        Object result = integrationAppService.qryAll(so);
        return AjaxResult.markSuccess(result);
    }

    @RequestMapping(value = "/merge")
    public Object update(@Valid @RequestBody List<IntegrationAppInfoSo> list, HttpServletRequest req) {
        integrationAppService.merge(list);
        return AjaxResult.markSuccess();
    }
}
