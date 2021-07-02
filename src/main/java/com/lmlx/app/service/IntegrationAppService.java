package com.lmlx.app.service;

import com.lmlx.app.model.PageResultInfo;
import com.lmlx.app.model.so.IntegrationAppInfoSo;

import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-07 15:53
 */
public interface IntegrationAppService {

    PageResultInfo qryAll(IntegrationAppInfoSo so);

    void merge(List<IntegrationAppInfoSo> list);

    void updateBatch(List<IntegrationAppInfoSo> list);

    void update(IntegrationAppInfoSo so);

    void saveBatch(List<IntegrationAppInfoSo> list);

    Long save(IntegrationAppInfoSo so);

    void delete(List<IntegrationAppInfoSo> list);
}
