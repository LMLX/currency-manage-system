package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.so.InterfaceModelInfoSo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InterfaceModelInfoMapper {


    List<InterfaceModelInfoPo> qryDetailList(InterfaceModelInfoSo so);

    Long save(InterfaceModelInfoSo so);

    void update(InterfaceModelInfoSo so);
}
