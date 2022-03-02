package com.lmlx.app.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wu jiawei
 * @date 2020/04/15
 */


public class Constant {

    public interface AJAX_STATUS {
        public final static Integer success = 0;
        public final static Integer error = 1;
        public final static Integer nologin = 2;
    }

    public interface USER_ROLE {
        public final static Map<Long, String> INFO = new HashMap() {
            {
                put(1L, "管理员");
                put(2L, "其他");
            }
        };
    }


    public interface EDUCATION {
        public final static Map<Integer, String> INFO = new HashMap() {
            {
                put(0, "无教育");
                put(10, "小学毕业");
                put(20, "初中毕业");
                put(30, "高中毕业");
                put(40, "专科");
                put(50, "本科");
                put(60, "硕士");
                put(70, "博士");
            }
        };
    }

    public interface SEX {
        public final static Map<Integer, String> INFO = new HashMap() {
            {
                put(1, "男");
                put(2, "女");
                put(3, "未知");
            }
        };
    }

    public interface ERROR {
        public final static String ERROR_00100001 = "无该人员";
        public final static String ERROR_00100002 = "密码错误";
        public final static String ERROR_00100003 = "token过期";
        public final static String ERROR_00100004 = "查询条件不能为空";
    }

    public interface TIME_FORMAT {
        public final static String DATE = "yyyy-MM-dd";
    }

}
