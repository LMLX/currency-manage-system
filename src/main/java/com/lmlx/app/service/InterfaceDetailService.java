package com.lmlx.app.service;

import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.vo.InterfaceDetailInfoVo;

import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:15
 */
public interface InterfaceDetailService {

    PageResultInfo qryDetailList(InterfaceInfoSo so);

    InterfaceDetailInfoVo qryDetailById(InterfaceInfoSo so) throws Exception;
}
