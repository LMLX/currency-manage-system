package com.lmlx.app.service;

import com.lmlx.app.model.Page;
import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.so.ManageUserQuery;

/**
 * @author jiahao jin
 * @create 2020-12-25 15:49
 */
public interface ManageUserService {

    Object checkLogin(ManageUserInfoSo so);

    PageResultInfo qryAll(ManageUserQuery query);

    void merge(ManageUserInfoSo so);

    void delete(ManageUserInfoSo so);

}
