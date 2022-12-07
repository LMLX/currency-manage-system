package com.lmlx.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmlx.app.constant.Constant;
import com.lmlx.app.dao.base.ManageUserInfoMapper;
import com.lmlx.app.model.AjaxResult;
import com.lmlx.app.model.Page;
import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.po.ManageUserInfoPo;
import com.lmlx.app.model.po.ManageUserPhotoInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.so.ManageUserPhotoInfoSo;
import com.lmlx.app.model.so.ManageUserQuery;
import com.lmlx.app.model.vo.ManageUserInfoVo;
import com.lmlx.app.service.ManageUserPhotoInfoService;
import com.lmlx.app.service.ManageUserService;
import com.lmlx.app.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:01
 */
@Service
@Slf4j
public class ManageUserServiceImpl extends ServiceImpl<ManageUserInfoMapper, ManageUserInfoPo> implements ManageUserService   {

    @Resource
    private ManageUserInfoMapper manageUserInfoMapper;

    @Resource
    private ManageUserPhotoInfoService manageUserPhotoInfoService;

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
    public PageResultInfo qryAll(ManageUserQuery query) {
        PageResultInfo pageResultInfo = new PageResultInfo();
        List<ManageUserInfoVo> list = new ArrayList<>();
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ManageUserInfoPo> poList = manageUserInfoMapper.qryAll(query);
        PageInfo pageInfo = new PageInfo(poList);
        if (!CollectionUtils.isEmpty(poList)) {
            poList.forEach(po -> {
                ManageUserInfoVo vo = manageUserInfoPoToVo(po);
                List<ManageUserPhotoInfoSo> photoInfoSoList = manageUserPhotoInfoService.getByRelationId(vo.getUserId());
                vo.setFileList(photoInfoSoList);
                list.add(vo);
            });
        }
        pageResultInfo.setList(list);
        pageResultInfo.setTotal(pageInfo.getTotal());

        return pageResultInfo;
    }

    @Override
    @Transactional
    public void merge(ManageUserInfoSo so) {
        ManageUserInfoPo po = BeanUtil.copyProperties(so, ManageUserInfoPo.class);
        if (null != so.getUserId()) {
            manageUserInfoMapper.updateById(po);
//            if (CollectionUtils.isNotEmpty(so.getFileList())) {
                addPhoto(so.getUserId(), so.getFileList());
//            }
        } else {
            manageUserInfoMapper.insert(po);
//            if (CollectionUtils.isNotEmpty(so.getFileList())) {
                addPhoto(po.getUserId(), so.getFileList());
//            }
        }

    }

    @Override
    @Transactional
    public void delete(ManageUserInfoSo so) {
        //删人
        manageUserInfoMapper.deleteById(so.getUserId());
        //删图
        manageUserPhotoInfoService.deleteByRelationId(so.getUserId());
    }

    private void addPhoto(Long userId, List<ManageUserPhotoInfoSo> soList) {
        List<ManageUserPhotoInfoPo> list = BeanUtil.copyToList(soList, ManageUserPhotoInfoPo.class);
        list.forEach(e -> {
            e.setRelationId(userId);
        });
        manageUserPhotoInfoService.addByRelationId(userId, list);
    }

    private ManageUserInfoVo manageUserInfoPoToVo(ManageUserInfoPo po) {
        ManageUserInfoVo vo = new ManageUserInfoVo();
        if(po == null) return vo;
        else {
            vo = BeanUtil.copyProperties(po, ManageUserInfoVo.class);
            String educationInfo = Constant.EDUCATION.INFO.getOrDefault(po.getEducation(), "未知");
            vo.setEducationInfo(educationInfo);
            if (null != po.getBirthday()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    vo.setAge(DateUtil.ageOfNow(po.getBirthday()));
                    vo.setZodiac(new ChineseDate(sdf.parse(po.getBirthday())).getChineseZodiac());

                } catch (Exception e) {

                }
            }

        }
        return vo;
    }
}
