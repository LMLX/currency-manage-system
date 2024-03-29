package com.lmlx.app.model.so;

import com.lmlx.app.model.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-07 15:51
 */

@Data
public class IntegrationAppInfoSo extends Page implements Serializable {
    private Long appId;
    private String appName;
    private String appDesc;
    private String appDevHost;
    private String appProHost;
    private Long creator;
    private Long updator;
}
