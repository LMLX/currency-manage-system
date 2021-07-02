package com.lmlx.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmlx.app.dao.base.IntegrationAppInfpMapper;
import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.po.IntegrationAppInfoPo;
import com.lmlx.app.model.so.IntegrationAppInfoSo;
import com.lmlx.app.model.vo.IntegrationAppInfoVo;
import com.lmlx.app.service.IntegrationAppService;
import com.lmlx.app.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-07 15:53
 */
@Service
public class IntegrationAppServiceImpl implements IntegrationAppService {

    @Resource
    private IntegrationAppInfpMapper integrationAppInfpMapper;

    @Override
    public PageResultInfo qryAll(IntegrationAppInfoSo so) {
        PageResultInfo pageResultInfo = new PageResultInfo();
        if (PageUtil.isNotNull(so)) {
            PageHelper.startPage(so.getPageNum(), so.getPageSize());
        }
        List<IntegrationAppInfoPo> list = integrationAppInfpMapper.qryAll(so);
        PageInfo<IntegrationAppInfoPo> poPageInfo = new PageInfo<>(list);
        List<IntegrationAppInfoVo> result = list.stream().map(this::menuPoToVo).collect(Collectors.toList());
        pageResultInfo.setList(result);
        pageResultInfo.setTotal(poPageInfo.getTotal());
        return pageResultInfo;
    }

    @Override
    public void merge(List<IntegrationAppInfoSo> list) {
        list.forEach(e -> {
            if (null == e.getAppId()) {
                integrationAppInfpMapper.save(e);
                System.out.println(e.getAppId());
            } else {
                integrationAppInfpMapper.update(e);
            }
        });
    }

    @Override
    public void updateBatch(List<IntegrationAppInfoSo> list) {
        integrationAppInfpMapper.updateBatch(list);
    }

    @Override
    public void update(IntegrationAppInfoSo so) {
        integrationAppInfpMapper.update(so);
    }

    @Override
    public void saveBatch(List<IntegrationAppInfoSo> list) {
        integrationAppInfpMapper.saveBatch(list);
    }

    @Override
    public Long save(IntegrationAppInfoSo so) {
        return integrationAppInfpMapper.save(so);
    }

    @Override
    public void delete(List<IntegrationAppInfoSo> list) {
        System.out.println(JSONObject.toJSONString(list));
        integrationAppInfpMapper.delete(list);
    }

    private IntegrationAppInfoVo menuPoToVo(IntegrationAppInfoPo po) {
        IntegrationAppInfoVo vo = new IntegrationAppInfoVo();
        vo.setAppId(po.getAppId());
        vo.setAppName(po.getAppName());
        vo.setAppDesc(po.getAppDesc());
        vo.setAppDevHost(po.getAppDevHost());
        vo.setAppProHost(po.getAppProHost());
        vo.setCreator(po.getCreator());
        vo.setCreateTime(po.getCreateTime());
        vo.setUpdator(po.getUpdator());
        vo.setUpdateTime(po.getUpdateTime());
        return vo;
    }
}
