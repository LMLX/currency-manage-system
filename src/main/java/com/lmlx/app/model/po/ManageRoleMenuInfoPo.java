package com.lmlx.app.model.po;

import java.io.Serializable;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;

/**
 * @author jiahao jin
 * @Date 2021-03-09 15:04 
 */

@Data
@Table ( value ="manage_role_menu_info" )
public class ManageRoleMenuInfoPo  implements Serializable {

	private static final long serialVersionUID =  8587927549785015304L;

	/**
	 * 角色ID
	 */
   	@Column(value = "role_id" )
	private Long roleId;

	/**
	 * 菜单ID
	 */
   	@Column(value = "menu_id" )
	private Long menuId;

}
