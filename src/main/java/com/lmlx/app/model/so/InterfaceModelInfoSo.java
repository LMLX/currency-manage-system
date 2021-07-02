package com.lmlx.app.model.so;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lmlx.app.model.Page;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-07 15:51
 */

@Data
@ToString(doNotUseGetters=true)
public class InterfaceModelInfoSo extends Page {
    private Long modelId;
    private String modelName;
    private String modelUrl;
    private Long creator;
    private Long updator;
    private Long appId;
    @JsonProperty("pModelId")
    private Long pModelId;
    @JsonProperty("pId")
    private Long pId;
}
