/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1 root - root
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : sampledb

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 18/02/2021 10:55:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for security_user
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user`  (
  `uid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统账号',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `benabled` int(11) NULL DEFAULT 0 COMMENT '状态(0:正常)',
  `sphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `dcreatedate` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('admin', 'admin', '$2a$10$B0eoP1JgOysQ0S9Uuy.JoOYXdmGK.5lU2TwiKWaByN9EAlaPny8Pe', 0, '', NULL);
INSERT INTO `security_user` VALUES ('test', 'test', '$2a$10$NmjnRHTz0BczV/WWgpZgmeYMJXyDOS3jtsu5OGO6GiGIZjha0Ni2G', 0, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
