/*
 Navicat Premium Data Transfer

 Source Server         : javaweb
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : asdatabase

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 14/05/2019 22:30:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sclass
-- ----------------------------
DROP TABLE IF EXISTS `sclass`;
CREATE TABLE `sclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sclass
-- ----------------------------
INSERT INTO `sclass` VALUES (1, 'qwe');
INSERT INTO `sclass` VALUES (2, 'qwe');
INSERT INTO `sclass` VALUES (3, '213');
INSERT INTO `sclass` VALUES (4, '245r');

-- ----------------------------
-- Table structure for slesson
-- ----------------------------
DROP TABLE IF EXISTS `slesson`;
CREATE TABLE `slesson`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startTime` time(1) NULL DEFAULT NULL,
  `weekend` int(11) NULL DEFAULT NULL,
  `class_id` int(11) NULL DEFAULT NULL,
  `sUser_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for srecord
-- ----------------------------
DROP TABLE IF EXISTS `srecord`;
CREATE TABLE `srecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sUser_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordTime` datetime(0) NULL DEFAULT NULL,
  `sLesson_id` int(11) NULL DEFAULT NULL,
  `lng` float(53, 0) NULL DEFAULT NULL,
  `lat` float(53, 0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of srecord
-- ----------------------------
INSERT INTO `srecord` VALUES (1, '1', '2019-05-10 21:01:29', 1, 1, 1, 1);
INSERT INTO `srecord` VALUES (2, '1', '2019-05-10 21:01:29', 1, 1, 1, 1);

-- ----------------------------
-- Table structure for suser
-- ----------------------------
DROP TABLE IF EXISTS `suser`;
CREATE TABLE `suser`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `type` int(255) NULL DEFAULT NULL COMMENT '用户类型',
  `class_id` int(11) NULL DEFAULT NULL COMMENT '班级ID',
  `number` int(11) NULL DEFAULT NULL COMMENT '学号/职工号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suser
-- ----------------------------
INSERT INTO `suser` VALUES (1, '张三', '123456', 1, 123, 123456, NULL);
INSERT INTO `suser` VALUES (2, '李四', '654123', 2, NULL, 312121212, NULL);

SET FOREIGN_KEY_CHECKS = 1;
