package com.lmlx.app.service;

import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.vo.InterfaceModelInfoVo;

import java.util.List;

public interface InterfaceModelService {

    List<InterfaceModelInfoVo> qryDetailList(InterfaceInfoSo so);
}
