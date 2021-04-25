package com.lmlx.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmlx.app.constant.Constant;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.Page;
import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.po.ManageUserInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageUserInfoVo;
import com.lmlx.app.service.ManageUserService;
import com.lmlx.app.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:01
 */
@Service
@Slf4j
public class ManageUserServiceImpl implements ManageUserService {

    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @Override
    public AjaxResult checkLogin(ManageUserInfoSo so) {

        ManageUserInfoPo po = manageUserInfoMapper.qryByAccount(so);
//        System.out.println(JSONObject.toJSON(pos));
        log.info(JSONObject.toJSONString(po));
        if (null == po) {
            return AjaxResult.markError(Constant.ERROR.ERROR_00100001);
        }
        if (!so.getPassword().equals(po.getPassword())) {
            return AjaxResult.markError(Constant.ERROR.ERROR_00100002);
        }
        ManageUserInfoVo vo = manageUserInfoPoToVo(po);
        String token = JwtUtil.sign(po.getUserId());
        vo.setToken(token);
        //更新用户的地理位置
        po.setLastLoginPosition(so.getPosition());

        manageUserInfoMapper.updatePosi(po);
        return AjaxResult.markSuccess(vo);
    }

    @Override
    public PageResultInfo qryAll(Page page) {
        PageResultInfo pageResultInfo = new PageResultInfo();
        List<ManageUserInfoVo> list = new ArrayList<>();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<ManageUserInfoPo> poList = manageUserInfoMapper.qryAll();
        PageInfo pageInfo = new PageInfo(poList);
        if (!CollectionUtils.isEmpty(poList)) {
            poList.forEach(po -> {
                list.add(manageUserInfoPoToVo(po));
            });
        }
        pageResultInfo.setList(list);
        pageResultInfo.setTotal(pageInfo.getTotal());
        return pageResultInfo;
    }

    private ManageUserInfoVo manageUserInfoPoToVo(ManageUserInfoPo po) {
        ManageUserInfoVo vo = new ManageUserInfoVo();
        if(po == null) return vo;
        else {
            vo.setUserId(po.getUserId());
            vo.setAccount(po.getAccount());
            vo.setUserName(po.getUserName());
            Long roleId = po.getRoleId();
            vo.setRoleId(roleId);
            vo.setAddress(po.getAddress());
            vo.setRole(Constant.USER_ROLE.INFO.get(roleId));
            vo.setLastLoginPosition(po.getLastLoginPosition());
            SimpleDateFormat sdf = new SimpleDateFormat(Constant.TIME_FORMAT.DATE);
            if (null != po.getLastLoginTime()) {
                vo.setLastLoginTime(sdf.format(po.getLastLoginTime()));
            } else {
                vo.setLastLoginTime("未知");
            }
        }
        return vo;
    }
}
