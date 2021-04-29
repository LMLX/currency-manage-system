package com.lmlx.app.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmlx.app.constant.Constant;
import com.lmlx.app.dao.base.InterfaceDetailInfoMapper;
import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.po.InterfaceModelDetailInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.vo.InterfaceDetailInfoVo;
import com.lmlx.app.service.InterfaceDetailService;
import com.lmlx.app.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:15
 */
@Slf4j
@Service
public class InterfaceDetailServiceImpl implements InterfaceDetailService {

    @Resource
    private InterfaceDetailInfoMapper interfaceDetailInfoMapper;

    @Override
    public PageResultInfo qryDetailList(InterfaceInfoSo so) {
        PageResultInfo pageResultInfo = new PageResultInfo();
        if (PageUtil.isNotNull(so)) {
            PageHelper.startPage(so.getPageNum(), so.getPageSize());
        }
        List<InterfaceModelDetailInfoPo> list = interfaceDetailInfoMapper.qryDetailList(so);
        PageInfo<InterfaceModelDetailInfoPo> poPageInfo = new PageInfo<>(list);
        List<InterfaceDetailInfoVo> result = list.stream().map(this::interfaceModelDetailInfoPoToVo).collect(Collectors.toList());
        pageResultInfo.setList(result);
        pageResultInfo.setTotal(poPageInfo.getTotal());
        return pageResultInfo;
    }

    @Override
    public InterfaceDetailInfoVo qryDetailById(InterfaceInfoSo so) throws Exception {
        if (null == so.getInterfaceId()) {
            throw new Exception(Constant.ERROR.ERROR_00100004);
        }
        InterfaceModelDetailInfoPo po = interfaceDetailInfoMapper.qryDetailById(so);
        InterfaceDetailInfoVo vo = interfaceModelDetailInfoPoToVo(po);
        return vo;
    }

    public InterfaceDetailInfoVo interfaceModelDetailInfoPoToVo(InterfaceModelDetailInfoPo po) {
        InterfaceDetailInfoVo vo = new InterfaceDetailInfoVo();
        if (null != po) {
            vo.setInterfaceId(po.getInterfaceId());
            vo.setInterfaceName(po.getInterfaceName());
            vo.setInterfaceDesc(po.getInterfaceDesc());
            vo.setType(po.getType());
            vo.setModelId(po.getModelId());
            vo.setModelName(po.getModelName());
            vo.setAppId(po.getAppId());
            vo.setInterfaceUrl(po.getInterfaceUrl());
        }
        return vo;
    }
}
