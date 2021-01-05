package com.lmlx.app.model.vo;

import com.lmlx.app.model.Meta;
import lombok.Data;

import java.util.List;

@Data
public class ManageMenuInfoVo {
    private String icon;
    private String index;
    private String path;
    private String component;
    private Meta meta;
    private List<ManageMenuInfoVo> children;
}
