/*
 Navicat Premium Data Transfer

 Source Server         : 京东云
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 116.198.43.90:3306
 Source Schema         : soccer_club

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 16/06/2024 17:07:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_footballteam
-- ----------------------------
DROP TABLE IF EXISTS `tb_footballteam`;
CREATE TABLE `tb_footballteam`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teamName` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '球队名',
  `location` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '球队位置',
  `ordered` int NOT NULL COMMENT '排序字段',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述信息',
  `status` int NOT NULL COMMENT '状态：0：禁用  1：启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_footballteam
-- ----------------------------
INSERT INTO `tb_footballteam` VALUES (1, '阿森纳', '北伦敦', 1, '北伦敦之王', 1);
INSERT INTO `tb_footballteam` VALUES (2, '曼城', '曼彻斯特', 2, '蓝月军团', 1);
INSERT INTO `tb_footballteam` VALUES (3, '曼联', '曼彻斯特', 3, '欧洲红魔', 0);
INSERT INTO `tb_footballteam` VALUES (4, '利物浦', '利物浦', 4, '铁血红军', 1);
INSERT INTO `tb_footballteam` VALUES (5, '切尔西', '伦敦', 5, '铁血蓝军', 1);
INSERT INTO `tb_footballteam` VALUES (6, '热刺', '北伦敦', 6, '白鹿巷', 1);
INSERT INTO `tb_footballteam` VALUES (7, '皇马', '马德里', 7, '白衣军团', 1);
INSERT INTO `tb_footballteam` VALUES (8, '巴萨', '巴塞罗那', 7, '宇宙队', 1);
INSERT INTO `tb_footballteam` VALUES (9, '拜仁', '慕尼黑', 8, '南大王', 1);
INSERT INTO `tb_footballteam` VALUES (10, '多特蒙德', '多特蒙德', 9, '欧洲强队', 1);
INSERT INTO `tb_footballteam` VALUES (11, '亚特兰大', '亚特兰大', 9, '蓝黑军团', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '12345678');

SET FOREIGN_KEY_CHECKS = 1;
