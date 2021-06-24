package com.lmlx.app.dao.base;

import com.lmlx.app.model.po.IntegrationAppInfoPo;
import com.lmlx.app.model.so.IntegrationAppInfoSo;

import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-09 11:33
 */
public interface IntegrationAppInfpMapper {

    List<IntegrationAppInfoPo> qryAll(IntegrationAppInfoSo so);

    void update(IntegrationAppInfoSo so);

    Long save(IntegrationAppInfoSo so);

    void delete(List<IntegrationAppInfoSo> list);
}
