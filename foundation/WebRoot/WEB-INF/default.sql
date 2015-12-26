CREATE DATABASE  IF NOT EXISTS `foundation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `foundation`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: foundation
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,'2015-12-26 21:13:54',1,'create by auto ','2015-12-26 21:13:54','admin',0,'@dmin');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_expand_property`
--

DROP TABLE IF EXISTS `t_expand_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_expand_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `default_options` varchar(255) DEFAULT NULL,
  `product_category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_62dd8f020e8b4e2fba06abfc503` (`product_category_id`),
  CONSTRAINT `FK_62dd8f020e8b4e2fba06abfc503` FOREIGN KEY (`product_category_id`) REFERENCES `t_product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_expand_property`
--

LOCK TABLES `t_expand_property` WRITE;
/*!40000 ALTER TABLE `t_expand_property` DISABLE KEYS */;
INSERT INTO `t_expand_property` VALUES (1,'2015-12-26 21:14:44',1,'bed size','2015-12-26 21:14:44','size',0,'King;Queen',1),(2,'2015-12-26 21:15:40',1,'support size','2015-12-26 21:15:40','size',0,'40;41;42;50;55',2),(3,'2015-12-26 21:16:21',1,'support colors','2015-12-26 21:16:21','colors',0,'red;green;blue',3);
/*!40000 ALTER TABLE `t_expand_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_info`
--

DROP TABLE IF EXISTS `t_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `deal_status` int(11) NOT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `room_id` varchar(255) DEFAULT NULL,
  `room_numbers` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_info`
--

LOCK TABLES `t_order_info` WRITE;
/*!40000 ALTER TABLE `t_order_info` DISABLE KEYS */;
INSERT INTO `t_order_info` VALUES (2,'2015-12-26 23:33:21',1,NULL,'2015-12-26 23:33:21','N',0,'C','CA','CN',0,'DA','D','E','1',123,1,0,'1'),(4,'2015-12-26 23:43:10',1,NULL,'2015-12-26 23:43:10','n',0,'c','ca','cn',0,'da','d','e','1',111,1,0,'1');
/*!40000 ALTER TABLE `t_order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `price` double NOT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `qyt` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_862ed0977e054bde97074644b02` (`order_id`),
  CONSTRAINT `FK_862ed0977e054bde97074644b02` FOREIGN KEY (`order_id`) REFERENCES `t_order_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
INSERT INTO `t_order_item` VALUES (4,'2015-12-26 23:33:21',1,NULL,'2015-12-26 23:33:21','defaultName',0,1224,'Bed0002',1,2),(5,'2015-12-26 23:33:21',1,NULL,'2015-12-26 23:33:21','defaultName',0,1234,'Bed0003',2,2),(6,'2015-12-26 23:33:21',1,NULL,'2015-12-26 23:33:21','defaultName',0,12345,'TV0002',2,2),(11,'2015-12-26 23:43:10',1,NULL,'2015-12-26 23:43:10','defaultName',0,1200,'Bed0002',2,4),(12,'2015-12-26 23:43:10',1,NULL,'2015-12-26 23:43:10','defaultName',0,12345,'TV0001',3,4),(13,'2015-12-26 23:43:10',1,NULL,'2015-12-26 23:43:10','defaultName',0,12345,'TV0002',4,4),(14,'2015-12-26 23:43:10',1,NULL,'2015-12-26 23:43:10','defaultName',0,230,'121',5,4);
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `category_id` varchar(255) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `depth` varchar(255) DEFAULT NULL,
  `desc_basic` varchar(255) DEFAULT NULL,
  `desc_detail` varchar(2000) DEFAULT NULL,
  `detail_picture` varchar(2000) DEFAULT NULL,
  `height` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `size_unit` varchar(255) DEFAULT NULL,
  `thumbnail_picture` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_f9befbbd75aa4d2a92eb5b4c975` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (4,'2015-12-26 22:11:35',1,'Commercial Grade Stand','2015-12-26 22:12:29','LG LX340H Slim LED With',0,'2','TV','TVMG001','12','BASIC DESC',' Commercial grade stand with lock-down hardware included • Welcome screen with message and hotel logo/branding • Volume-limit and lock-mode for guest use • USB Clone programming for easy installation and set-up','furniture/Catalog4-(1)-31.jpg','12',12345,'','furniture/model/Catalog4-(1)-30.jpg','123'),(5,'2015-12-26 22:22:00',1,'Ergonomic office chair','2015-12-26 22:22:00','Ergon 3 Chairs',0,'3','Chairs','CMG001','17.25','Ergon 3 Chairs','Material innovation gives the Setu chair its unique combination of flex and strength. The Kinematic Spine uses two types of polypropylene to control resistance as you recline and support your weight, without a tilt mechanism. More structural element than textile, the Lyris 2 suspension seat and back conform to your contours and aerate your body as you sit comfortably','furniture/catalog_detail2.png','25.125',230,'','furniture/model/icon_chairs1.jpg','37.125-38.375'),(6,'2015-12-26 23:37:31',1,'Pillow-Top Mattress','2015-12-26 23:37:31','Beautyrest® Eternity Pillow Top',0,'1','Bed','Bed0001','12','Pillow-Top Mattress','Pillow-Top Mattress Height Approx. 30.5cm (12 inches) Sizes • Queen 152cm x 190cm • King 182cm x 190cm','furniture/catalog_detai2.jpg','312',999,'Sizes • Queen 152cm x 190cm • King 182cm x 190cm','furniture/model/catalog2.jpg','12');
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_category`
--

