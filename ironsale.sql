/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ironsale

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-02 21:29:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `steelsale_brand`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_brand`;
CREATE TABLE `steelsale_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '钢材品牌id',
  `brand_name` varchar(20) DEFAULT NULL COMMENT '品牌名称',
  `status` tinyint(1) DEFAULT '1' COMMENT '品牌状态 0：删除 1：正常',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='钢材品牌表';

-- ----------------------------
-- Records of steelsale_brand
-- ----------------------------
INSERT INTO `steelsale_brand` VALUES ('1', '中原钢铁', '1', '2020-01-20 12:12:13', '2020-01-20 12:12:16');

-- ----------------------------
-- Table structure for `steelsale_client`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_client`;
CREATE TABLE `steelsale_client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `name` varchar(10) NOT NULL COMMENT '客户姓名',
  `phone` varchar(12) NOT NULL COMMENT '手机号',
  `email` varchar(50) NOT NULL COMMENT '邮箱号',
  `id_card` varchar(20) NOT NULL COMMENT '身份证号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `type` tinyint(1) DEFAULT '0' COMMENT '客户类型 0 普通客户 1 会员',
  `integral` int(255) DEFAULT '0' COMMENT '积分 ',
  `city` varchar(255) DEFAULT NULL COMMENT '客户地址',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of steelsale_client
-- ----------------------------
INSERT INTO `steelsale_client` VALUES ('1', '张三', '17835696221', '123@qq.com', '412721199408123434', '2020-01-20 11:18:06', '2020-01-20 11:18:09', '0', '0', '{\"area\":\"东城区\",\"city\":\"市辖区\",\"province\":\"北京\"}');
INSERT INTO `steelsale_client` VALUES ('2', 'aaa', 'aaaa', 'aaaa', 'aaaa', null, null, null, null, '{\"area\":\"东城区\",\"city\":\"市辖区\",\"province\":\"北京\"}');
INSERT INTO `steelsale_client` VALUES ('3', 'ZZZ', 'ZZZ', 'ZZZ', 'ZZZZ', null, null, null, null, '{\"area\":\"东城区\",\"city\":\"市辖区\",\"province\":\"北京\"}');
INSERT INTO `steelsale_client` VALUES ('4', '李四', '17867899876', '1232@qq.com', '41271100909119090', null, null, null, null, '{\"area\":\"黄浦区\",\"city\":\"市辖区\",\"province\":\"上海\"}');

-- ----------------------------
-- Table structure for `steelsale_employee`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_employee`;
CREATE TABLE `steelsale_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 员工id',
  `login_name` varchar(20) NOT NULL DEFAULT '' COMMENT '登陆名',
  `login_pwd` varchar(32) NOT NULL DEFAULT '' COMMENT '登陆密码',
  `employee_name` varchar(50) DEFAULT NULL COMMENT '用户真实姓名',
  `employee_sex` tinyint(1) DEFAULT '0' COMMENT '性别 0 男 1 女',
  `employee_salary` double(50,0) DEFAULT NULL COMMENT '员工薪资',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0：在职 1.离职',
  `employee_email` varchar(50) DEFAULT 'null' COMMENT '邮箱号',
  `employee_tel` varchar(12) DEFAULT NULL COMMENT '手机号码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of steelsale_employee
-- ----------------------------
INSERT INTO `steelsale_employee` VALUES ('1', 'admin', '698d51a19d8a121ce581499d7b701668', '从老板', '1', '50000', '0', '1352161484@qq.com', '17835696321', '2020-01-20 11:03:45', '2020-03-01 23:01:44');
INSERT INTO `steelsale_employee` VALUES ('2', 'cgm', '96e79218965eb72c92a549dd5a330112', 'cgm', '0', '2000', '1', '111@qq.com', '13521614844', '2020-02-20 18:01:01', '2020-02-20 18:01:08');
INSERT INTO `steelsale_employee` VALUES ('5', '11111', '111', null, '0', null, '1', '111111111111@qq.com', null, '2020-02-22 16:14:46', '2020-02-22 16:14:46');
INSERT INTO `steelsale_employee` VALUES ('10', 'xx', '9db06bcff9248837f86d1a6bcf41c9e7', 'xx', '0', '3000', '0', 'xxx', '17835696331', '2020-03-01 17:20:37', '2020-03-01 17:20:37');
INSERT INTO `steelsale_employee` VALUES ('11', 'aaaaaa', '9db06bcff9248837f86d1a6bcf41c9e7', 'aaa', '0', '3000', '0', 'aaaaaaaaaaa', '17835690000', '2020-03-01 17:55:02', '2020-03-01 17:55:02');
INSERT INTO `steelsale_employee` VALUES ('12', 'cccc', '9db06bcff9248837f86d1a6bcf41c9e7', '从', '0', '3000', '0', 'bbbbb', '18888888888', '2020-03-01 18:05:16', '2020-03-01 18:05:16');

