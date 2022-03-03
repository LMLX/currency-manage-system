package com.lmlx.app.service;

import com.lmlx.app.model.po.ManageUserPhotoInfoPo;
import com.lmlx.app.model.so.ManageUserPhotoInfoSo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ManageUserPhotoInfoService {
    void deleteByRelationId(Long relationId);

    List<ManageUserPhotoInfoSo> getByRelationId(Long relationId);

    void addByRelationId(Long relationId, List<ManageUserPhotoInfoPo> soList);
}
