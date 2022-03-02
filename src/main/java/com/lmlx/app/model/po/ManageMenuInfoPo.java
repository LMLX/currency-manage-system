package com.lmlx.app.model.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import com.lmlx.app.system.config.tableInfo.Table;
import com.lmlx.app.system.config.tableInfo.Column;

/**
 * @author jiahao jin
 * @Date 2021-04-24 10:37 
 */

@Data
@Table ( value ="manage_menu_info" )
public class ManageMenuInfoPo  implements Serializable {

	private static final long serialVersionUID =  6712566212733421642L;

	/**
	 * ID主键
	 */
   	@TableId(value = "id" )
	private Long id;

	/**
	 * 图标
	 */
   	@Column(value = "icon" )
	private String icon;

	/**
	 * 标识
	 */
   	@Column(value = "ident" )
	private String ident;

	/**
	 * 标题
	 */
   	@Column(value = "title" )
	private String title;

	/**
	 * 路径
	 */
   	@Column(value = "url" )
	private String url;

   	@Column(value = "component" )
	private String component;

	/**
	 * name
	 */
   	@Column(value = "name" )
	private String name;

	/**
	 * 父级ID
	 */
   	@Column(value = "p_id" )
	private Long pId;

	/**
	 * 排序
	 */
   	@Column(value = "rank_id" )
	private Long rankId;

}
