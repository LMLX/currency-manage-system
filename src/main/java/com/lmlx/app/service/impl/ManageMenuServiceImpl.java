package com.lmlx.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lmlx.app.dao.base.ManageMenuInfoMapper;
import com.lmlx.app.model.Meta;
import com.lmlx.app.model.po.ManageMenuInfoPo;
import com.lmlx.app.model.so.ManageUserInfoSo;
import com.lmlx.app.model.vo.ManageMenuInfoVo;
import com.lmlx.app.service.ManageMenuService;
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
public class ManageMenuServiceImpl implements ManageMenuService {

    @Resource
    private ManageMenuInfoMapper manageMenuInfoMapper;

    @Override
    public List<ManageMenuInfoVo> qryMenuByUserId(ManageUserInfoSo so) {

        List<ManageMenuInfoPo> list = manageMenuInfoMapper.qryMenuByUserId(so);
        System.out.println(JSONObject.toJSONString(list));
        return menuPoListToVo(list);
    }

    private List<ManageMenuInfoVo> menuPoListToVo(List<ManageMenuInfoPo> pos) {
        List<ManageMenuInfoVo> headList = new ArrayList<>();
        Map<Long, ManageMenuInfoVo> indexMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(pos)) {
            pos.forEach(po -> {
                ManageMenuInfoVo vo = menuPoToVo(po);
                indexMap.put(po.getId(), vo);

                //拿到父级ID (前提是已经排好序，并且父级已经存到了map)
                Long pId = po.getPId();
                if (null == pId || 0L == pId) {
                    headList.add(vo);
                } else {
                    ManageMenuInfoVo pVo = indexMap.get(pId);
                    if (CollectionUtils.isEmpty(pVo.getChildren())) {
                        pVo.setChildren(new ArrayList<>());
                    }
                    List<ManageMenuInfoVo>  subs = pVo.getChildren();
                    subs.add(vo);
                }
            });
        }
        return headList;
    }

    private ManageMenuInfoVo menuPoToVo(ManageMenuInfoPo po) {
        ManageMenuInfoVo vo = new ManageMenuInfoVo();
        if (null != po) {
            vo.setIcon(po.getIcon());
            vo.setIndex(po.getIdent());
            Meta meta = new Meta();
            meta.setTitle(po.getTitle());
            vo.setPath(po.getUrl());
            vo.setComponent(po.getComponent());
            vo.setMeta(meta);
            vo.setName(po.getName());
        }
        return vo;
    }
}
