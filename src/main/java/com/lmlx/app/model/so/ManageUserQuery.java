package com.lmlx.app.model.so;

import com.lmlx.app.model.Page;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ManageUserQuery extends Page {
    /**
     * 姓名
     */
    private String userName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 身高
     */
    private Integer heightLow;
    private Integer heightHigh;

    /**
     * 体重
     */
    private Integer weightLow;
    private Integer weightHigh;

    /**
     * 生日
     */
    private Date birthdayLow;
    private Date birthdayHigh;

    /**
     * 年薪
     */
    private BigDecimal salaryLow;
    private BigDecimal salaryHigh;

    /**
     * 是否已婚
     */
    private Boolean isMarried;

    /**
     * 教育
     */
    private Long education;

    private Boolean hasHouse;

    private Boolean hasCar;
}
