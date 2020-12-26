package com.lmlx.app.service;

import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageUserInfoVo;

/**
 * @author jiahao jin
 * @create 2020-12-25 15:49
 */
public interface ManageUserService {

    Object checkLogin(ManageUserInfoSo so);

    ManageUserInfoVo qryByAccount(ManageUserInfoSo so);
}
