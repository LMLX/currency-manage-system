package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.ManageMenuInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ManageMenuInfoMapper {

    @Select("select id, icon, ident, title, url, p_id as pId from manage_menu_info t1, manage_role_menu_info t2 where t1.id = t2.menu_id and t2.role_id = #{roleId} order by rank_id")
    List<ManageMenuInfoPo> queMenuByUserId(ManageUserInfoSo so);
}
