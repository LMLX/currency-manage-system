package com.lmlx.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.dao.base.InterfaceDetailInfoMapper;
import com.lmlx.app.dao.base.InterfaceModelInfoMapper;
import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.so.InterfaceModelInfoSo;
//import com.lmlx.app.model.so.QryModelTreeByAppIdSo;
import com.lmlx.app.model.so.QryModelTreeByAppIdSo;
import com.lmlx.app.model.vo.InterfaceModelInfoVo;
import com.lmlx.app.model.vo.ManageMenuInfoVo;
import com.lmlx.app.service.InterfaceModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InterfaceModelServiceImpl implements InterfaceModelService {

    @Resource
    private InterfaceModelInfoMapper interfaceModelInfoMapper;

    @Override
    public List<InterfaceModelInfoVo> qryModelTreeByAppId(QryModelTreeByAppIdSo so) {
        List<InterfaceModelInfoPo> list = interfaceModelInfoMapper.qryModelTreeByAppId(so);
        return modelPoTreeToVo(list);
    }

    @Override
    public Long merge(InterfaceModelInfoSo so) {
        if (null == so.getModelId()) {
            interfaceModelInfoMapper.save(so);
        } else {
            interfaceModelInfoMapper.update(so);

        }
        return so.getModelId();
    }

    @Override
    public void deleteByIds(List<Long> modelIdList) {

//        Long[] pModelId = ;
        List<InterfaceModelInfoPo> childModelList = new ArrayList<>();
        Set<Long> allModelIdSet = new HashSet<>(modelIdList);
        do {
            System.out.println(modelIdList);
            childModelList = interfaceModelInfoMapper.qryChildModelsByPIds(modelIdList);
            System.out.println(JSONObject.toJSONString(childModelList));
            modelIdList = childModelList.stream().map(po -> po.getId()).collect(Collectors.toList());
            allModelIdSet.addAll(modelIdList);
        } while (modelIdList.size() != 0);
        System.out.println(allModelIdSet);
        interfaceModelInfoMapper.deleteByIds(allModelIdSet);
    }

    public List<InterfaceModelInfoVo> modelPoTreeToVo(List<InterfaceModelInfoPo> pos) {
        List<InterfaceModelInfoVo> headList = new ArrayList<>();
        Map<Long, InterfaceModelInfoVo> indexMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(pos)) {
            pos.forEach(po -> {
                InterfaceModelInfoVo vo = modelPoToVo(po);
                indexMap.put(po.getId(), vo);

                //拿到父级ID (前提是已经排好序，并且父级已经存到了map)
                Long pId = po.getPId();
                if (null == pId || 0L == pId) {
                    headList.add(vo);
                } else {
                    InterfaceModelInfoVo pVo = indexMap.get(pId);
                    if (null != pVo) {
                        if (CollectionUtils.isEmpty(pVo.getChildren())) {
                            pVo.setChildren(new ArrayList<>());
                        }
                        List<InterfaceModelInfoVo>  subs = pVo.getChildren();
                        subs.add(vo);
                    }

                }
            });
        }
        return headList;
    }

    public InterfaceModelInfoVo modelPoToVo(InterfaceModelInfoPo po) {
        InterfaceModelInfoVo vo = new InterfaceModelInfoVo();
        if (null != po) {
            vo.setModelId(po.getId());
            vo.setModelName(po.getName() + "(" + po.getId() + ")");
            vo.setModelUrl(po.getUrl());
            vo.setCreator(po.getCreator());
            vo.setCreateTime(po.getCreateTime());
            vo.setUpdator(po.getUpdator());
            vo.setUpdateTime(po.getUpdateTime());
            vo.setAppId(po.getAppId());
        }
        return vo;
    }
}
