package com.lmlx.app.model.vo;

import lombok.Data;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:23
 */
@Data
public class ManageUserInfoVo {
    private Long userId;
    private String account;
    private String userName;
    private String role;
}