DROP TABLE IF EXISTS `t_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_category`
--

LOCK TABLES `t_product_category` WRITE;
/*!40000 ALTER TABLE `t_product_category` DISABLE KEYS */;
INSERT INTO `t_product_category` VALUES (1,'2015-12-26 21:14:44',1,'BedInfo','2015-12-26 21:14:44','Bed',0,''),(2,'2015-12-26 21:15:40',1,'TV','2015-12-26 21:15:40','TV',0,''),(3,'2015-12-26 21:16:21',1,'Chairs','2015-12-26 21:16:21','Chairs',0,'');
/*!40000 ALTER TABLE `t_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_property_product`
--

DROP TABLE IF EXISTS `t_property_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_property_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `product_pic_url` varchar(255) DEFAULT NULL,
  `product_price` double NOT NULL,
  `property_info` varchar(255) DEFAULT NULL,
  `property_name` varchar(255) NOT NULL,
  `property_pic_url` varchar(255) DEFAULT NULL,
  `property_value` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bc339797dcc7469ba2b2df28fbb` (`product_code`),
  KEY `FK_812753144a0346d79be093cb582` (`product_id`),
  CONSTRAINT `FK_812753144a0346d79be093cb582` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_property_product`
--

LOCK TABLES `t_property_product` WRITE;
/*!40000 ALTER TABLE `t_property_product` DISABLE KEYS */;
INSERT INTO `t_property_product` VALUES (8,'2015-12-26 22:12:29',1,NULL,'2015-12-26 22:12:29','size',0,'TV0001','',12345,'40','size','','40\'',4),(9,'2015-12-26 22:12:29',1,NULL,'2015-12-26 22:12:29','size',0,'TV0002','',12345,'50','size','','50\'',4),(10,'2015-12-26 22:12:29',1,NULL,'2015-12-26 22:12:29','size',0,'TV0004','',12345,'55','size','','55\'',4),(11,'2015-12-26 22:22:00',1,NULL,'2015-12-26 22:22:00','colors',0,'120','furniture/chairs_attr1.jpg',230,'red','colors','furniture/chairs_attr1.jpg','red',5),(12,'2015-12-26 22:22:00',1,NULL,'2015-12-26 22:22:00','colors',0,'121','furniture/chairs_attr1.jpg',232,'green','colors','furniture/chairs_attr1.jpg','green',5),(13,'2015-12-26 22:22:00',1,NULL,'2015-12-26 22:22:00','colors',0,'122','furniture/chairs_attr1.jpg',233,'blue','colors','furniture/chairs_attr1.jpg','blue',5),(14,'2015-12-26 23:37:31',1,NULL,'2015-12-26 23:37:31','size',0,'Bed0002','',1200,'King','size','','King',6),(15,'2015-12-26 23:37:31',1,NULL,'2015-12-26 23:37:31','size',0,'Bed0003','',1234,'Queen','size','','Queen',6);
/*!40000 ALTER TABLE `t_property_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_room`
--

DROP TABLE IF EXISTS `t_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `category_id` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `rooms_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_room`
--

LOCK TABLES `t_room` WRITE;
/*!40000 ALTER TABLE `t_room` DISABLE KEYS */;
INSERT INTO `t_room` VALUES (1,'2015-12-26 22:24:08',1,'Room1','2015-12-26 23:41:47','Room1',0,'1','Standard Room','room/Room_1.jpg',NULL);
/*!40000 ALTER TABLE `t_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_room_category`
--

DROP TABLE IF EXISTS `t_room_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_room_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_room_category`
--

LOCK TABLES `t_room_category` WRITE;
/*!40000 ALTER TABLE `t_room_category` DISABLE KEYS */;
INSERT INTO `t_room_category` VALUES (1,'2015-12-26 22:23:04',1,'Standard Room','2015-12-26 22:23:04','Standard Room',0,'');
/*!40000 ALTER TABLE `t_room_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `info` varchar(255) DEFAULT NULL,
  `last_update_time` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `head_pic_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_a8cd3836da674469a48823c3fca` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'2015-12-26 22:25:09',1,NULL,'2015-12-26 22:25:09','1234@1234.com',0,'China','X Company','1234@1234.com',NULL,'1234','1211111111',NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-26 23:54:01
