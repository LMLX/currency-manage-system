create table manage_user_info (
	 user_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
	 user_name varchar(48) COMMENT '姓名',
	 account varchar(16) COMMENT '账号',
	 head_sculpture text COMMENT '头像',
	 address varchar(128) COMMENT '地址',
	 password varchar(48) COMMENT '密码',
	 phone varchar(11) COMMENT '手机号',
	 e_mail varchar(48) COMMENT '邮箱',
   role_id bigint COMMENT '角色ID',
   creator bigint COMMENT '创建人',
	 create_time DATETIME COMMENT '创建时间',
	 updator bigint COMMENT '修改人',
	 update_time DATETIME COMMENT '修改时间'
) COMMENT='管理人员信息表';


-- create table manage_department_info (
--     depart_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
--     depart_name varchar(48) COMMENT '部门名称',
--     p_depart_id bigint COMMENT '部门名称',
--     leader bigint COMMENT '部门负责人ID',
--     creator bigint COMMENT '创建人',
-- 	  create_time DATETIME COMMENT '创建时间',
-- 	  updator bigint COMMENT '修改人',
-- 	  update_time DATETIME COMMENT '修改时间'
-- ) COMMENT='部门信息表';

create table manage_menu_info (
	  menu_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
    icon varchar(128) COMMENT '图标',
    ident varchar(128) COMMENT '标识',
    title varchar(128) COMMENT '标题',
    url varchar(512)  COMMENT '路径',
    p_id bigint COMMENT '父级ID',
    rank_id bigint COMMENT '排序'
)

create table manage_role_menu_info (
	  user_id bigint COMMENT '用户ID',
    menu_id  bigint COMMENT '菜单ID'
)
