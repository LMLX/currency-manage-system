package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.InterfaceModelDetailInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.vo.InterfaceDetailInfoVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:13
 */
public interface InterfaceDetailInfoMapper {

    List<InterfaceModelDetailInfoPo> qryDetailList(InterfaceInfoSo so);

    InterfaceModelDetailInfoPo qryDetailById(InterfaceInfoSo so);
}
