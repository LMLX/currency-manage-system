package com.lmlx.app.model.so;

import com.lmlx.app.model.Page;
import lombok.Data;

/**
 * @AUTHOR jiahao jin
 * @created 2021-04-24 11:22
 */
@Data
public class InterfaceInfoSo extends Page {
    private Long appId;
    private Long modelId;
    private Long interfaceId;
    private String modelName;
    private String interfaceName;
}
