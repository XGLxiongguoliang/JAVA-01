/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-3306
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : mysql_learn

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-02-27 16:04:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_product`
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) NOT NULL COMMENT '商品名称',
  `number` varchar(100) NOT NULL COMMENT '商品编号',
  `detail` varchar(100) NOT NULL COMMENT '商品描述',
  `stock` int(11) NOT NULL COMMENT '库存数量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
