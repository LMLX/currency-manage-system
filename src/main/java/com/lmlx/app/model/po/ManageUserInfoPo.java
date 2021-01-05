package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;
import java.util.Date;

/**
 * @author jiahao jin
 * @create 2020-12-31 23:37:29 
 */

@Data
@Table ( value ="manage_user_info" )
public class ManageUserInfoPo  implements Serializable {

	private static final long serialVersionUID =  1407263884545010021L;

	/**
	 * ID主键
	 */
   	@Column(value = "user_id" )
	private Long userId;

	/**
	 * 姓名
	 */
   	@Column(value = "user_name" )
	private String userName;

	/**
	 * 账号
	 */
   	@Column(value = "account" )
	private String account;

	/**
	 * 头像
	 */
   	@Column(value = "head_sculpture" )
	private String headSculpture;

	/**
	 * 地址
	 */
   	@Column(value = "address" )
	private String address;

	/**
	 * 密码
	 */
   	@Column(value = "password" )
	private String password;

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

}
