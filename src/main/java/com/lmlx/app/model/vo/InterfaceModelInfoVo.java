package com.lmlx.app.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class InterfaceModelInfoVo {
    private Long modelId;
    private String modelName;
    private List<InterfaceModelInfoVo> children;
}