-- ----------------------------
-- Table structure for `steelsale_employee_picture`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_employee_picture`;
CREATE TABLE `steelsale_employee_picture` (
  `picture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `employee_id` int(11) DEFAULT NULL COMMENT '员工id',
  `picture_src` varchar(255) DEFAULT NULL COMMENT '图片地址',
  PRIMARY KEY (`picture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of steelsale_employee_picture
-- ----------------------------
INSERT INTO `steelsale_employee_picture` VALUES ('1', '1', 'http://q3xosoc97.bkt.clouddn.com/e2e79067b560455dae21427740c9d000');

-- ----------------------------
-- Table structure for `steelsale_employee_role`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_employee_role`;
CREATE TABLE `steelsale_employee_role` (
  `er_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工角色表id',
  `employee_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`er_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of steelsale_employee_role
-- ----------------------------
INSERT INTO `steelsale_employee_role` VALUES ('4', '2', '3');
INSERT INTO `steelsale_employee_role` VALUES ('5', '12', '1');
INSERT INTO `steelsale_employee_role` VALUES ('6', '12', '2');
INSERT INTO `steelsale_employee_role` VALUES ('7', '1', '1');
INSERT INTO `steelsale_employee_role` VALUES ('8', '1', '2');
INSERT INTO `steelsale_employee_role` VALUES ('9', '1', '3');
INSERT INTO `steelsale_employee_role` VALUES ('10', '1', '4');

-- ----------------------------
-- Table structure for `steelsale_function`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_function`;
CREATE TABLE `steelsale_function` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `parent_id` int(11) DEFAULT '0' COMMENT '权限父ID',
  `function_name` varchar(100) DEFAULT NULL COMMENT '权限名',
  `function_url` varchar(255) DEFAULT NULL COMMENT '权限URL',
  `function_type` tinyint(1) DEFAULT '0' COMMENT '权限类型 1菜单 2功能',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`function_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of steelsale_function
-- ----------------------------

-- ----------------------------
-- Table structure for `steelsale_order`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_order`;
CREATE TABLE `steelsale_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `client_id` int(11) DEFAULT NULL COMMENT '客户id',
  `employee_id` int(11) DEFAULT NULL COMMENT '负责员工的编号',
  `order_price` double(50,1) DEFAULT NULL COMMENT '订单价格',
  `order_num` int(10) DEFAULT NULL COMMENT '订单数量',
  `paytype` tinyint(1) DEFAULT '0' COMMENT '0:支付宝 1：微信',
  `status` tinyint(1) DEFAULT '0' COMMENT '订单数量 0:未支付 1 支付',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '订单更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of steelsale_order
-- ----------------------------
INSERT INTO `steelsale_order` VALUES ('1', '1', '1', '50000.0', '5', '0', '0', '2020-01-20 11:53:22', '2020-01-20 11:53:25');

-- ----------------------------
-- Table structure for `steelsale_role`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_role`;
CREATE TABLE `steelsale_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of steelsale_role
-- ----------------------------
INSERT INTO `steelsale_role` VALUES ('1', 'ROLE_BOSS', '2020-01-20 11:01:08');
INSERT INTO `steelsale_role` VALUES ('2', 'ROLE_MANAGER', '2020-01-20 11:01:43');
INSERT INTO `steelsale_role` VALUES ('3', 'ROLE_EMPLOYEE', '2020-01-20 11:02:01');
INSERT INTO `steelsale_role` VALUES ('4', 'ROLE_BOSss', null);
INSERT INTO `steelsale_role` VALUES ('5', 'ROLE_BOSS', null);

-- ----------------------------
-- Table structure for `steelsale_role_function`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_role_function`;
CREATE TABLE `steelsale_role_function` (
  `role_id` int(11) DEFAULT '0' COMMENT '角色ID',
  `function_id` int(11) DEFAULT '0' COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of steelsale_role_function
-- ----------------------------

-- ----------------------------
-- Table structure for `steelsale_steel`
-- ----------------------------
DROP TABLE IF EXISTS `steelsale_steel`;
CREATE TABLE `steelsale_steel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '钢材id',
  `brand_id` int(11) DEFAULT NULL COMMENT '钢材品牌id',
  `sale` double(50,0) DEFAULT NULL COMMENT '钢材售价',
  `type` varchar(50) DEFAULT NULL COMMENT '钢材类型',
  `repertory` double(11,0) DEFAULT NULL COMMENT '钢材库存',
  `satus` tinyint(1) DEFAULT '1' COMMENT '商品状态 0：停售 1 ：在售',
  `volume` double(11,0) DEFAULT NULL COMMENT '商品销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='钢材商品表';

-- ----------------------------
-- Records of steelsale_steel
-- ----------------------------
INSERT INTO `steelsale_steel` VALUES ('1', '1', '200', '角钢', '11', '1', '10');
