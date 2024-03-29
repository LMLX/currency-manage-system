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
@Table ( value ="manage_department_info" )
public class ManageDepartmentInfoPo  implements Serializable {

	private static final long serialVersionUID =  5034973169181228832L;

	/**
	 * ID主键
	 */
   	@Column(value = "depart_id" )
	private Long departId;

	/**
	 * 部门名称
	 */
   	@Column(value = "depart_name" )
	private String departName;

	/**
	 * 部门名称
	 */
   	@Column(value = "p_depart_id" )
	private Long pDepartId;

	/**
	 * 部门负责人ID
	 */
   	@Column(value = "leader" )
	private Long leader;

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
