package com.lmlx.app.model.vo;

import com.lmlx.app.system.config.tableInfo.Column;
import lombok.Data;

import java.util.Date;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-09 11:49
 */
@Data
public class IntegrationAppInfoVo {

    private Long appId;
    private String appName;
    private String appDesc;
    private String appDevHost;
    private String appProHost;
    private Long creator;
    private Date createTime;
    private Long updator;
    private Date updateTime;
}
