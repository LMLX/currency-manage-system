package com.lmlx.app.model;

import lombok.Data;

import java.util.List;

/**
 * @AUTHOR jiahao jin
 * @created 2021-01-12 10:57
 */
@Data
public class PageResultInfo {
    private List list;
    private Long total;
}
