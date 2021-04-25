package com.lmlx.app.model.vo;

import lombok.Data;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:24
 */
@Data
public class InterfaceDetailInfoVo {
    private Long interfaceId;
    private String interfaceName;
    private String interfaceUrl;
    private String interfaceDesc;
    private String type;
    private Long modelId;
    private String modelName;
    private Long appId;
}
