package com.lmlx.app.service.impl;

import com.lmlx.app.constant.Constant;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.po.ManageUserInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageUserInfoVo;
import com.lmlx.app.service.ManageUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:01
 */
@Service
public class ManageUserServiceImpl implements ManageUserService {

    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @Override
    public AjaxResult checkLogin(ManageUserInfoSo so) {

        ManageUserInfoPo po = manageUserInfoMapper.qryByAccount(so);
        if (null == po) {
            return AjaxResult.markError(Constant.ERROR.ERROR_00100001);
        }
        if (!so.getPassword().equals(po.getPassword())) {
            return AjaxResult.markError(Constant.ERROR.ERROR_00100002);
        }
        ManageUserInfoVo vo = manageUserInfoPoToVo(po);
        return AjaxResult.markSuccess(vo);
    }

    @Override
    public ManageUserInfoVo qryByAccount(ManageUserInfoSo so) {
        ManageUserInfoPo po = manageUserInfoMapper.qryByAccount(so);
        ManageUserInfoVo vo = manageUserInfoPoToVo(po);
        return vo;
    }

    private ManageUserInfoVo manageUserInfoPoToVo(ManageUserInfoPo po) {
        ManageUserInfoVo vo = new ManageUserInfoVo();
        if(po == null) return vo;
        else {
            vo.setUserId(po.getUserId());
            vo.setAccount(po.getAccount());
            vo.setUserName(po.getUserName());
            vo.setRole(Constant.USER_ROLE.INFO.get(po.getRoleId()));
        }
        return vo;
    }
}
