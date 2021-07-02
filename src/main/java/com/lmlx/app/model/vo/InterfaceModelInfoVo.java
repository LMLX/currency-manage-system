package com.lmlx.app.model.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InterfaceModelInfoVo {
    private Long modelId;
    private String modelName;
    private String modelUrl;
    private Long creator;
    private Date createTime;
    private Long updator;
    private Date updateTime;
    private Long appId;
    private List<InterfaceModelInfoVo> children;
}
