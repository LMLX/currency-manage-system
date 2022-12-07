package com.lmlx.app.model.so;

import com.lmlx.app.model.Page;
import com.lmlx.app.system.config.tableInfo.Column;
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
    private String birthdayLow;
    private String birthdayHigh;

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

    private String workProvince;

    private String workCity;

    private String workCounty;

    private String liveProvince;

    private String liveCity;

    private String liveCounty;

    private Long roleId;


}
