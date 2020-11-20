package com.lmlx.app.service;

import com.lmlx.app.model.po.ManageDepartmentInfoPo;
import com.lmlx.app.model.vo.ManageDepartmentInfoVo;

import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-13 14:54
 */

public interface ManageDepartmentService {
    List<ManageDepartmentInfoPo> qryAll();

    ManageDepartmentInfoVo qryDepartmentTree();
}
