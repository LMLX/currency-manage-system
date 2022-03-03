package com.lmlx.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmlx.app.dao.base.ManageUserPhotoInfoMapper;
import com.lmlx.app.model.po.ManageUserPhotoInfoPo;
import com.lmlx.app.model.so.ManageUserPhotoInfoSo;
import com.lmlx.app.service.ManageUserPhotoInfoService;
import com.lmlx.app.service.ManageUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ManageUserPhotoInfoServiceImpl extends ServiceImpl<ManageUserPhotoInfoMapper, ManageUserPhotoInfoPo> implements ManageUserPhotoInfoService {

    @Autowired
    private ManageUserPhotoInfoMapper manageUserPhotoInfoMapper;

    @Override
    public void deleteByRelationId(Long relationId) {
        manageUserPhotoInfoMapper.delete(Wrappers.<ManageUserPhotoInfoPo>lambdaQuery()
                .eq(ManageUserPhotoInfoPo::getRelationId, relationId));
    }

    @Override
    public List<ManageUserPhotoInfoSo> getByRelationId(Long relationId) {
        List<ManageUserPhotoInfoSo> result = new ArrayList<>();
        List<ManageUserPhotoInfoPo> list = baseMapper.selectList(Wrappers.<ManageUserPhotoInfoPo>lambdaQuery()
                .eq(ManageUserPhotoInfoPo::getRelationId, relationId)
                .orderByDesc(ManageUserPhotoInfoPo::getId)
        );
        if (CollectionUtils.isNotEmpty(list)) {
            result = BeanUtil.copyToList(list, ManageUserPhotoInfoSo.class);
        }
        return result;
    }

    @Override
    public void addByRelationId(Long relationId, List<ManageUserPhotoInfoPo> poList) {
        deleteByRelationId(relationId);
        saveOrUpdateBatch(poList);
    }
}
