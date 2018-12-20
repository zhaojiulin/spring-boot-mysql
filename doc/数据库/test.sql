/*
Navicat MySQL Data Transfer

Source Server         : 本地测试
Source Server Version : 50720
Source Host           : 127.0.0.1:3309
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-18 11:50:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_topics
-- ----------------------------
DROP TABLE IF EXISTS `t_topics`;
CREATE TABLE `t_topics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT '0' COMMENT '发布人',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `type` tinyint(4) DEFAULT NULL COMMENT '显示类型',
  `url` varchar(200) DEFAULT NULL,
  `content` mediumtext COMMENT '内容',
  `img` varchar(200) DEFAULT NULL COMMENT '图片',
  `order` int(10) DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态 0待审核，1:审核成功 -1：审核失败',
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '2' COMMENT '是否推荐 1:是 2 否',
  `is_recommend` tinyint(4) DEFAULT '2' COMMENT '是否推荐 1:是 2 否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_topic_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_reply`;
CREATE TABLE `t_topic_reply` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT '0' COMMENT '用户id',
  `topic_id` bigint(20) DEFAULT NULL,
  `topic_reply_id` bigint(20) DEFAULT '0',
  `content` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_level
-- ----------------------------
DROP TABLE IF EXISTS `t_user_level`;
CREATE TABLE `t_user_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `level` tinyint(2) DEFAULT '1' COMMENT '会员类型 1 V1 2 V2 3 V3 4 V4 5 V5 6 V6.........',
  `amount` decimal(20,2) DEFAULT '0.00' COMMENT '总消费金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT '' COMMENT '昵称',
  `mobile` varchar(255) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `score` int(10) DEFAULT '0' COMMENT '积分',
  `type` tinyint(4) DEFAULT '1' COMMENT '账户类型（1）',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_terminate` tinyint(2) DEFAULT '0' COMMENT '是否注销（1：已注销，0：正常，2:已锁定）',
  `unique_code` varchar(255) DEFAULT NULL COMMENT ' 专属码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
