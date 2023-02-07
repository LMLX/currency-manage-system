package com.lmlx.app.model.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jiahao jin
 * @Date 2021-03-09 15:04 
 */

@Data
@TableName(value ="manage_user_info" )
public class ManageUserInfoPo  implements Serializable {

	private static final long serialVersionUID =  1286952874912485248L;

	/**
	 * ID主键
	 */
   	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;

	/**
	 * 姓名
	 */
   	@Column(value = "user_name" )
	private String userName;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 身高
	 */
	@Column(value = "height" )
	private Integer height;

	/**
	 * 体重
	 */
	@Column(value = "weight" )
	private Integer weight;

	/**
	 * 生日
	 */
	@Column(value = "birthday" )
	private String birthday;

	/**
	 * 居住省
	 */
	@Column(value = "live_province" )
	private String liveProvince;

	/**
	 * 居住市
	 */
	@Column(value = "live_city" )
	private String liveCity;

	/**
	 * 居住县
	 */
	@Column(value = "live_county" )
	private String liveCounty;

	/**
	 * 居住地址
	 */
	@Column(value = "live_address" )
	private String liveAddress;

	/**
	 * 工作类型
	 */
	@Column(value = "occupation_type_first" )
	private Integer occupationTypeFirst;

	@Column(value = "occupation_type_second" )
	private Integer occupationTypeSecond;

	/**
	 * 工作备注
	 */
	@Column(value = "occupation_mark" )
	private String occupationMark;

	/**
	 * 工作省
	 */
	@Column(value = "work_province" )
	private String workProvince;

	/**
	 * 工作市
	 */
	@Column(value = "work_city" )
	private String workCity;

	/**
	 * 工作县
	 */
	@Column(value = "work_county" )
	private String workCounty;

	/**
	 * 工作地址
	 */
	@Column(value = "work_address" )
	private String workAddress;



	/**
	 * 微信
	 */
	@Column(value = "wechat" )
	private String wechat;

	/**
	 * qq
	 */
	@Column(value = "qq" )
	private String qq;

	/**
	 * 手机号
	 */
	@Column(value = "phone" )
	private String phone;

	/**
	 * 邮箱
	 */
	@Column(value = "e_mail" )
	private String eMail;

	/**
	 * 头像
	 */
	@Column(value = "head_sculpture" )
	private String headSculpture;

	/**
	 * 年薪
	 */
	@Column(value = "salary" )
	private BigDecimal salary;

	/**
	 * 是否已婚
	 */
	@Column(value = "is_married" )
	private Integer isMarried;

	/**
	 * 婚姻备注
	 */
	@Column(value = "married_mark" )
	private String marriedMark;

	/**
	 * 是否独生
	 */
	@Column(value = "is_only" )
	private Boolean isOnly;

	/**
	 * 家庭成员备注
	 */
	@Column(value = "only_mark" )
	private String onlyMark;

	/**
	 * 教育
	 */
	@Column(value = "education" )
	private Integer education;

	/**
	 * 教育备注
	 */
	@Column(value = "education_mark" )
	private String educationMark;

	/**
	 * 意愿
	 */
	@Column(value = "desire" )
	private Integer desire;

	/**
	 * 是否有房
	 */
	@Column(value = "has_house" )
	private Boolean hasHouse;

	/**
	 * 房子备注
	 */
	@Column(value = "house_mark" )
	private String houseMark;

	/**
	 * 是否有车
	 */
	@Column(value = "has_car" )
	private Boolean hasCar;

	/**
	 * 车子备注
	 */
	@Column(value = "car_mark" )
	private String carMark;

	/**
	 * 账号
	 */
   	@Column(value = "account" )
	private String account;

	/**
	 * 密码
	 */
   	@Column(value = "password" )
	private String password;

	/**
	 * 角色ID
	 */
   	@Column(value = "role_id" )
	private Long roleId;

	/**
	 * 最后登录的地址
	 */
   	@Column(value = "last_login_position" )
	private String lastLoginPosition;

	/**
	 * 最后登录的时间
	 */
   	@Column(value = "last_login_time" )
	private Date lastLoginTime;

	/**
	 * 创建人
	 */
   	@Column(value = "creator" )
	private Long creator;

	/**
	 * 创建时间
	 */
   	@Column(value = "create_time" )
	private Date createTime;

	/**
	 * 修改人
	 */
   	@Column(value = "updator" )
	private Long updator;

	/**
	 * 修改时间
	 */
   	@Column(value = "update_time" )
	private Date updateTime;

	private String liveAddressInfo;
	private String workAddressInfo;
	private String mark;
	private String chooseMsg;
}
