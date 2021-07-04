package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.so.InterfaceModelInfoSo;
import com.lmlx.app.model.so.QryModelTreeByAppIdSo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

public interface InterfaceModelInfoMapper {


    List<InterfaceModelInfoPo> qryModelTreeByAppId(QryModelTreeByAppIdSo so);

    Long save(InterfaceModelInfoSo so);

    void update(InterfaceModelInfoSo so);

    void deleteByIds(@Param("modelIdSet") Set<Long> allModelIdSet);

    List<InterfaceModelInfoPo> qryChildModelsByPIds(@Param("modelIdList") List<Long> modelIdList);
}
