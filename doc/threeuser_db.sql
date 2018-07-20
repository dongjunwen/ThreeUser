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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`threeuser_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

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
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`dict_type`,`dict_code`,`dict_name`,`dict_value`,`dict_desc`,`fh_dict_code`,`memo`) values (1,'STATUS','Y','有效','Y','有效',NULL,'状态'),(2,'STATUS','N','无效','N','无效',NULL,'状态'),(64,'SOURCE_TYPE','MENU','菜单',NULL,NULL,'',NULL),(65,'SOURCE_TYPE','BUTTON','按钮',NULL,NULL,NULL,NULL);

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
  `source_level` int(11) DEFAULT NULL COMMENT '资源级别',
  `if_visible` char(1) DEFAULT 'Y' COMMENT '是否显示 Y:显示 N:不显示',
  `memo` varchar(64) DEFAULT NULL COMMENT '备注',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`id`,`source_no`,`source_name`,`fh_source_no`,`source_type`,`req_url`,`rsource_icon`,`sort_order`,`source_level`,`if_visible`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'system','系统管理',NULL,'MENU',NULL,'&#xe614;',1,1,'Y',NULL,NULL,NULL,NULL,'2018-07-20 15:37:02',0),(2,'SYS_USER','账户管理','system','MENU','html/system/user-listPage.html',NULL,1,2,'Y',NULL,NULL,NULL,NULL,'2018-07-20 15:57:50',0),(3,'SYS_RESOURCE','资源信息','system','MENU','html/system/sysResource-listPage.html',NULL,2,2,'Y',NULL,NULL,NULL,NULL,'2018-07-20 15:57:32',0),(4,'SYS_ROLE','角色信息','system','MENU','html/system/sysRole-listPage.html',NULL,3,2,'Y',NULL,NULL,NULL,NULL,'2018-07-20 15:57:51',0),(10,'ddd','7777','undefined','MENU','html/system/user-listPage.html',NULL,4,2,'Y',NULL,'admin','2018-07-20 18:27:45','admin','2018-07-20 18:33:04',0),(11,'aa','777','ddd','MENU','html/base/dict-list.html',NULL,6,3,'Y',NULL,'admin','2018-07-20 18:28:02','admin','2018-07-20 18:32:48',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_code`,`role_name`,`status`,`if_admin`,`memo`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','超级管理员','Y','Y',NULL,NULL,'2017-10-23 17:08:50',NULL,'2017-10-30 14:12:31',0),(7,'emp','员工','Y','N',NULL,'admin','2018-07-20 18:13:41','admin','2018-07-20 18:13:41',0);

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
) ENGINE=InnoDB AUTO_INCREMENT=314 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

/*Data for the table `sys_role_resource` */

insert  into `sys_role_resource`(`id`,`role_code`,`source_no`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (257,'admin','system',NULL,NULL,NULL,'2017-11-27 18:41:09',0),(289,'admin','SYS_USER',NULL,NULL,NULL,'2018-07-20 15:58:13',0),(290,'admin','SYS_RESOURCE',NULL,NULL,NULL,'2018-07-20 15:58:16',0),(291,'admin','SYS_ROLE',NULL,NULL,NULL,'2018-07-20 15:58:17',0),(310,'emp','system','admin','2018-07-20 18:14:03',NULL,NULL,NULL),(311,'emp','SYS_USER','admin','2018-07-20 18:14:03',NULL,NULL,NULL),(312,'emp','SYS_RESOURCE','admin','2018-07-20 18:14:03',NULL,NULL,NULL),(313,'emp','SYS_ROLE','admin','2018-07-20 18:14:03',NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`user_name`,`nick_name`,`phone_num`,`email_addr`,`password`,`status`,`memo`,`last_login_time`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','管理员','管理员','15222222876','XXX@qq.com','e10adc3949ba59abbe56e057f20f883e','Y','test',NULL,'system','2017-10-20 11:14:34','system','2018-07-20 18:32:30',18),(10,'www','www','www','1112','zhangkai@cs.sh.cn','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'admin','2018-07-20 17:37:22','admin','2018-07-20 17:37:22',0),(11,'fffff','ff','ff','fff','ff','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'admin','2018-07-20 17:39:17','admin','2018-07-20 17:39:17',0),(12,'gggg','gg','','gg','zhangkai@cs.sh.cn','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'admin','2018-07-20 17:41:00','admin','2018-07-20 17:41:00',0),(13,'hhhh','hh','张凯','11111','zhangkai@cs.sh.cn','e10adc3949ba59abbe56e057f20f883e','Y',NULL,NULL,'admin','2018-07-20 17:47:54','admin','2018-07-20 17:47:54',0);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `create_no` varchar(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modi_no` varchar(32) DEFAULT NULL COMMENT '修改人',
  `modi_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_no`,`role_code`,`role_name`,`create_no`,`create_time`,`modi_no`,`modi_time`,`version`) values (1,'admin','admin',NULL,NULL,'2017-10-30 14:13:00',NULL,'2017-10-30 14:13:02',0),(6,'hhhh','admin','超级管理员','admin','2018-07-20 17:47:54',NULL,'2018-07-20 17:47:53',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
