-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
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
-- Table structure for table `integration_app_info`
--

DROP TABLE IF EXISTS `integration_app_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integration_app_info` (
  `app_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应该ID',
  `app_name` varchar(128) NOT NULL COMMENT '应用名称',
  `app_desc` varchar(256) DEFAULT NULL COMMENT '应用描述',
  `app_dev_host` varchar(256) DEFAULT NULL COMMENT '应用测试端口',
  `app_pro_host` varchar(256) DEFAULT NULL COMMENT '应用生产端口',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integration_app_info`
--

LOCK TABLES `integration_app_info` WRITE;
/*!40000 ALTER TABLE `integration_app_info` DISABLE KEYS */;
INSERT INTO `integration_app_info` VALUES (1,'接口管理平台','接口管理desc','d111d','d9',NULL,'2021-03-09 11:29:12',1,'2021-04-03 12:52:26'),(2,'1','1','1','1',NULL,'2021-04-03 13:15:57',NULL,'2021-04-03 13:15:57'),(3,'1','1','1','1',NULL,'2021-04-03 13:16:57',NULL,'2021-04-03 13:16:57'),(4,'2','2','2','2',NULL,'2021-04-03 13:17:54',NULL,'2021-04-03 13:17:54'),(5,'2','2','2','2',NULL,'2021-04-03 13:18:44',NULL,'2021-04-03 13:18:44'),(6,'2','2','2','4',NULL,'2021-04-03 13:25:04',1,'2021-04-03 13:27:51'),(7,'4','4','4','5',1,'2021-04-03 13:29:49',1,'2021-04-03 13:29:59');
/*!40000 ALTER TABLE `integration_app_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface_detail_info`
--

DROP TABLE IF EXISTS `interface_detail_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interface_detail_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键接口ID',
  `name` varchar(128) NOT NULL COMMENT '接口名称',
  `url` varchar(128) NOT NULL COMMENT '接口地址',
  `model_id` bigint(20) DEFAULT NULL COMMENT '模块ID',
  `interface_desc` varchar(128) DEFAULT NULL COMMENT '接口描述',
  `type` varchar(1) NOT NULL COMMENT '接口类型    1——GET(G)   2——PSOT(P)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface_detail_info`
--

LOCK TABLES `interface_detail_info` WRITE;
/*!40000 ALTER TABLE `interface_detail_info` DISABLE KEYS */;
INSERT INTO `interface_detail_info` VALUES (1,'健康检测','/heakter',1,'健康检测desc','G'),(2,'健康检测1','/EEEE',1,'DDDDD','P');
/*!40000 ALTER TABLE `interface_detail_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface_header_info`
--

DROP TABLE IF EXISTS `interface_header_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interface_header_info` (
  `interface_id` bigint(20) NOT NULL COMMENT '接口ID',
  `name` varchar(64) DEFAULT NULL COMMENT 'header名称',
  `type` varchar(32) DEFAULT NULL COMMENT 'header类型',
  `example` varchar(256) DEFAULT NULL COMMENT 'header值',
  `remake` varchar(256) DEFAULT NULL COMMENT 'header说明'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface_header_info`
--

LOCK TABLES `interface_header_info` WRITE;
/*!40000 ALTER TABLE `interface_header_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `interface_header_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface_model_info`
--

DROP TABLE IF EXISTS `interface_model_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interface_model_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `p_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `name` varchar(128) DEFAULT NULL COMMENT '接口模块名称',
  `app_id` bigint(20) NOT NULL COMMENT '对应的appId',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface_model_info`
--

LOCK TABLES `interface_model_info` WRITE;
/*!40000 ALTER TABLE `interface_model_info` DISABLE KEYS */;
INSERT INTO `interface_model_info` VALUES (1,NULL,'健康检测',1),(2,NULL,'菜单',1),(3,NULL,'人员',1);
/*!40000 ALTER TABLE `interface_model_info` ENABLE KEYS */;
UNLOCK TABLES;

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
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
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
  `component` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT 'name',
  `p_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
  `rank_id` bigint(20) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_menu_info`
--

LOCK TABLES `manage_menu_info` WRITE;
/*!40000 ALTER TABLE `manage_menu_info` DISABLE KEYS */;
INSERT INTO `manage_menu_info` VALUES (1,'el-icon-lx-home','dashboard','系统首页','/dashboard','Dashboard','dashboard',0,1),(2,'el-icon-lx-cascades','table','基础表格','/table','BaseTable','baseTable',0,2),(3,'el-icon-lx-copy','tabs','tab选项卡','/tabs','Tabs','tabs',0,3),(4,'el-icon-lx-calendar','formDropdown','表单相关',NULL,NULL,NULL,0,4),(5,'','form','基本表单','/form','BaseForm','baseForm',4,5),(6,'','editorDropdown','三级菜单',NULL,NULL,NULL,4,6),(7,'','editor','富文本编辑器','/editor','VueEditor','vueEditor',6,7),(8,'','markdown','markdown编辑器','/markdown','Markdown','markdown',6,8),(9,'','upload','文件上传','/upload','Upload','upload',4,9),(10,'el-icon-lx-emoji','icon','自定义图标','/icon','Icon','icon',0,10),(11,'el-icon-pie-chart','charts','schart图表','/charts','BaseCharts','baseCharts',0,11),(12,'el-icon-rank','dragDropdown','拖拽组件',NULL,NULL,NULL,0,12),(13,'','drag','拖拽列表','/drag','DragList','dragList',12,13),(14,'','dialog','拖拽弹框','/dialog','DragDialog','dragDialog',12,14),(15,'el-icon-lx-global','i18n','国际化功能','/i18n','I18n','i18n',0,15),(16,'el-icon-lx-warn','7','错误处理',NULL,NULL,NULL,0,16),(17,'','permission','权限测试','/permission','Permission','permission',16,17),(18,'','404','404页面','/404','404','404',16,18),(19,'','403','403页面','/403','403','403',16,19),(20,'el-icon-lx-cascades','appMenu','应用',NULL,NULL,NULL,0,20),(21,'','app','应用展示','/app','App','app',20,21),(22,'','interfaceDetail','接口详情','/interfaceDetail','InterfaceDetail','interfaceDetail',20,22);
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
INSERT INTO `manage_role_menu_info` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,20),(1,21),(1,22);
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
  `last_login_position` varchar(45) DEFAULT '未知' COMMENT '最后登录的地址',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录的时间',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理人员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_user_info`
--

LOCK TABLES `manage_user_info` WRITE;
/*!40000 ALTER TABLE `manage_user_info` DISABLE KEYS */;
INSERT INTO `manage_user_info` VALUES (1,'LMLX','admin',NULL,'浙江省杭州市西湖区','21232f297a57a5a743894a0e4a801fc3',NULL,NULL,1,'浙江省杭州市','2021-04-24 13:10:41',NULL,NULL,NULL,'2021-04-24 13:10:41'),(2,'ABCD','abcd',NULL,NULL,NULL,NULL,NULL,2,'未知',NULL,NULL,NULL,NULL,NULL),(3,'张三','zs',NULL,NULL,NULL,NULL,NULL,NULL,'未知',NULL,NULL,NULL,NULL,NULL),(4,'李四','ls',NULL,NULL,NULL,NULL,NULL,NULL,'未知',NULL,NULL,NULL,NULL,NULL),(5,'王二','we',NULL,NULL,NULL,NULL,NULL,NULL,'未知',NULL,NULL,NULL,NULL,NULL),(6,'甲丁','jd',NULL,NULL,NULL,NULL,NULL,NULL,'未知',NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2021-04-29 17:01:38
