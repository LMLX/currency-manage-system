package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;
import java.util.Date;

/**
 * @author jiahao jin
 * @Date 2021-06-29 16:31 
 */

@Data
@Table ( value ="interface_model_info" )
public class InterfaceModelInfoPo  implements Serializable {

	private static final long serialVersionUID =  5420105422705942073L;

	/**
	 * 主键ID
	 */
   	@Column(value = "id" )
	private Long id;

	/**
	 * 父级ID
	 */
   	@Column(value = "p_id" )
	private Long pId;

	/**
	 * 接口模块名称
	 */
   	@Column(value = "name" )
	private String name;

	/**
	 * 路径
	 */
   	@Column(value = "url" )
	private String url;

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

	/**
	 * 对应的appId
	 */
   	@Column(value = "app_id" )
	private Long appId;

}
