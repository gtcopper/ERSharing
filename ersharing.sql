/*
Navicat MySQL Data Transfer

Source Server         : copper
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ersharing

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-02-10 20:22:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `enterprise_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `enterprise_name` varchar(45) DEFAULT NULL COMMENT '公司名称',
  `enterprise_address` text COMMENT '公司地址',
  `enterprise_license` varchar(120) DEFAULT NULL COMMENT '营业执照',
  `enterprise_legalRepresentative` varchar(45) DEFAULT NULL COMMENT '法定代表人',
  `enterprise_issueDate` datetime DEFAULT NULL COMMENT '发照日期',
  `enterprise_category_id` int(11) DEFAULT NULL COMMENT '公司分类',
  `enterprise_email` varchar(45) DEFAULT NULL COMMENT '公司邮箱',
  `inform_id` int(11) DEFAULT NULL COMMENT '关注id',
  `enterprise_logo` varchar(120) DEFAULT NULL COMMENT '公司标志',
  `enterprise_transactionTime` int(11) DEFAULT NULL COMMENT '公司交易次数',
  `enterprise_user` varchar(45) NOT NULL COMMENT '企业登录用户',
  `enterprise_password` varchar(45) NOT NULL COMMENT '公司帐号密码',
  `enterprise_phone` varchar(45) NOT NULL COMMENT '企业联系方式',
  PRIMARY KEY (`enterprise_id`),
  KEY `fk_enterprise_enterprise_category1_idx` (`enterprise_category_id`),
  KEY `fk_enterprise_inform1_idx` (`inform_id`),
  CONSTRAINT `fk_enterprise_enterprise_category1` FOREIGN KEY (`enterprise_category_id`) REFERENCES `enterprise_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='公司';


-- ----------------------------
-- Table structure for `enterprise_address`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_address`;
CREATE TABLE `enterprise_address` (
  `enterprise_id` int(11) NOT NULL,
  `enterprise_address` varchar(90) DEFAULT NULL,
  `enterprise_province` varchar(45) DEFAULT NULL,
  `enterprise_city` varchar(45) DEFAULT NULL,
  KEY `fk_enterprise_address_enterprise1_idx` (`enterprise_id`),
  CONSTRAINT `fk_enterprise_address_enterprise1` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收货地址';

-- ----------------------------
-- Table structure for `enterprise_category`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_category`;
CREATE TABLE `enterprise_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '种类id',
  `category_parent_id` int(11) DEFAULT NULL COMMENT '父亲节点id',
  `category_name` varchar(45) DEFAULT NULL COMMENT '分类名称',
  `category_description` text COMMENT '分类描述',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `enterprise_comment`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_comment`;
CREATE TABLE `enterprise_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `commenting_enterprise_id` int(11) NOT NULL COMMENT '评论的公司',
  `commented_enterprise_id` int(11) NOT NULL COMMENT '被评论的公司',
  `comment_score` int(11) DEFAULT NULL COMMENT '评分',
  `comment_image` varchar(45) DEFAULT NULL COMMENT '评论图片',
  `anonymity_enterprise` int(11) DEFAULT NULL COMMENT '是否匿名 1 不匿名 0 匿名',
  `comment_content` text COMMENT '评论内容',
  PRIMARY KEY (`comment_id`),
  KEY `fk_comment_enterprise1_idx` (`commenting_enterprise_id`),
  KEY `fk_comment_enterprise2_idx` (`commented_enterprise_id`),
  CONSTRAINT `fk_comment_enterprise1` FOREIGN KEY (`commenting_enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_enterprise2` FOREIGN KEY (`commented_enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_image` varchar(255) DEFAULT NULL,
  `feedback_text` varchar(255) DEFAULT NULL,
  `enterprise_id` int(45) DEFAULT NULL,
  `anonmity` int(11) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `inform`
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `inform_id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_id` int(11) NOT NULL COMMENT '用户所在公司',
  `enterprise_followid` int(11) NOT NULL COMMENT '关注的公司',
  `follow_time` datetime DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`inform_id`),
  KEY `fk_follow_inform_enterprise1_idx` (`enterprise_id`),
  CONSTRAINT `fk_follow_inform_enterprise1` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(120) NOT NULL,
  `manager_password` varchar(120) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `praise`
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `praise_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `enterprise_id` int(11) NOT NULL,
  PRIMARY KEY (`praise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `sharing_enterprise_id` int(11) NOT NULL COMMENT '共享者企业id',
  `accept_enterprise_id` int(11) NOT NULL COMMENT '接受者企业id',
  `record_tradeTime` datetime DEFAULT NULL COMMENT '资源交易时间',
  `record_payment` float DEFAULT NULL COMMENT '资源交易金额',
  `resources_id` int(11) NOT NULL COMMENT '资源id',
  `record_resources_number` int(11) DEFAULT NULL COMMENT '资源数量',
  `record_resource_operateType` int(11) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `fk_record_enterprise1_idx` (`sharing_enterprise_id`),
  KEY `fk_record_enterprise2_idx` (`accept_enterprise_id`),
  KEY `fk_record_resources1_idx` (`resources_id`),
  CONSTRAINT `fk_record_enterprise1` FOREIGN KEY (`sharing_enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_record_enterprise2` FOREIGN KEY (`accept_enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_record_resources1` FOREIGN KEY (`resources_id`) REFERENCES `resources` (`resources_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `resources_id` int(11) NOT NULL AUTO_INCREMENT,
  `resources_category_id` int(11) NOT NULL COMMENT '资源类别id',
  `enterprise_id` int(11) NOT NULL COMMENT '公司id',
  `enterprise_city` varchar(45) NOT NULL COMMENT '资源地点',
  `resources_name` varchar(45) NOT NULL COMMENT '资源名称',
  `resources_desc` text NOT NULL COMMENT '资源描述',
  `resources_price` float NOT NULL COMMENT '资源价格',
  `resources_createTime` datetime DEFAULT NULL COMMENT '资源发布时间',
  `resources_updateTime` datetime DEFAULT NULL COMMENT '资源更新时间',
  `resources_status` int(11) DEFAULT NULL COMMENT '资源状态 1 正常可交易状态  -1 取消共享状态 0 交易完成',
  `resources_count` int(11) NOT NULL COMMENT '资源数量',
  `resources_operateType` int(11) DEFAULT NULL COMMENT '资源操作类型 0---请求资源  1---发布资源',
  `resources_image` varchar(1024) DEFAULT NULL COMMENT '资源图片',
  `resources_transactionTime` int(11) DEFAULT NULL COMMENT '资源交易次数',
  `resources_agencyFee` double(16,2) DEFAULT NULL,
  PRIMARY KEY (`resources_id`),
  KEY `fk_resources_resources_category1_idx` (`resources_category_id`),
  KEY `fk_resources_enterprise1_idx` (`enterprise_id`),
  CONSTRAINT `fk_resources_enterprise1` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_resources_resources_category1` FOREIGN KEY (`resources_category_id`) REFERENCES `resources_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `resources_category`
-- ----------------------------
DROP TABLE IF EXISTS `resources_category`;
CREATE TABLE `resources_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_parent_id` int(11) DEFAULT NULL COMMENT '父亲节点id',
  `category_name` varchar(45) DEFAULT NULL COMMENT '分类名称',
  `resources_description` text COMMENT '分类描述',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources_category
-- ----------------------------
INSERT INTO `resources_category` VALUES ('1', '0', '纺织设备', '纺织类');
INSERT INTO `resources_category` VALUES ('2', '0', '冶金设备', '冶金类');
INSERT INTO `resources_category` VALUES ('3', '0', '动力设备', '动力类');
INSERT INTO `resources_category` VALUES ('4', '0', '化工设备', '化工二类');
INSERT INTO `resources_category` VALUES ('5', '1', '棉纺织设备', '棉纺织类');
INSERT INTO `resources_category` VALUES ('6', '1', '化纤设备', '化纤类');
INSERT INTO `resources_category` VALUES ('7', '0', '其他', '其他类');
INSERT INTO `resources_category` VALUES ('8', '3', '起重运输设备', '起重运输类');
INSERT INTO `resources_category` VALUES ('9', '3', '木工锻造设备', '木工锻造');
INSERT INTO `resources_category` VALUES ('10', '4', '反应设备', '反应设备类');
INSERT INTO `resources_category` VALUES ('11', '4', '过滤设备', '过滤类');

-- ----------------------------
-- Table structure for `resources_comment`
-- ----------------------------
DROP TABLE IF EXISTS `resources_comment`;
CREATE TABLE `resources_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `resources_id` int(11) NOT NULL COMMENT '资源Id',
  `enterprise_id` int(11) DEFAULT NULL COMMENT '评论的公司',
  `comment_content` text COMMENT '评论内容',
  `comment_image` varchar(120) DEFAULT NULL COMMENT '评论图片',
  `anonymity_enterprise` int(11) DEFAULT NULL COMMENT '是否匿名 1 不匿名 0 匿名',
  `comment_time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_resources_comment_resources1_idx` (`resources_id`),
  KEY `fk_resources_comment_enterprise1_idx` (`enterprise_id`),
  CONSTRAINT `fk_resources_comment_enterprise1` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`enterprise_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_resources_comment_resources1` FOREIGN KEY (`resources_id`) REFERENCES `resources` (`resources_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

