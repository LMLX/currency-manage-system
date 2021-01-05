package com.lmlx.app.dao.base;

//import com.lmlx.app.model.po.ManageUserInfo;

import com.lmlx.app.model.po.ManageUserInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-10 18:31
 */
@Mapper
@Repository
public interface ManageUserInfoMapper {

    ManageUserInfoPo qryByAccount(ManageUserInfoSo so);

    @Update("UPDATE MANAGE_USER_INFO SET LAST_LOGIN_POSITION = #{lastLoginPosition}, LAST_LOGIN_TIME = SYSDATE() WHERE USER_ID=#{userId}")
    void updatePosi(ManageUserInfoPo po);

    List<ManageUserInfoPo> qryAll();
}
