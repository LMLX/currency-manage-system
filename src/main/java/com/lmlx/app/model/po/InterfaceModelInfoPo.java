package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;

/**
 * @author jiahao jin
 * @Date 2021-04-24 13:13 
 */

@Data
@Table ( value ="interface_model_info" )
public class InterfaceModelInfoPo  implements Serializable {

	private static final long serialVersionUID =  4545905186228895098L;

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
	 * 对应的appId
	 */
   	@Column(value = "app_id" )
	private Long appId;

}
