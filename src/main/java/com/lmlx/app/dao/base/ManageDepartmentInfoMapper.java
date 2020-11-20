package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.ManageDepartmentInfoPo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-13 14:48
 */
public interface ManageDepartmentInfoMapper {

    @Select("select depart_id, depart_name, p_depart_id, leader, creator, create_time, updator, update_time from manage_department_info")
    List<ManageDepartmentInfoPo> qryAll();
}
