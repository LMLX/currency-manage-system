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
    private Integer pageNum;
    private Integer pageSize;

}
