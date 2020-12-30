-- create table manage_user_info (
-- 	 user_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
-- 	 user_name varchar(48) COMMENT '姓名',
-- 	 account varchar(16) COMMENT '账号',
-- 	 head_sculpture text COMMENT '头像',
-- 	 address varchar(128) COMMENT '地址',
-- 	 password varchar(48) COMMENT '密码',
-- 	 phone varchar(11) COMMENT '手机号',
-- 	 e_mail varchar(48) COMMENT '邮箱',
--    role_id bigint COMMENT '角色ID',
--    creator bigint COMMENT '创建人',
-- 	 create_time DATETIME COMMENT '创建时间',
-- 	 updator bigint COMMENT '修改人',
-- 	 update_time DATETIME COMMENT '修改时间'
-- ) COMMENT='管理人员信息表';
--
--
-- -- create table manage_department_info (
-- --     depart_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
-- --     depart_name varchar(48) COMMENT '部门名称',
-- --     p_depart_id bigint COMMENT '部门名称',
-- --     leader bigint COMMENT '部门负责人ID',
-- --     creator bigint COMMENT '创建人',
-- -- 	  create_time DATETIME COMMENT '创建时间',
-- -- 	  updator bigint COMMENT '修改人',
-- -- 	  update_time DATETIME COMMENT '修改时间'
-- -- ) COMMENT='部门信息表';
--
-- create table manage_menu_info (
-- 	  menu_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT 'ID主键',
--     icon varchar(128) COMMENT '图标',
--     ident varchar(128) COMMENT '标识',
--     title varchar(128) COMMENT '标题',
--     url varchar(512)  COMMENT '路径',
--     p_id bigint COMMENT '父级ID',
--     rank_id bigint COMMENT '排序'
-- )
--
-- create table manage_role_menu_info (
-- 	  user_id bigint COMMENT '用户ID',
--     menu_id  bigint COMMENT '菜单ID'
-- )


-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: currency-manage-system
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `manage_department_info`
--

DROP TABLE IF EXISTS `manage_department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage_department_info` (
  `depart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `depart_name` varchar(48) DEFAULT NULL COMMENT '部门名称',
  `p_depart_id` bigint(20) DEFAULT NULL COMMENT '部门名称',
  `leader` bigint(20) DEFAULT NULL COMMENT '部门负责人ID',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_department_info`
--

LOCK TABLES `manage_department_info` WRITE;
/*!40000 ALTER TABLE `manage_department_info` DISABLE KEYS */;
INSERT INTO `manage_department_info` VALUES (1,'总部',NULL,NULL,NULL,NULL,NULL,NULL),(2,'部门1',1,NULL,NULL,NULL,NULL,NULL),(3,'部门2',1,NULL,NULL,NULL,NULL,NULL),(4,'部门11',2,NULL,NULL,NULL,NULL,NULL),(5,'部门12',2,NULL,NULL,NULL,NULL,NULL),(6,'部门21',3,NULL,NULL,NULL,NULL,NULL),(7,'部门111',4,NULL,NULL,NULL,NULL,NULL),(8,'部门1111',7,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `manage_department_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage_menu_info`
--

DROP TABLE IF EXISTS `manage_menu_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage_menu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `ident` varchar(128) DEFAULT NULL COMMENT '标识',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `url` varchar(512) DEFAULT NULL COMMENT '路径',
  `p_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `rank_id` bigint(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_menu_info`
--

LOCK TABLES `manage_menu_info` WRITE;
/*!40000 ALTER TABLE `manage_menu_info` DISABLE KEYS */;
INSERT INTO `manage_menu_info` VALUES (1,'el-icon-lx-home','dashboard','系统首页',NULL,0,1),(2,'el-icon-lx-cascades','table','基础表格',NULL,0,2),(3,'el-icon-lx-copy','tabs','tab选项卡',NULL,0,3),(4,'el-icon-lx-calendar','formDropdown','表单相关',NULL,0,4),(5,'','form','基本表单',NULL,4,5),(6,'','editorDropdown','三级菜单',NULL,4,6),(7,'','editor','富文本编辑器',NULL,6,7),(8,'','markdown','markdown编辑器',NULL,6,8),(9,'','upload','文件上传',NULL,4,9),(10,'el-icon-lx-emoji','icon','自定义图标',NULL,0,10),(11,'el-icon-pie-chart','charts','schart图表',NULL,0,11),(12,'el-icon-rank','dragDropdown','拖拽组件',NULL,0,12),(13,'','drag','拖拽列表',NULL,12,13),(14,'','dialog','拖拽弹框',NULL,12,14),(15,'el-icon-lx-global','i18n','国际化功能',NULL,0,15),(16,'el-icon-lx-warn','errorDropdown','错误处理',NULL,0,16),(17,'','permission','权限测试',NULL,16,17),(18,'','404','404页面',NULL,16,18);
/*!40000 ALTER TABLE `manage_menu_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage_role_menu_info`
--

DROP TABLE IF EXISTS `manage_role_menu_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage_role_menu_info` (
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_role_menu_info`
--

LOCK TABLES `manage_role_menu_info` WRITE;
/*!40000 ALTER TABLE `manage_role_menu_info` DISABLE KEYS */;
INSERT INTO `manage_role_menu_info` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18);
/*!40000 ALTER TABLE `manage_role_menu_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage_user_info`
--

DROP TABLE IF EXISTS `manage_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage_user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `user_name` varchar(48) DEFAULT NULL COMMENT '姓名',
  `account` varchar(16) DEFAULT NULL COMMENT '账号',
  `head_sculpture` text COMMENT '头像',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `password` varchar(48) DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `e_mail` varchar(48) DEFAULT NULL COMMENT '邮箱',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理人员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_user_info`
--

LOCK TABLES `manage_user_info` WRITE;
/*!40000 ALTER TABLE `manage_user_info` DISABLE KEYS */;
INSERT INTO `manage_user_info` VALUES (1,'LMLX','admin',NULL,NULL,'21232f297a57a5a743894a0e4a801fc3',NULL,NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `manage_user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-30 16:34:02

