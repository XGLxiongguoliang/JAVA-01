/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-3306
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : mysql_learn

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-02-27 16:04:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) NOT NULL COMMENT '用户名',
  `account` varchar(100) NOT NULL COMMENT '账户',
  `pwd` varchar(100) NOT NULL COMMENT '密码',
  `addr` varchar(200) NOT NULL COMMENT '地址',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
