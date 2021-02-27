/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-3306
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : mysql_learn

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2021-02-27 16:04:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_number` varchar(100) NOT NULL COMMENT '订单编号',
  `sell_account` varchar(100) NOT NULL COMMENT '卖家账号',
  `buy_account` varchar(100) NOT NULL COMMENT '买家账号',
  `product_number` varchar(100) NOT NULL COMMENT '商品编号',
  `buy_num` int(11) NOT NULL COMMENT '购买数量',
  `price` double NOT NULL COMMENT '商品单价',
  `detail` int(11) NOT NULL COMMENT '商品描述',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
