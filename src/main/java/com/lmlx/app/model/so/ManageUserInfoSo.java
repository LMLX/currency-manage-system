package com.lmlx.app.model.so;

import lombok.Data;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-12-25 16:06
 */
@Data
public class ManageUserInfoSo {
    /**
     * ID主键
     */
    private Long userId;

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
    private Integer height;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 居住省
     */
    private String liveProvince;

    /**
     * 居住市
     */
    private String liveCity;

    /**
     * 居住县
     */
    private String liveCounty;

    /**
     * 居住地址
     */
    private String liveAddress;

    /**
     * 工作类型
     */
    private Integer occupationTypeFirst;
    private Integer occupationTypeSecond;

    /**
     * 工作备注
     */
    private String occupationMark;

    /**
     * 工作省
     */
    private String workProvince;

    /**
     * 工作市
     */
    private String workCity;

    /**
     * 工作县
     */
    private String workCounty;

    /**
     * 工作地址
     */
    private String workAddress;

    /**
     * 微信
     */
    private String wechat;

    /**
     * qq
     */
    private String qq;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String eMail;

    /**
     * 头像
     */
    private String headSculpture;

    /**
     * 年薪
     */
    private BigDecimal salary;

    /**
     * 是否已婚
     */
    private Integer isMarried;

    /**
     * 婚姻备注
     */
    private String marriedMark;

    /**
     * 是否独生
     */
    private Boolean isOnly;

    /**
     * 家庭成员备注
     */
    private String onlyMark;

    /**
     * 教育
     */
    private Long education;

    /**
     * 教育备注
     */
    private String educationMark;

    /**
     * 意愿
     */
    private Integer desire;

    /**
     * 是否有房
     */
    private Boolean hasHouse;

    /**
     * 房子备注
     */
    private String houseMark;

    /**
     * 是否有车
     */
    private Boolean hasCar;

    /**
     * 车子备注
     */
    private String carMark;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 最后登录的地址
     */
    private String lastLoginPosition;

    /**
     * 最后登录的时间
     */
    private Date lastLoginTime;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Long updator;

    /**
     * 修改时间
     */
    private Date updateTime;

    private String position;

    private List<ManageUserPhotoInfoSo> fileList;


    private String liveAddressInfo;
    private String workAddressInfo;
    private String mark;
    private String chooseMsg;

}
