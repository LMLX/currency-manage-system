-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: currency-manage-system
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `camera_info`
--

DROP TABLE IF EXISTS `camera_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camera_info` (
                               `camera_index_code` varchar(32) DEFAULT NULL,
                               `name` varchar(128) DEFAULT NULL,
                               `longitude` varchar(32) DEFAULT NULL,
                               `latitude` varchar(32) DEFAULT NULL,
                               `preview_url` varchar(128) DEFAULT NULL,
                               `region_index_code` varchar(128) DEFAULT NULL,
                               `create_time` datetime DEFAULT NULL,
                               `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera_info`
--

LOCK TABLES `camera_info` WRITE;
/*!40000 ALTER TABLE `camera_info` DISABLE KEYS */;
INSERT INTO `camera_info` VALUES ('dffbc980cb8642bfa9c5be9bf504a956','安途汽车生活馆（大洋北路15号-球','119.913481','28.477544','rtsp://172.28.34.226:554/openUrl/D0Vyo7K','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 16:45:54','2021-04-16 10:22:44'),('8b096f33196c4233b13740e20b904ae0','白云路51号邮政储蓄银行西侧-球','119.944097','28.462163','rtsp://172.28.34.226:554/openUrl/laX8FVu','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-12 10:28:20','2021-04-16 10:33:05'),('9b2a4cd715924747befad11a8c628d15','白云路与丽阳街交叉口 -球','119.912302','28.459397','rtsp://172.28.34.226:554/openUrl/CIGY52M','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:35:21','2021-04-16 10:36:48'),('549ae75f1a454bd8896dfeb4dc252e47','白云路中国移动机遇数码门口-球','119.912234','28.460374','rtsp://172.28.34.226:554/openUrl/CPHPyjC','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:36:26','2021-04-16 10:38:49'),('f85f605e86ab4697a0fca2e72571f60b','北郭桥弄98号白云幼儿园对面-球','119.911214','28.463769','rtsp://172.28.34.226:554/openUrl/COWqxAQ','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:38:12','2021-04-16 10:38:13'),('0c051a45d7eb4bccb8ae57c4714af247','北苑路与花园路交叉口东北侧-球','119.915396','28.47007','rtsp://172.28.34.226:554/openUrl/kEBr2PC','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-14 15:09:20','2021-04-16 10:45:33'),('f9870148d6f84733b0c5cf890cca8105','城东路生源粮油经营部-球','119.913859','28.450824','rtsp://172.28.34.226:554/openUrl/CH6bFMk','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-07 08:59:07','2021-04-16 10:42:22'),('5b8ac96e5fb64ce8ab74f55baceaa997','城西路189号-球','119.906617','28.453007','rtsp://172.28.34.226:554/openUrl/ktYksNO','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-14 17:21:55','2021-04-16 10:35:05'),('084774ba75bc423181483e444efae6ad','处州府城木牌楼正南门对面-球','119.913859','28.439703','rtsp://172.28.34.226:554/openUrl/CGCFofC','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-07 09:03:12','2021-04-16 10:42:01'),('6e4543d59f0d4a1aa1dd902f42a204bd','大润发宇雷北路大渝火锅店门口-球','119.921337','28.45555','rtsp://172.28.34.226:554/openUrl/nvCjPY4','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-07 15:51:57','2021-04-16 10:48:33'),('a280c95c570549c7b0dc6676f1b35521','大洋(北)路653号门口-球','119.912968','28.467206','rtsp://172.28.34.226:554/openUrl/CHVhtbW','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:43:12','2021-04-16 10:36:29'),('c8900bd0504a4c1bb8d80d2623b7aacc','大洋北路527号门口-球','119.912508','28.469846','rtsp://172.28.34.226:554/openUrl/CUeyPXq','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:22:02','2021-04-16 10:39:46'),('cd60c58263614bd48f0cdf13b1b5205d','大洋北路79号-球','119.912897','28.475873','rtsp://172.28.34.226:554/openUrl/CWLx0T6','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:21:07','2021-04-16 10:41:39'),('2a9cc1c705bb43d8bb43ce3aad046e1b','大洋北路接官亭小区东北门北侧-球','119.912613','28.468553','rtsp://172.28.34.226:554/openUrl/CRlalKE','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:41:45','2021-04-16 10:39:27'),('200d30ce51fb4fad8caf538a37f16a90','大洋北路与绿洲街交叉口-球','119.913301','28.468138','rtsp://172.28.34.226:554/openUrl/CSwY3zq','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:14:15','2021-04-16 10:52:39'),('3483b8c7328d4a30a236f9d1f1e58e6d','大洋路113号大洋路小学东门北侧-球','119.913707','28.463968','rtsp://172.28.34.226:554/openUrl/jlPHK5q','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-06-02 10:47:43','2021-04-16 10:23:49'),('55c86b58354741f3aedb82c8685cd6d8','大洋路208号庆元油菜火锅门口-球','119.914847','28.459475','rtsp://172.28.34.226:554/openUrl/jtiFveE','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-27 17:19:38','2021-04-16 10:42:20'),('a67aeae8763644a78a9164c4d8e510fb','大洋路小学南侧治安杆-球','119.913183','28.462814','rtsp://172.28.34.226:554/openUrl/krtltMA','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-15 10:19:49','2021-04-16 10:29:22'),('865874c9ea704379aaf8eecdba171c23','大洋路与华敦街交叉口-球','119.91615','28.447549','rtsp://172.28.34.226:554/openUrl/CIjGYnu','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:34:33','2021-04-16 10:35:59'),('9b7a9d6d21174100983802b9ce5590a8','大猷街（少年宫门口）-球','119.922404','28.439731','rtsp://172.28.34.226:554/openUrl/lw0ii08','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-09 16:12:53','2021-04-16 10:33:04'),('bb1b392524874577864cf05a36a4d191','大猷街17号广州证券门口-球','119.908883','28.442048','rtsp://172.28.34.226:554/openUrl/CG8RvAQ','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-07 09:01:04','2021-04-16 10:41:38'),('cbe91461818841e0a8c3eb9fdaba83cb','大众街133号-球','119.911558','28.447788','rtsp://172.28.34.226:554/openUrl/knoIu1a','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-15 15:52:21','2021-04-16 10:34:27'),('bd53451970a64ef28a6751976a4218ab','灯塔街272号宏翔印章广告-球','119.914102','28.455804','rtsp://172.28.34.226:554/openUrl/louM8Gk','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-10 15:28:14','2021-04-16 10:36:47'),('37aedaa877894446bd42020ae05371b6','灯塔街30号亿果鲜门口-球','119.90252','28.454783','rtsp://172.28.34.226:554/openUrl/lQwO27m','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 11:21:27','2021-04-16 10:38:28'),('cf2c265a74de49c9bc3c0919b54cad8f','灯塔小区70幢金家乐超市门口-球','119.904913','28.460844','rtsp://172.28.34.226:554/openUrl/CQvvm4U','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:40:55','2021-04-16 10:39:06'),('b817b648b93d471b87289df4cc67cfeb','灯塔小区庆春街邱则英副食门口-球','119.906427','28.460825','rtsp://172.28.34.226:554/openUrl/CL1rUfC','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:40:07','2021-04-16 10:37:30'),('65c85fc71d30400db2199fe14c6e835c','凤凰路桥边（中医院停车库旁）-球','119.901999','28.454842','rtsp://172.28.34.226:554/openUrl/lQ6GW9q','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 11:20:52','2021-04-16 10:38:09'),('e5f3de3b3a4f4b46b9f3bead1d336700','公安局莲都大队交通警察支队南-球','119.914159','28.463141','rtsp://172.28.34.226:554/openUrl/lpjAkXS','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-10 10:48:29','2021-04-16 10:46:02'),('67e536ab65a34ec8907eefda7c79a64b','古城路与解放街交叉口如家置业-球','119.930772','28.450284','rtsp://172.28.34.226:554/openUrl/CO9BxdK','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:29:58','2021-04-16 10:37:38'),('7fe81a8cbe474490ad62395879427725','和平路厦河二区入口处东侧-球','119.933479','28.448935','rtsp://172.28.34.226:554/openUrl/CJ4wMQ8','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:30:54','2021-04-16 10:36:27'),('d463032f12a64b15a3d9dbe2520e68e3','后庆街171号安信电子对面交警杆-球','119.905808','28.462294','rtsp://172.28.34.226:554/openUrl/kYCIUDK','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-13 14:47:32','2021-04-16 10:32:42'),('3c8a64cfe0b344c19c810e2067d459f2','后庆路168号芬芬烟酒门口-球','119.905799','28.460923','rtsp://172.28.34.226:554/openUrl/jYjuglG','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-22 14:15:23','2021-04-16 10:29:02'),('a2d1f6d9f0bd4a06919aea3ad0402d18','后庆路92号丽旺房产对面治安杆-球','119.905731','28.459285','rtsp://172.28.34.226:554/openUrl/kWLLmXC','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-13 14:48:22','2021-04-16 10:31:08'),('209c1a95145146c7920e2624f4964217','华敦街40号包笼天下门口-球','119.921574','28.448114','rtsp://172.28.34.226:554/openUrl/jKc5lcI','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-25 14:48:20','2021-04-16 10:25:27'),('a7b13afb7cbc4e998e3229b0845a885f','华敦街大洋河小区411幢东侧-球','119.9183','28.447933','rtsp://172.28.34.226:554/openUrl/CVViOXe','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:23:08','2021-04-16 10:49:05'),('b75c989d484141ab93bc73c07f72015d','继光街218号门口-球','119.911056','28.451804','rtsp://172.28.34.226:554/openUrl/lwLYTQY','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 15:45:17','2021-04-16 10:37:27'),('7b10db11e3dd467ea3d25667123c0c73','继光街-300号门口-球','119.913441','28.451089','rtsp://172.28.34.226:554/openUrl/jReEpfW','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-23 13:10:36','2021-04-16 10:33:11'),('8b288f87fbff4788abe20dfe4259b4a9','解放街288-13号门口-球','119.917038','28.449858','rtsp://172.28.34.226:554/openUrl/jut3dp6','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-27 15:53:36','2021-04-16 10:24:09'),('27f1b58c15a44ee994efe6a96fa21681','解放街316号门口-球','119.918491','28.449986','rtsp://172.28.34.226:554/openUrl/CT0LWec','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:12:15','2021-04-16 10:52:11'),('d7644f0cb85a44e68d8a411a075df1fc','解放街428号-球','119.921741','28.450246','rtsp://172.28.34.226:554/openUrl/D1jXTji','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 16:19:58','2021-04-16 10:38:16'),('165bc53a2ba641c3ae758a505b67eab7','解放街526号-球','119.924043','28.450199','rtsp://172.28.34.226:554/openUrl/kvWFzRC','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-14 15:40:35','2021-04-16 10:27:37'),('d752107b28d5485b86af82ea1424cbd1','解放街543号门口-球','119.927086','28.450192','rtsp://172.28.34.226:554/openUrl/jnnmyVa','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-06-02 10:08:49','2021-04-16 10:22:49'),('f9796f9056ab41d39d858e5938c3f276','解放街562号门口-球','119.925085','28.450231','rtsp://172.28.34.226:554/openUrl/jI9LQk0','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-26 11:38:12','2021-04-16 10:24:36'),('af072e7199f24852af38922aca64133f','解放街565号门口-球','119.927648','28.450357','rtsp://172.28.34.226:554/openUrl/CWmgIjm','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:17:27','2021-04-16 10:53:29'),('858e1d88d3a64018bea09576238229e8','解放街611号泰隆银行门口治安杆-球','119.928759','28.450577','rtsp://172.28.34.226:554/openUrl/kUkKLLi','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 15:53:21','2021-04-16 10:28:35'),('bf4200f8276c41c1aa66bb10e3adad7b','解放街飞达国际大酒店门口-球','119.931414','28.451709','rtsp://172.28.34.226:554/openUrl/ktAcyKk','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-14 16:25:08','2021-04-16 10:26:59'),('9cd055640d63458baf0511696f945abb','金苑新村南门口西侧-球','119.921498','28.450383','rtsp://172.28.34.226:554/openUrl/CV0OE4o','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:11:16','2021-04-16 10:50:38'),('e28f3a4062af407595fd3582534ddfda','括苍路330号龙泉快餐门口-球','119.90452','28.452877','rtsp://172.28.34.226:554/openUrl/lQU58ME','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 11:21:41','2021-04-16 10:38:49'),('118d1c09ff424eacbb34ab30f44005a5','括苍路世茂璀璨江山展厅门口-球','119.903827','28.456907','rtsp://172.28.34.226:554/openUrl/kpt1aOk','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-15 15:16:01','2021-04-16 10:34:47'),('f3faf052e2ba4380b6f244295e1ae70e','括苍路与人民街交叉口东南角-球','119.903365','28.462383','rtsp://172.28.34.226:554/openUrl/CPkyrEk','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:44:09','2021-04-16 10:38:31'),('8ebb12dfd2e245c9971d88839cee0c20','括苍职业安全技术培训中学对面-球','119.903604','28.458638','rtsp://172.28.34.226:554/openUrl/lxc5ZOU','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-09 15:45:39','2021-04-16 10:33:25'),('73441af236634299b5131f03721eb1bf','丽青路137-12号伟发门窗门口-球','119.921345','28.456042','rtsp://172.28.34.226:554/openUrl/jG04M3C','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-26 15:34:16','2021-04-16 10:42:45'),('f9bd26cdea0f40fab10dd1d50d311f3c','丽青路222号家好门窗门口-球','119.924556','28.455179','rtsp://172.28.34.226:554/openUrl/kV69Mu4','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 15:07:40','2021-04-16 10:29:02'),('861fbcbd3dfb4f049e9cc5ce12bf3d2d','丽青路582号门口（缙云烧饼）-球','119.933713','28.453123','rtsp://172.28.34.226:554/openUrl/kYgAcuI','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 14:44:56','2021-04-16 10:42:29'),('ce80b480b48d41faaf176ddbdff2feb8','丽水市第二人民医院门口-球','119.911542','28.462445','rtsp://172.28.34.226:554/openUrl/CJu4GxW','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:37:24','2021-04-16 10:37:08'),('1f531f5fd94c4e089590629edbbadb6d','丽水市人民政府南门东侧治安杆-球','119.918874','28.47029','rtsp://172.28.34.226:554/openUrl/CMTgfjW','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:27:52','2021-04-16 10:50:38'),('82921ed9597244128f7900e611564659','丽水体育场西门对面治安杆-球','119.921007','28.470431','rtsp://172.28.34.226:554/openUrl/CQ5FRf2','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:47:26','2021-04-16 10:51:21'),('06d7129665ec44ed9eaf8adb62077664','丽水图书馆东门治安杆-球','119.919855','28.468263','rtsp://172.28.34.226:554/openUrl/kp2U4Qo','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-15 15:13:57','2021-04-16 10:44:34'),('364127a0919948bab06c62c23a233368','丽阳街116号','119.901156','28.455764','rtsp://172.28.34.226:554/openUrl/lPJpPu8','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 11:25:09','2021-04-16 10:37:51'),('5448e701fc6a42a086e05ce74b37ea0f','丽阳街274号-球','119.905371','28.45694','rtsp://172.28.34.226:554/openUrl/jJ18qM8','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-26 09:21:39','2021-04-16 10:31:34'),('c7d10988a796478a8696efaab4309389','丽阳街323号庆嵩香烟副食门口-球','119.905728','28.457317','rtsp://172.28.34.226:554/openUrl/jKD3eyQ','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-25 14:47:16','2021-04-16 10:24:19'),('e510efc6ff604418b0f9989a880cc278','丽阳街334号-球','119.906617','28.457181','rtsp://172.28.34.226:554/openUrl/jL8Qj84','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-23 15:34:01','2021-04-16 10:31:55'),('16950db7d0204469a6892100a6231b42','莲都剧院门口-球','119.925848','28.450449','rtsp://172.28.34.226:554/openUrl/jeu7yjS','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-06-10 09:15:30','2021-04-16 10:21:26'),('b3a551eb09884fbab393f350f2ad105d','莲都区农商行门口交警杆-球','119.926466','28.452865','rtsp://172.28.34.226:554/openUrl/jn05sfS','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-06-02 10:13:46','2021-04-16 10:22:24'),('613db2b697434370bc0d9d6560cf0d5d','莲都区人民法院东门南侧治安杆-球','119.903309','28.459565','rtsp://172.28.34.226:554/openUrl/kXwSMyk','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-13 14:48:47','2021-04-16 10:31:32'),('adc32f30e1a144ff86b2f763f3c07b76','刘英学校卢镗街入口处治安杆-球','119.928092','28.443388','rtsp://172.28.34.226:554/openUrl/CJWKaGs','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:31:55','2021-04-16 10:37:13'),('76c966ab05954399bb782d3196300c02','卢镗街-仓前菜场南门-球','119.908342','28.445903','rtsp://172.28.34.226:554/openUrl/jQ0ijgA','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-23 13:33:22','2021-04-16 10:32:50'),('327bdda866e1480d85b42dfcfd212172','罗马步行街(东边)-球','119.909875','28.457219','rtsp://172.28.34.226:554/openUrl/k28MV5C','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-21 17:36:51','2021-04-16 10:33:37'),('c479ab1c39d74abe87b58e6cb6b406db','罗马步行街(西边)-球','119.909875','28.457219','rtsp://172.28.34.226:554/openUrl/lRDMyJ2','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:23:10','2021-04-16 10:39:42'),('62c923fe5b174b5498aae8e8a576a0c0','宁和苑南门东侧-球','119.918611','28.475793','rtsp://172.28.34.226:554/openUrl/D56qyKA','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 15:50:11','2020-05-22 14:28:58'),('e355937016514316bc45dc10d8b5f071','纽斯SPA店门口花坛内-球','119.91852','28.462638','rtsp://172.28.34.226:554/openUrl/maeNb56','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-09 09:10:55','2021-04-16 10:47:00'),('cfbb1dc25d584886ad6edbe8a47560b0','青田街与解放街交叉口交警杆-球','119.927434','28.450245','rtsp://172.28.34.226:554/openUrl/lxxX6PS','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-09 15:44:38','2021-04-16 10:34:02'),('780a85355d9a4283b02cb54ae9b10924','清远街老艺人月饼店门口治安杆-球','119.914019','28.475361','rtsp://172.28.34.226:554/openUrl/nraYVNu','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-08 11:26:53','2021-04-16 10:48:14'),('d185af44e0ae4411a51dac324c0a217d','清远街与北苑路交叉口丁字口','119.915336','28.474831','rtsp://172.28.34.226:554/openUrl/CNke8G4','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:25:30','2021-04-16 10:51:02'),('45d504ebb60c4aa4869c4aa5cb7ec2e2','庆春街与括苍路交叉口治安杆-球','119.903435','28.460901','rtsp://172.28.34.226:554/openUrl/nrXwl2w','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-08 11:26:19','2021-04-16 10:35:23'),('f8f9e1c6975e45d38eefe27ab72605f8','人民街379号旁中国邮政银行门口-球','119.911827','28.465323','rtsp://172.28.34.226:554/openUrl/ntIwiZi','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-07 16:56:00','2021-04-16 10:35:49'),('b2bbfb4bba754373827d11a0b89b85e2','人民街558号嘉诚信息咨询门口-球','119.914257','28.465805','rtsp://172.28.34.226:554/openUrl/D1InouQ','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 16:05:16','2021-04-16 10:53:16'),('cadefe7aae8a4da588a4fb736c9b90ab','人民街600号门口治安杆44023号-球','119.915981','28.466175','rtsp://172.28.34.226:554/openUrl/CS9GWU8','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:24:07','2021-04-16 10:52:20'),('4efb108f957448068fd3ef6da1a1c349','人民街692号炭火牛肉酒场门口-球','119.921731','28.468082','rtsp://172.28.34.226:554/openUrl/CQXk2Pe','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:46:28','2021-04-16 10:51:41'),('cea09a7a6ecd424b897acd4ff8810235','人民街与白云路路口绿江南门口-球','119.910748','28.464727','rtsp://172.28.34.226:554/openUrl/CNIDDRC','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-06 19:39:04','2021-04-16 10:37:52'),('ae8257b6c9134ad1bb9d4ad121772ba5','人民街与大洋路交叉口西北角-球','119.913191','28.465866','rtsp://172.28.34.226:554/openUrl/jIAaxq0','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-26 09:21:17','2021-04-16 10:43:05'),('f352c36128fe4e23b8465a19ee3c709f','人民路166号垃圾转运站门口-球','119.907187','28.463618','rtsp://172.28.34.226:554/openUrl/np1R3Ne','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-08 15:34:19','2021-04-16 10:34:07'),('e49356192ea84b928a91a6c7cc65db40','三岩寺路96号中国兰州拉面-球','119.899463','28.458332','rtsp://172.28.34.226:554/openUrl/nqL9qXC','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-08 11:25:55','2021-04-16 10:34:26'),('82b66ad6ed314fc783bf5cda49328a98','三岩寺路中国建设银行门口-球','119.899313','28.458692','rtsp://172.28.34.226:554/openUrl/nrAfene','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-08 11:26:35','2021-04-16 10:34:51'),('e657107a81f34adc8b02b71f77e64a08','厦河路9号宝驰汽车维修店-球','119.931023','28.446892','rtsp://172.28.34.226:554/openUrl/lwpyAzS','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-09 16:12:02','2021-04-16 10:33:34'),('821d7d906ce74c65b4768270d18d4803','厦河路江滨小区门口南侧治安杆-球','119.931542','28.446212','rtsp://172.28.34.226:554/openUrl/jJP5PFu','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-25 14:47:56','2021-04-16 10:25:03'),('745a969eeaa14b5cb57629d2744ff10c','厦河一区古城路入口南侧-球','119.931912','28.449038','rtsp://172.28.34.226:554/openUrl/CVukVB6','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:16:25','2021-04-16 10:49:52'),('3d4a52e9fb1641e0bd4bc79c2b03befb','世纪联华灯塔街店东侧河边电杆-球','119.907197','28.46829','rtsp://172.28.34.226:554/openUrl/kVvZhjW','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-13 14:47:52','2021-04-16 10:30:48'),('9ec5cb92ec914e21809ce0dc58828be6','市博物馆门口（大猷街)-球','119.918585','28.439703','rtsp://172.28.34.226:554/openUrl/CXuWPHq','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:08:37','2021-04-16 10:41:39'),('05df354e7769487a9544bc71047a42be','寿尔福路城东小区西门治安杆-球','119.929025','28.445127','rtsp://172.28.34.226:554/openUrl/COyRPNu','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:33:47','2021-04-16 10:52:41'),('1bb0ce267eb34db5b789cf5458f953fa','寿尔福路-维康大药房门-球','119.928767','28.449987','rtsp://172.28.34.226:554/openUrl/jQph0Ig','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-23 13:24:29','2021-04-16 10:47:22'),('d827675e08d64313925964133f238e25','寿尔福路-沃凯龙购物中心门口-球','119.928921','28.452068','rtsp://172.28.34.226:554/openUrl/jQOxji0','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-23 13:18:24','2021-04-16 10:25:52'),('055c894e48eb4910bfae0189d52334f4','寿尔福路与华敦街交叉口南侧-球','119.928676','28.447802','rtsp://172.28.34.226:554/openUrl/joA1488','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-29 15:13:12','2021-04-16 10:23:18'),('acf1f1e323b642d8ad58d16b32dc04b8','寿尔福路与万丰北路交叉口-球','119.92851','28.453455','rtsp://172.28.34.226:554/openUrl/kEZyWT6','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-14 15:06:22','2021-04-16 10:28:08'),('af4a111f9f954093be2610ae30f586c0','寿元街与紫金北路交叉口西北角','119.925644','28.461182','rtsp://172.28.34.226:554/openUrl/m9POtDq','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-09 09:10:13','2021-04-16 10:46:26'),('18dd0876d8bb42418cc56689b2fda2f9','水南桥南桥头三角隔离带内-球','119.900986','28.441302','rtsp://172.28.34.226:554/openUrl/jlpSffy','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-06-02 11:33:09','2021-04-16 10:30:23'),('50148cc309b344018ea54136eb9a5190','天宁街世纪华联超市东侧岔路口-球','119.921798','28.474888','rtsp://172.28.34.226:554/openUrl/CMtqKu4','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:28:51','2021-04-16 10:50:13'),('e51413163a394ef2a00f378fb2684d3b','万地广场大润发宇雷北路入口-球','119.921464','28.464506','rtsp://172.28.34.226:554/openUrl/CLvOZaw','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:45:23','2021-04-16 10:49:40'),('28e3d1fb6f564c1db5afc5f28f7e54ba','万地广场西南侧王道友金楼门口-球','119.919098','28.464391','rtsp://172.28.34.226:554/openUrl/CHvrYm4','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-07 09:11:15','2021-04-16 10:49:12'),('1b272ca3fc464fcb8b4a439cc9181ae5','温馨园12幢15号（简生堂门口）-球','119.916649','28.465016','rtsp://172.28.34.226:554/openUrl/CRMZ2uY','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:15:25','2021-04-16 10:52:03'),('fb1cc656f87142c08afc854d6f723a3e','文进街58号便民服务中心对面-球','119.901261','28.460187','rtsp://172.28.34.226:554/openUrl/kUKiFt6','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-13 15:20:17','2021-04-16 10:30:07'),('f59c6d3b060f44269f12e7d99740f97c','文进街肯德基门口治安杆34004-球','119.899502','28.460068','rtsp://172.28.34.226:554/openUrl/noCALdu','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-05-08 15:33:57','2021-04-16 10:33:45'),('7fbaa0611ac04bf29c53cfcb2c2c29fd','西班牙美食店门口治安杆-qiu','119.918179','28.465603','rtsp://172.28.34.226:554/openUrl/maA55PW','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-09 09:10:39','2021-04-16 10:47:28'),('940485c32e4c4dcab5b3807ffee3e6b3','西城美食广场学院入口南治安杆(球)','119.899319','28.459201','rtsp://172.28.34.226:554/openUrl/jiysWXe','126f1b6f-9bdc-4d88-a092-45965cdff295','2020-06-09 11:28:29','2021-04-16 10:23:18'),('7092805d7252452a834a83cc0e7f08e4','欣苑小区西门南侧(球)','119.912498','28.472102','rtsp://172.28.34.226:554/openUrl/D3Sm3Ti','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 15:59:35','2021-04-16 10:53:50'),('6421d189cfbb4773938d257ee3e9b306','兴业大厦花园路422号-球','119.919887','28.455972','rtsp://172.28.34.226:554/openUrl/CZYNqco','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 17:27:42','2021-04-16 10:38:40'),('beede2684a164f39b79c77d0e24614e8','囿山路313号-球','119.919261','28.446817','rtsp://172.28.34.226:554/openUrl/je3IRdS','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-06-10 09:15:12','2021-04-16 10:20:56'),('1c0e852df81846d8ada0d2d259a328a9','囿山路426号（怡景花苑北门）-球','119.922029','28.446893','rtsp://172.28.34.226:554/openUrl/npVcQ9O','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-08 15:26:05','2021-04-16 10:35:30'),('16117cb578ba44859e1eb2cc18d50742','囿山小学公交站西侧-球','119.914565','28.445838','rtsp://172.28.34.226:554/openUrl/D0rsUkU','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-06 17:19:10','2021-04-16 10:42:40'),('f914f1fb503243308e02cafea8a713ef','宇雷北路38号凌记小厨门口-球','119.920521','28.473728','rtsp://172.28.34.226:554/openUrl/jJo7Wjm','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-26 09:16:09','2021-04-16 10:43:24'),('13e037a4799141fe87ad0d95fbc4aef2','宇雷路101号-球','119.922307','28.459653','rtsp://172.28.34.226:554/openUrl/nw2qVW0','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-07 15:43:47','2021-04-16 10:48:50'),('b708eac7045947aea727882c5e0f3d4c','宇雷路329号对面-球','119.922934','28.454636','rtsp://172.28.34.226:554/openUrl/CZAnV0Q','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 18:57:13','2021-04-16 10:39:09'),('d357a4c66df948b3b29c8672dc047003','宇雷路451号南侧-球','119.922913','28.451183','rtsp://172.28.34.226:554/openUrl/npsOX9m','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-08 15:26:30','2021-04-16 10:34:57'),('d889d9c11265407eafd838363d148246','宇雷路619号-球','119.923225','28.442938','rtsp://172.28.34.226:554/openUrl/nod2RvG','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-08 15:35:05','2021-04-16 10:34:32'),('fb52f5653b784bc389ec9138589178c1','宇雷路和囿山路路口.梭梭家水果-球','119.923285','28.446821','rtsp://172.28.34.226:554/openUrl/ji7MEJa','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-06-09 11:28:04','2021-04-16 10:21:59'),('88899cb654674e139c4f5659bbfee880','宇雷路她寻果品店对面-球','119.92278','28.457503','rtsp://172.28.34.226:554/openUrl/CUBgKmA','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-06 19:13:12','2021-04-16 10:52:58'),('5b5066f1fae84da19010a753c6023440','宇雷路与卢镗街交叉口.5410店门-球','119.923274','28.44279','rtsp://172.28.34.226:554/openUrl/kVTxZ7i','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 14:45:46','2021-04-16 10:29:52'),('726d46a280e34aab894c6f8853e2c3e1','长虹街13号万来烟酒店门口-球','119.92012','28.458122','rtsp://172.28.34.226:554/openUrl/koD4A0w','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-15 15:11:15','2021-04-16 10:44:10'),('5c9883426d2743239ff795afcf2f8bd4','中东路12号（幸福超市看对面）-球','119.912559','28.452185','rtsp://172.28.34.226:554/openUrl/kE9kKXe','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-14 15:06:49','2021-04-16 10:35:25'),('fdcda4638be541edbd96f4d2834b7c4e','中东路19号与城东路交叉口-球','119.913761','28.452231','rtsp://172.28.34.226:554/openUrl/loSkQtG','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-10 10:55:18','2021-04-16 10:37:08'),('4be32131cba14de0809ac44304716f77','中东路244号绿江南果品店-球','119.916938','28.452388','rtsp://172.28.34.226:554/openUrl/CZbYpPi','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:00:25','2021-04-16 10:39:42'),('177e12b23e744987bfa083003f6559e4','中东路334号叮当猫门口-球','119.918266','28.452593','rtsp://172.28.34.226:554/openUrl/CYJAwOQ','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:02:50','2021-04-16 10:40:16'),('5c0dbcd9afec40a8a4eb173b26008718','中东路422号-球','119.92027','28.452701','rtsp://172.28.34.226:554/openUrl/CYhLQ4w','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:04:13','2021-04-16 10:40:42'),('3b8dc6d0796a46fabf079274267f9d39','中东路482-1号-球','119.924986','28.452952','rtsp://172.28.34.226:554/openUrl/CXVlwNq','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:05:41','2021-04-16 10:41:09'),('0b22e9fcad284afdadc50ebfbccf6f92','中东路588号门口-球','119.924240','28.452634','rtsp://172.28.34.226:554/openUrl/CX8eVig','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:07:20','2021-04-16 10:54:00'),('f4fdde1496aa4cdcb5dba30ff05c0fa2','中东路708号邮政储蓄银行门口-球','119.927561','28.452571','rtsp://172.28.34.226:554/openUrl/kqdzo8U','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-15 15:17:57','2021-04-16 10:26:18'),('5eb19c5323e640c09affa9ee959e62c7','中东路花园路交叉口(建行门口）-球','119.919868','28.452507','rtsp://172.28.34.226:554/openUrl/CTOrJZu','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:18:22','2021-04-16 10:51:08'),('a64de18cd76f42df8abef7d95996dea0','中山街433-1号奥康店门口-球','119.909188','28.455323','rtsp://172.28.34.226:554/openUrl/lSoCnbG','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:22:05','2021-04-16 10:40:23'),('43a433b17e384fa098c3a603bd117474','中山街465号美特斯邦威门口-球','119.909323','28.453585','rtsp://172.28.34.226:554/openUrl/lTaAAaA','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:22:27','2021-04-16 10:41:18'),('78e758b42be940b8b6a7c3ee8bfca4dd','中山街525号汉鼎宇佑影院门口-球','119.909381','28.451209','rtsp://172.28.34.226:554/openUrl/jGsb3W0','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-26 15:31:58','2021-04-16 10:30:59'),('e14d0d1e63b64313ad21ecb1394dcc54','中山街631号门口-球','119.909767','28.448039','rtsp://172.28.34.226:554/openUrl/lS0ut8c','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:22:49','2021-04-16 10:40:03'),('ac97e49ebd704302a2735cd0ab20c667','中山街与继光街交叉口东北侧-球','119.909506','28.452394','rtsp://172.28.34.226:554/openUrl/jNFwSVG','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-23 14:34:51','2021-04-16 10:32:29'),('964f31d1b80a4208b4ab3e84fd561172','中山街与解放街交叉口西南侧-球','119.909595','28.449274','rtsp://172.28.34.226:554/openUrl/lSMsG76','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:21:45','2021-04-16 10:40:58'),('6be10d65c3144d1f83836fc6beb06cee','中山街与卢镗街交叉口西北侧-球','119.909462','28.444897','rtsp://172.28.34.226:554/openUrl/k2UtwWs','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-21 14:46:14','2021-04-16 10:34:05'),('d2ae5c418d96478c8c553743e53fdf50','中山街与囿山路交叉口西南侧-球','119.909817','28.446042','rtsp://172.28.34.226:554/openUrl/lRhmfrW','6eb12f7a-6b9f-4e97-ac24-229a77e53b1d','2020-05-09 10:25:53','2021-04-16 10:39:15'),('6176446c9e3242009cc2b8c9bff6a9dd','紫金北路131号易趣教育门口-球','119.924995','28.46845','rtsp://172.28.34.226:554/openUrl/kpQ0Gly','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-15 15:12:23','2021-04-16 10:45:10'),('e42e2dacaf284b568c56ca0662285d8f','紫金北路85号市体育中心东门-球','119.924717','28.470972','rtsp://172.28.34.226:554/openUrl/nqljW7K','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-08 15:25:40','2021-04-16 10:47:48'),('7ad06f8e389848d485343d5a2146e05b','紫金北路与天宁街交叉口西北角-球','119.923695','28.475206','rtsp://172.28.34.226:554/openUrl/jS3sBxu','35bd1d3e-f2f3-4692-a6d2-5d9715e499aa','2020-05-23 08:41:47','2021-04-16 10:43:47'),('23ff6d8e40014681ae71a85d47a56f9d','紫金路425号-球','119.925992','28.453557','rtsp://172.28.34.226:554/openUrl/CTraDkc','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-06 19:10:10','2021-04-16 10:51:39'),('9e7dc2c32983407e94e06a6274dbfb04','紫金路与华敦街交叉口绿江南-球','119.926441','28.447955','rtsp://172.28.34.226:554/openUrl/kXTAGXu','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 14:46:34','2021-04-16 10:42:44'),('0cafd7006dd242e883cb508220fd948d','紫金路与丽青路交叉口丝绸店-球','119.926311','28.454724','rtsp://172.28.34.226:554/openUrl/kWhFTaM','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 14:46:08','2021-04-16 10:30:27'),('e7d78caf82ef4d65a0e2d358fee7ca4e','紫金路与囿山路交叉口.农行门口-球','119.926314','28.446988','rtsp://172.28.34.226:554/openUrl/kXbjgFq','e9326c67-d265-447b-894e-b4adc5f1d63e','2020-05-13 14:45:23','2021-04-16 10:31:37');
/*!40000 ALTER TABLE `camera_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integration_app_info`
--

DROP TABLE IF EXISTS `integration_app_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integration_app_info` (
                                        `app_id` bigint NOT NULL AUTO_INCREMENT COMMENT '应该ID',
                                        `app_name` varchar(128) NOT NULL COMMENT '应用名称',
                                        `app_desc` varchar(256) DEFAULT NULL COMMENT '应用描述',
                                        `app_dev_host` varchar(256) DEFAULT NULL COMMENT '应用测试端口',
                                        `app_pro_host` varchar(256) DEFAULT NULL COMMENT '应用生产端口',
                                        `creator` bigint DEFAULT NULL COMMENT '创建人',
                                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `updator` bigint DEFAULT NULL COMMENT '修改人',
                                        `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                        PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integration_app_info`
--

LOCK TABLES `integration_app_info` WRITE;
/*!40000 ALTER TABLE `integration_app_info` DISABLE KEYS */;
INSERT INTO `integration_app_info` VALUES (1,'接口管理平台','接口管理desc','d111d','d9',NULL,'2021-03-09 11:29:12',1,'2021-04-03 12:52:26'),(10,'11',NULL,NULL,NULL,NULL,'2021-06-29 17:25:20',NULL,'2021-06-29 18:07:54'),(11,'22',NULL,NULL,NULL,NULL,'2021-06-29 17:25:20',NULL,'2021-06-29 18:07:55'),(12,'33',NULL,NULL,NULL,NULL,'2021-06-29 17:25:20',NULL,'2021-06-29 18:07:55');
/*!40000 ALTER TABLE `integration_app_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interface_detail_info`
--

DROP TABLE IF EXISTS `interface_detail_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interface_detail_info` (
                                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键接口ID',
                                         `name` varchar(128) NOT NULL COMMENT '接口名称',
                                         `url` varchar(128) NOT NULL COMMENT '接口地址',
                                         `model_id` bigint DEFAULT NULL COMMENT '模块ID',
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
                                         `interface_id` bigint NOT NULL COMMENT '接口ID',
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
                                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                        `p_id` bigint DEFAULT NULL COMMENT '父级ID',
                                        `name` varchar(128) DEFAULT NULL COMMENT '接口模块名称',
                                        `url` varchar(128) DEFAULT NULL COMMENT '路径',
                                        `creator` bigint DEFAULT NULL COMMENT '创建人',
                                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                        `updator` bigint DEFAULT NULL COMMENT '修改人',
                                        `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                        `app_id` bigint NOT NULL COMMENT '对应的appId',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interface_model_info`
--

LOCK TABLES `interface_model_info` WRITE;
/*!40000 ALTER TABLE `interface_model_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `interface_model_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage_department_info`
--

DROP TABLE IF EXISTS `manage_department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage_department_info` (
                                          `depart_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
                                          `depart_name` varchar(48) DEFAULT NULL COMMENT '部门名称',
                                          `p_depart_id` bigint DEFAULT NULL COMMENT '部门名称',
                                          `leader` bigint DEFAULT NULL COMMENT '部门负责人ID',
                                          `creator` bigint DEFAULT NULL COMMENT '创建人',
                                          `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                          `updator` bigint DEFAULT NULL COMMENT '修改人',
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
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
                                    `icon` varchar(128) DEFAULT NULL COMMENT '图标',
                                    `ident` varchar(128) DEFAULT NULL COMMENT '标识',
                                    `title` varchar(128) DEFAULT NULL COMMENT '标题',
                                    `url` varchar(512) DEFAULT NULL COMMENT '路径',
                                    `component` varchar(128) DEFAULT NULL,
                                    `name` varchar(128) DEFAULT NULL COMMENT 'name',
                                    `p_id` bigint DEFAULT NULL COMMENT '父级ID',
                                    `rank_id` bigint DEFAULT NULL COMMENT '排序',
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
                                         `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                                         `menu_id` bigint DEFAULT NULL COMMENT '菜单ID'
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
                                    `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
                                    `user_name` varchar(48) DEFAULT NULL COMMENT '姓名',
                                    `sex` int DEFAULT NULL,
                                    `height` int DEFAULT NULL COMMENT '身高',
                                    `weight` int DEFAULT NULL COMMENT '体重',
                                    `birthday` date DEFAULT NULL COMMENT '生日',
                                    `live_province` varchar(45) DEFAULT NULL,
                                    `live_city` varchar(45) DEFAULT NULL,
                                    `live_county` varchar(45) DEFAULT NULL,
                                    `live_address` varchar(128) DEFAULT NULL COMMENT '地址',
                                    `occupation_type_first` int DEFAULT NULL COMMENT '工作类型',
                                    `occupation_type_second` int DEFAULT NULL,
                                    `occupation_mark` varchar(256) DEFAULT NULL COMMENT '工作备注',
                                    `work_city` varchar(45) DEFAULT NULL,
                                    `work_province` varchar(45) DEFAULT NULL,
                                    `work_county` varchar(45) DEFAULT NULL,
                                    `work_address` varchar(45) DEFAULT NULL,
                                    `wechat` varchar(45) DEFAULT NULL COMMENT '微信',
                                    `qq` varchar(45) DEFAULT NULL COMMENT 'qq',
                                    `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
                                    `e_mail` varchar(48) DEFAULT NULL COMMENT '邮箱',
                                    `head_sculpture` text COMMENT '头像',
                                    `salary` decimal(20,10) DEFAULT NULL COMMENT '年薪',
                                    `is_married` int DEFAULT NULL COMMENT '是否已婚',
                                    `married_mark` varchar(256) DEFAULT NULL COMMENT '婚姻备注',
                                    `is_only` int DEFAULT NULL COMMENT '是否独生',
                                    `only_mark` varchar(256) DEFAULT NULL COMMENT '家里成员备注',
                                    `education` int DEFAULT NULL COMMENT '教育',
                                    `education_mark` varchar(256) DEFAULT NULL COMMENT '教育备注',
                                    `desire` int DEFAULT NULL COMMENT '意愿',
                                    `has_house` int DEFAULT NULL,
                                    `house_mark` varchar(256) DEFAULT NULL,
                                    `has_car` int DEFAULT NULL,
                                    `car_mark` varchar(256) DEFAULT NULL,
                                    `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                                    `account` varchar(16) DEFAULT NULL COMMENT '账号',
                                    `password` varchar(48) DEFAULT NULL COMMENT '密码',
                                    `last_login_position` varchar(45) DEFAULT '未知' COMMENT '最后登录的地址',
                                    `last_login_time` datetime DEFAULT NULL COMMENT '最后登录的时间',
                                    `creator` bigint DEFAULT NULL COMMENT '创建人',
                                    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `updator` bigint DEFAULT NULL COMMENT '修改人',
                                    `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
                                    `live_address_info` varchar(256) DEFAULT NULL,
                                    `work_address_info` varchar(256) DEFAULT NULL,
                                    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理人员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage_user_info`
--

LOCK TABLES `manage_user_info` WRITE;
/*!40000 ALTER TABLE `manage_user_info` DISABLE KEYS */;
INSERT INTO `manage_user_info` VALUES (1,'LMLX',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'浙江省杭州市西湖区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'admin','21232f297a57a5a743894a0e4a801fc3','浙江省杭州市','2022-02-26 22:59:14',NULL,NULL,NULL,'2022-02-26 22:59:14',NULL,NULL),(2,'ABCD',1,165,75,'1996-02-20','330000','330500','330502','星湖半岛',1003,1003001,'软件开发','330100','330000','330112',NULL,'wei869974640','869974640','15715771025','869974640@qq.com',NULL,24.0000000000,1,'现在离异',0,'家有五口人',30,'三本',1,1,'房子三套',0,'车子2辆',2,'abcd',NULL,'未知',NULL,NULL,NULL,NULL,'2022-02-28 19:39:40','星湖半岛','星湖半岛星湖半岛'),(3,'张三',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'zs',NULL,'未知',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'李四',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ls',NULL,'未知',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'王二',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'we',NULL,'未知',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'甲丁',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'jd',NULL,'未知',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-03-01 19:31:22
