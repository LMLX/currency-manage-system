package com.lmlx.app.model.po;

import lombok.Data;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:31
 */
@Data
public class InterfaceModelDetailInfoPo {
    private Long interfaceId;
    private String interfaceName;
    private String interfaceUrl;
    private String interfaceDesc;
    private String type;
    private Long modelId;
    private String modelName;
    private Long appId;
}
