package com.lmlx.app.dao.base;

//import com.lmlx.app.model.po.ManageUserInfo;

import com.lmlx.app.model.po.ManageUserInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-10 18:31
 */
@Mapper
@Repository
public interface ManageUserInfoMapper {

//    @Select("select id, account, p_id, role_id from manage_user_info where id=#{id}")
    ManageUserInfoPo qryByAccount(ManageUserInfoSo so);

    List<ManageUserInfoPo> qryAll();
}
