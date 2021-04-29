package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InterfaceModelInfoMapper {

    @Select("SELECT ID, PID, NAME FROM INTERFACE_MODEL_INFO WHERE APP_ID = #{appId}")
    List<InterfaceModelInfoPo> qryDetailList(InterfaceInfoSo so);
}
