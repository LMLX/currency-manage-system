package com.lmlx.app.service.impl;

import com.lmlx.app.dao.base.InterfaceDetailInfoMapper;
import com.lmlx.app.dao.base.InterfaceModelInfoMapper;
import com.lmlx.app.model.po.InterfaceModelInfoPo;
import com.lmlx.app.model.so.InterfaceInfoSo;
import com.lmlx.app.model.vo.InterfaceModelInfoVo;
import com.lmlx.app.model.vo.ManageMenuInfoVo;
import com.lmlx.app.service.InterfaceModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class InterfaceModelServiceImpl implements InterfaceModelService {

    @Resource
    private InterfaceModelInfoMapper interfaceModelInfoMapper;

    @Override
    public List<InterfaceModelInfoVo> qryDetailList(InterfaceInfoSo so) {
        List<InterfaceModelInfoPo> list = interfaceModelInfoMapper.qryDetailList(so);
        return modelPoListToVo(list);
    }

    public List<InterfaceModelInfoVo> modelPoListToVo(List<InterfaceModelInfoPo> pos) {
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
                    if (CollectionUtils.isEmpty(pVo.getChildren())) {
                        pVo.setChildren(new ArrayList<>());
                    }
                    List<InterfaceModelInfoVo>  subs = pVo.getChildren();
                    subs.add(vo);
                }
            });
        }
        return headList;
    }

    public InterfaceModelInfoVo modelPoToVo(InterfaceModelInfoPo po) {
        InterfaceModelInfoVo vo = new InterfaceModelInfoVo();
        if (null != po) {
            vo.setModelId(po.getId());
            vo.setModelName(po.getName());
        }
        return vo;
    }
}
