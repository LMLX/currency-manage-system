package com.lmlx.app.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class ManageMenuInfoVo {
    private String icon;
    private String index;
    private String title;
    private List<ManageMenuInfoVo> subs;
}
