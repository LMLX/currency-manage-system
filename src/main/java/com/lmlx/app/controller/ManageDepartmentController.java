package com.lmlx.app.controller;

import com.lmlx.app.service.ManageDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiahao jin
 * @create 2020-11-13 14:53
 */
@RestController
@RequestMapping(value = "/department")
public class ManageDepartmentController {

    @Autowired
    private ManageDepartmentService manageDepartmentService;

    @RequestMapping(value = "/qryAll")
    public Object qryAll() {
        return manageDepartmentService.qryAll();
    }

    @RequestMapping(value = "/qryDepartmentTree")
    public Object qryDepartmentTree() {
        return manageDepartmentService.qryDepartmentTree();
    }


}
