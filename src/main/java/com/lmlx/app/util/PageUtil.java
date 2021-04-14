package com.lmlx.app.util;

import com.lmlx.app.model.Page;

/**
 * @AUTHOR jiahao jin
 * @created 2021-03-09 11:45
 */
public class PageUtil {
    public static boolean isNotNull(Page page) {
        if (null == page.getPageNum() || null == page.getPageSize()) return false;
        return true;
    }
}
