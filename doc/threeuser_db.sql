/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - threeuser_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`threeuser_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `threeuser_db`;

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `dict_type` varchar(32) DEFAULT NULL COMMENT '类型',
  `dict_code` varchar(32) DEFAULT NULL COMMENT '编码',
  `dict_name` varchar(64) DEFAULT NULL COMMENT '名称',
  `dict_value` varchar(128) DEFAULT NULL COMMENT '值',
  `dict_desc` varchar(128) DEFAULT NULL COMMENT '描述',
  `fh_dict_code` varchar(32) DEFAULT NULL COMMENT '上级编码',
  `memo` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`dict_type`,`dict_code`,`dict_name`,`dict_value`,`dict_desc`,`fh_dict_code`,`memo`) values (1,'ORDER_TYPE','SIMPLE_ORDER','样品单','SIMPLE_ORDER','样品单','','订单类型'),(2,'ORDER_TYPE','NORMAL_ORDER','正常单','NORMAL_ORDER','正常单','','订单类型'),(3,'ORDER_TYPE','ADD_ORDER','补单','ADD_ORDER','补单','','订单类型'),(4,'ORDER_TYPE','GIFT_ORDER','赠品','GIFT_ORDER','赠品','','订单类型'),(5,'ORDER_TYPE','ENGIN_ORDER','工程单','ENGIN_ORDER','工程单','','订单类型'),(6,'SALE_TYPE','INNER_SALE','内销','INNER_SALE','内销','','销售类型'),(7,'SALE_TYPE','OUT_SALE','外销','OUT_SALE','外销','','销售类型'),(8,'MATERIAL_TYPE','PROD','成品布','PROD','成品布','','物料类型'),(9,'MATERIAL_TYPE','COTTON ','面料','COTTON ','面料','','物料类型'),(11,'PAY_WAY','TEL_PAY','电汇','TEL_PAY','电汇','','付款方式'),(12,'PAY_WAY','CASH','现金','CASH','现金','','付款方式'),(13,'PAY_WAY','CHEQUE','支票','CHEQUE','支票','','付款方式'),(14,'PAY_WAY','POS','POS','POS','POS','','付款方式'),(15,'ORDER_STATUS','WAIT_APPLY','待初审','WAIT_APPLY','待初审','','订单状态'),(16,'ORDER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功','','订单状态'),(17,'ORDER_STATUS','AUDIT_SUCCESS','终审成功','AUDIT_SUCCESS','终审成功','','订单状态'),(18,'ORDER_STATUS','ORDER_FINISH','订单结束','ORDER_FINISH','订单结束','','订单状态'),(19,'FORMULAR_TYPE','PROD','成品布公式','PROD','成品布公式',NULL,'公式类型'),(20,'FORMULAR_TYPE','COTTON ','面料公式','COTTON ','面料公式',NULL,'公式类型'),(21,'FORMULAR_TYPE','CRAFTS','工艺公式','CRAFTS','工艺公式',NULL,'公式类型'),(22,'MATERIAL_STOCK','PROD_STOCK','成品库','PROD_STOCK','成品库',NULL,'所属仓库'),(23,'MATERIAL_STOCK','COTTON_STOCK','面料库','COTTON_STOCK','面料库',NULL,'所属仓库'),(24,'REFUSE_TYPE','RETURN','退货','RETURN','退货',NULL,'校验不合格后续操作'),(25,'REFUSE_TYPE','BUJI','补给','BUJI','补给',NULL,'校验不合格后续操作'),(26,'REFUSE_TYPE','FANXIU','返修','FANXIU','返修',NULL,'校验不合格后续操作'),(27,'DELIVER_WAY','ZHOGNTONG','中通','ZHOGNTONG','中通',NULL,'运货方式'),(28,'DELIVER_WAY','SHENGONG','申通','SHENGONG','申通',NULL,'运货方式'),(29,'DELIVER_WAY','YUNDA','韵达','YUNDA','韵达',NULL,'运货方式'),(30,'DELIVER_WAY','YUANTONG','圆通','YUANTONG','圆通',NULL,'运货方式'),(31,'DELIVER_WAY','SHUNFENG','顺丰','SHUNFENG','顺丰',NULL,'运货方式'),(32,'ORDER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'订单状态'),(33,'DELIVER_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'发货状态'),(34,'DELIVER_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'发货状态'),(35,'DELIVER_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'发货状态'),(36,'DELIVER_STATUS','AUDIT_SUCCESS','已发货','AUDIT_SUCCESS','已发货',NULL,'发货状态'),(37,'DELIVER_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'发货状态'),(38,'PUR_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'采购状态'),(39,'PUR_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'采购状态'),(40,'PUR_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'采购状态'),(41,'PUR_STATUS','AUDIT_SUCCESS','已送货','AUDIT_SUCCESS','已送货',NULL,'采购状态'),(42,'PUR_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'采购状态'),(43,'RECV_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'领料状态'),(44,'RECV_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'领料状态'),(45,'RECV_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'领料状态'),(46,'RECV_STATUS','AUDIT_SUCCESS','已领料','AUDIT_SUCCESS','已领料',NULL,'领料状态'),(47,'RECV_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'领料状态'),(48,'RETURN_STATUS','WAIT_APPLY','待申请','WAIT_APPLY','待申请',NULL,'退货单状态'),(49,'RETURN_STATUS','WAIT_AUDIT','待初审','WAIT_AUDIT','待初审',NULL,'退货单状态'),(50,'RETURN_STATUS','AUDIT01_SUCCESS','初审成功','AUDIT01_SUCCESS','初审成功',NULL,'退货单状态'),(51,'RETURN_STATUS','AUDIT_SUCCESS','已退货','AUDIT_SUCCESS','已退货',NULL,'退货单状态'),(52,'RETURN_STATUS','HAS_CANCEL','已作废','HAS_CANCEL','已作废',NULL,'退货单状态'),(53,'VERIFY_STATUS','WAIT_VERIFY','等待校验','WAIT_VERIFY','等待校验',NULL,'校验状态'),(54,'VERIFY_STATUS','STOCK_FINISH','已校验','STOCK_FINISH','已校验',NULL,'校验状态'),(55,'STEP_NO','ZHENGJING','整经','ZHENGJING','整经',NULL,'步骤流程'),(56,'STEP_NO','ZHIBU','织布','ZHIBU','织布',NULL,'步骤流程'),(57,'STEP_NO','XIUBU','修布','XIUBU','修布',NULL,'步骤流程'),(58,'STEP_NO','RANBU','染布','RANBU','染布',NULL,'步骤流程'),(59,'STEP_NO','CAIJIAN','裁剪','CAIJIAN','裁剪',NULL,'步骤流程'),(60,'STEP_NO','FENGREN','缝纫','FENGREN','缝纫',NULL,'步骤流程'),(61,'STEP_NO','HOUZHENG','后整','HOUZHENG','后整',NULL,'步骤流程');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `source_no` varchar(32) DEFAULT NULL COMMENT '资源编号',
  `source_name` varchar(64) DEFAULT NULL COMMENT '资源名称',
  `fh_source_no` varchar(32) DEFAULT NULL COMMENT '上级资源编号',
  `source_type` varchar(16) DEFAULT 'MENU' COMMENT '资源类型 MENU:菜单 BUTTON:按钮',
  `req_url` varchar(512) DEFAULT NULL COMMENT '地址路径',
  `rsource_icon` varchar(64) DEFAULT NULL COMMENT '资源图标',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序规则',
  `level` int(11) DEFAULT NULL COMMENT '资源级别',
  `if_visible` char(1) DEFAULT 'Y' COMMENT '是否显示 Y:显示 N:不显示',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`source_no`,`source_name`,`fh_source_no`,`source_type`,`req_url`,`rsource_icon`,`sort_order`,`level`,`if_visible`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'order','业务订单',NULL,'MENU',NULL,NULL,1,1,'Y',NULL,NULL,NULL,NULL,'2017-10-23 17:28:40',0),(2,'purchase','采购管理',NULL,'MENU',NULL,NULL,2,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:09',0),(3,'produce','生产制造',NULL,'MENU',NULL,NULL,4,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:37:57',0),(4,'stock','仓库管理',NULL,'MENU',NULL,NULL,3,1,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:38:01',0),(5,'base','基础资料',NULL,'MENU',NULL,NULL,5,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:41',0),(6,'system','系统管理',NULL,'MENU',NULL,NULL,6,1,'Y',NULL,NULL,NULL,NULL,'2017-10-31 14:22:43',0),(7,'orderCreate','创建订单合同','order','MENU','/createOrder',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(8,'orderApply','订单初审','order','MENU','/orderApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(9,'orderAudit','订单终审','order','MENU','/orderAudit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(10,'orderQuery','订单查询','order','MENU','/orderList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(11,'deliverCreate','创建发货单','order','MENU','/deliverCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(12,'deliverApply','发货单申请','order','MENU','/deliverApply',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 14:23:31',0),(14,'deliverQuery','发货单查询','order','MENU','/deliverList',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(15,'materialInfo','物料信息','base','MENU','/material',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(16,'formularInfo','公式信息','base','MENU','/formular',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(17,'compInfo','公司资料','base','MENU','/comp',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(18,'departInfo','部门信息','base','MENU','/depart',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(19,'dashboard','管理中心',NULL,'MENU','/dashboard',NULL,0,1,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(20,'purchaseCreate','采购单创建','purchase','MENU','/purchaseCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(21,'purchaseApply','采购单申请','purchase','MENU','/purchaseApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(22,'purchaseAudit','采购单终审','purchase','MENU','/purchaseAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:12',0),(23,'purchaseQuery','采购单查询','purchase','MENU','/purchaseQuery',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:13',0),(24,'returnCreate','退货单创建','purchase','MENU','/returnCreate',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:14',0),(25,'returnApply','退货单申请','purchase','MENU','/returnApply',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:16',0),(26,'returnAudit','退货单审核','purchase','MENU','/returnAudit',NULL,9,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:39:57',0),(27,'returnList','退货单查询','purchase','MENU','/returnList',NULL,10,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:01',0),(28,'stockVerify','入库校验','stock','MENU','/stockVerify',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(29,'stockVerifyQuery','校验记录查询','stock','MENU','/stockVerifyQuery',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(30,'stockQuery','库存查询','stock','MENU','/stockQuery',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(31,'receiveAudit','领料单终审','stock','MENU','/receiveAudit',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(32,'deliverAudit','发货单终审','stock','MENU','/deliverAudit',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(33,'receiveCreate','领料单创建','produce','MENU','/receiveCreate',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(34,'receiveApply','领料单申请','produce','MENU','/receiveApply',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-23 17:16:11',0),(35,'receiveList','领料单查询','produce','MENU','/receiveList',NULL,4,2,'Y',NULL,NULL,NULL,NULL,'2017-12-19 15:07:12',0),(36,'workCreate','工时导入','produce','MENU','/workCreate',NULL,5,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:32:41',0),(37,'workQuery','工时查询','produce','MENU','/workQuery',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-12-24 17:24:17',0),(38,'deliverAudit01','发货单初审','order','MENU','/deliverAudit01',NULL,7,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 15:08:22',0),(39,'userManager','账户管理','system','MENU','/userManager',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:48',0),(40,'roleInfo','角色信息','system','MENU','/roleInfo',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:49',0),(41,'rolePermit','角色权限','system','MENU','/rolePermit',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-11-27 18:35:50',0),(42,'purchaseAudit01','采购单初审','purchase','MENU','/purchaseAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-05 22:13:30',0),(43,'returnAudit01','退货单初审','purchase','MENU','/returnAudit01',NULL,8,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 14:40:05',0),(44,'receiveAudit01','领料单初审','produce','MENU','/receiveAudit01',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2017-12-10 17:33:13',0),(45,'workModi','工时调整','produce','MENU','/workModi',NULL,6,2,'Y',NULL,NULL,NULL,NULL,'2017-12-24 17:24:50',0);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `status` char(1) DEFAULT 'Y' COMMENT '状态 Y:有效 N:无效',
  `if_admin` char(1) DEFAULT 'N' COMMENT '是否超级角色',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_code`,`role_name`,`status`,`if_admin`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','超级管理员','Y','Y',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-30 14:12:31',0),(2,'busi','业务员','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-30 14:12:31',0),(3,'phurchase','采购员','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0),(4,'produceManger','生产主管','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0),(5,'producer','生产员工','Y','N',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-23 17:08:50',0);

/*Table structure for table `sys_role_resource` */

DROP TABLE IF EXISTS `sys_role_resource`;

CREATE TABLE `sys_role_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `source_no` varchar(32) DEFAULT NULL COMMENT '资源编号',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=296 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_code`,`source_no`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (252,'admin','order',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(253,'admin','purchase',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(254,'admin','produce',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(255,'admin','stock',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(256,'admin','base',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(257,'admin','system',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(258,'admin','orderCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(259,'admin','orderApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(260,'admin','orderAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(261,'admin','orderQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(262,'admin','deliverCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(263,'admin','deliverApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(264,'admin','deliverQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(265,'admin','materialInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(266,'admin','formularInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(267,'admin','compInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(268,'admin','departInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(269,'admin','dashboard',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(270,'admin','purchaseCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(271,'admin','purchaseApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(272,'admin','purchaseAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(273,'admin','purchaseQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(274,'admin','returnCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(275,'admin','returnApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(276,'admin','returnAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(277,'admin','returnList',NULL,NULL,NULL,'2017-12-10 16:50:08',0),(278,'admin','stockVerify',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(279,'admin','stockVerifyQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(280,'admin','stockQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(281,'admin','receiveAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(282,'admin','deliverAudit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(283,'admin','receiveCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(284,'admin','receiveApply',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(285,'admin','receiveList',NULL,NULL,NULL,'2017-12-10 17:33:45',0),(286,'admin','workCreate',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(287,'admin','workQuery',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(288,'admin','deliverAudit01',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(289,'admin','userManager',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(290,'admin','roleInfo',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(291,'admin','rolePermit',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(292,'admin','purchaseAudit01',NULL,NULL,NULL,'2017-12-05 22:14:14',0),(293,'admin','returnAudit01',NULL,NULL,NULL,'2017-12-10 16:33:20',0),(294,'admin','receiveAudit01',NULL,NULL,NULL,'2017-12-10 17:34:02',0),(295,'admin','workModi',NULL,NULL,NULL,'2017-12-24 17:24:54',0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `phone_num` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email_addr` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `status` char(1) DEFAULT 'Y' COMMENT '状态 Y:有效 N:无效',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_index_userNo` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`user_name`,`nick_name`,`phone_num`,`email_addr`,`password`,`status`,`memo`,`last_login_time`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'wangfangfang','王芳芳','王芳芳','15166119377','XXX@qq.com','e10adc3949ba59abbe56e057f20f883e','Y','test',NULL,'system','2017-10-20 11:14:18','system','2018-01-19 15:17:46',0),(2,'admin','管理员','管理员','15222222876','XXX@qq.com','e10adc3949ba59abbe56e057f20f883e','Y','test',NULL,'system','2017-10-20 11:14:34','system','2018-01-19 15:17:47',0),(3,'chunxiao','春晓','春晓','15222222878','595453378@qq.com','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'system','2018-01-19 10:43:55','system','2018-01-19 15:18:37',0),(4,'dapeng','大鹏','大鹏','15222222879','613954121@qq.com','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'system','2018-01-19 10:43:57','system','2018-01-19 15:18:39',0),(5,'xiaoning','小宁\r\n','小宁\r\n','15222222676','1032836822@qq.com','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'system','2018-01-19 10:43:58','system','2018-01-19 15:18:40',0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_no`,`role_code`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','admin',NULL,'2017-10-30 14:13:00',NULL,'2017-10-30 14:13:02',0),(2,'wangfangfang','admin',NULL,'2017-10-30 14:13:02',NULL,'2017-11-19 11:14:10',0),(3,'chunxiao','admin',NULL,'2018-01-19 10:44:30',NULL,'2018-01-19 10:44:32',0),(4,'dapeng','admin',NULL,'2018-01-19 10:44:32',NULL,'2018-01-19 10:44:33',0),(5,'xiaoning','admin',NULL,'2018-01-19 10:44:33',NULL,'2018-01-19 10:44:35',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
