package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;
import java.util.Date;

/**
 * @author jiahao jin
 * @Date 2021-03-09 15:03 
 */

@Data
@Table ( value ="integration_app_info" )
public class IntegrationAppInfoPo  implements Serializable {

	private static final long serialVersionUID =  4398829823330688543L;

	/**
	 * 应该ID
	 */
   	@Column(value = "app_id" )
	private Long appId;

	/**
	 * 应用名称
	 */
   	@Column(value = "app_name" )
	private String appName;

	/**
	 * 应用描述
	 */
   	@Column(value = "app_desc" )
	private String appDesc;

	/**
	 * 应用测试端口
	 */
   	@Column(value = "app_dev_host" )
	private String appDevHost;

	/**
	 * 应用生产端口
	 */
   	@Column(value = "app_pro_host" )
	private String appProHost;

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
