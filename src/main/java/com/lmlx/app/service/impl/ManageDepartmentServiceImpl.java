package com.lmlx.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.dao.base.ManageDepartmentInfoMapper;
import com.lmlx.app.model.po.ManageDepartmentInfoPo;
import com.lmlx.app.model.vo.ManageDepartmentInfoVo;
import com.lmlx.app.service.ManageDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-13 14:54
 */
@Slf4j
@Service
public class ManageDepartmentServiceImpl implements ManageDepartmentService {

    @Resource
    private ManageDepartmentInfoMapper manageDepartmentInfoMapper;

    @Override
    public List<ManageDepartmentInfoPo> qryAll() {
        List<ManageDepartmentInfoPo> list = manageDepartmentInfoMapper.qryAll();
        log.info(JSONObject.toJSONString(list));
        return list;
    }

    @Override
    public ManageDepartmentInfoVo qryDepartmentTree() {
//        ManageDepartmentInfoVo vo = new ManageDepartmentInfoVo();
        List<ManageDepartmentInfoPo> list = qryAll();
        HashMap<Long, ManageDepartmentInfoVo> mapVo = new HashMap<>();
        List<ManageDepartmentInfoVo> headList = new ArrayList<>();
        for(ManageDepartmentInfoPo po : list) {
            Long departId = po.getDepartId();
            Long pDepartId = po.getPDepartId();
            ManageDepartmentInfoVo vo = poToVo(po);
            mapVo.put(departId, vo);
            if(null == pDepartId) {
                headList.add(vo);
            }else {
                ManageDepartmentInfoVo pVo = mapVo.get(pDepartId);
                List chileList = pVo.getChild();
                if(null == chileList) {
                    chileList = new ArrayList<>();
                    pVo.setChild(chileList);
                }
                chileList.add(vo);
            }

        }
        return null;
    }

    private ManageDepartmentInfoVo poToVo(ManageDepartmentInfoPo po) {
        ManageDepartmentInfoVo vo = new ManageDepartmentInfoVo();
        vo.setId(po.getDepartId());
        vo.setLabel(po.getDepartName());
        return vo;
    }
}
