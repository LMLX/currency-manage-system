package com.lmlx.app.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @AUTHOR jiahao jin
 * @created 2021-01-11 15:21
 */
@Data
public class Page {
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;

}
