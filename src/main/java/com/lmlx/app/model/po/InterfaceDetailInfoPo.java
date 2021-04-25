package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;

/**
 * @author jiahao jin
 * @Date 2021-04-24 11:08 
 */

@Data
@Table ( value ="interface_detail_info" )
public class InterfaceDetailInfoPo  implements Serializable {

	private static final long serialVersionUID =  3697875123133406956L;

	/**
	 * 主键接口ID
	 */
   	@Column(value = "id" )
	private Long id;

	/**
	 * 接口名称
	 */
   	@Column(value = "name" )
	private String name;

	/**
	 * 接口地址
	 */
   	@Column(value = "url" )
	private String url;

	/**
	 * 模块ID
	 */
   	@Column(value = "model_id" )
	private Long modelId;

	/**
	 * 接口描述
	 */
   	@Column(value = "interface_desc" )
	private String interfaceDesc;

	/**
	 * 接口类型    1——GET(G)   2——PSOT(P)
	 */
   	@Column(value = "type" )
	private String type;

}
