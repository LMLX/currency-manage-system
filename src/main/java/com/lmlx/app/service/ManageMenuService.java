package com.lmlx.app.service;

import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageMenuInfoVo;

import java.util.List;

public interface ManageMenuService {

    List<ManageMenuInfoVo> qryMenuByUserId(ManageUserInfoSo so);
}
