/*
 Navicat Premium Data Transfer

 Source Server         : liuyun
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : dhjc

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 25/05/2020 12:51:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_area
-- ----------------------------
DROP TABLE IF EXISTS `c_area`;
CREATE TABLE `c_area`  (
  `id` int(10) NOT NULL COMMENT '区域ID',
  `parentId` int(10) NULL DEFAULT NULL COMMENT '父级区域ID',
  `areaName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_area
-- ----------------------------
INSERT INTO `c_area` VALUES (420000, 0, '湖北省');
INSERT INTO `c_area` VALUES (420100, 420000, '武汉市');
INSERT INTO `c_area` VALUES (420102, 420100, '江岸区');
INSERT INTO `c_area` VALUES (420103, 420100, '江汉区');
INSERT INTO `c_area` VALUES (420104, 420100, '硚口区');
INSERT INTO `c_area` VALUES (420105, 420100, '汉阳区');
INSERT INTO `c_area` VALUES (420106, 420100, '武昌区');
INSERT INTO `c_area` VALUES (420107, 420100, '青山区');
INSERT INTO `c_area` VALUES (420111, 420100, '洪山区');
INSERT INTO `c_area` VALUES (420112, 420100, '东西湖区');
INSERT INTO `c_area` VALUES (420113, 420100, '汉南区');
INSERT INTO `c_area` VALUES (420114, 420100, '蔡甸区');
INSERT INTO `c_area` VALUES (420115, 420100, '江夏区');
INSERT INTO `c_area` VALUES (420116, 420100, '黄陂区');
INSERT INTO `c_area` VALUES (420117, 420100, '新洲区');
INSERT INTO `c_area` VALUES (420200, 420000, '黄石市');
INSERT INTO `c_area` VALUES (420300, 420000, '十堰市');
INSERT INTO `c_area` VALUES (420500, 420000, '宜昌市');
INSERT INTO `c_area` VALUES (420600, 420000, '襄阳市');
INSERT INTO `c_area` VALUES (420700, 420000, '鄂州市');
INSERT INTO `c_area` VALUES (420800, 420000, '荆门市');
INSERT INTO `c_area` VALUES (420900, 420000, '孝感市');
INSERT INTO `c_area` VALUES (421000, 420000, '荆州市');
INSERT INTO `c_area` VALUES (421100, 420000, '黄冈市');
INSERT INTO `c_area` VALUES (421200, 420000, '咸宁市');
INSERT INTO `c_area` VALUES (421300, 420000, '随州市');
INSERT INTO `c_area` VALUES (422800, 420000, '恩施州');

-- ----------------------------
-- Table structure for c_deviceinfor
-- ----------------------------
DROP TABLE IF EXISTS `c_deviceinfor`;
CREATE TABLE `c_deviceinfor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `deviceName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备名',
  `schoolId` int(3) NOT NULL COMMENT '所属学校ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_dsignal
-- ----------------------------
DROP TABLE IF EXISTS `c_dsignal`;
CREATE TABLE `c_dsignal`  (
  `DSIG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSIG_Value` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '采集值',
  `DSIG_SIG_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  `DSIG_DateTime` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  `schoolId` int(11) NULL DEFAULT NULL COMMENT '所属学校ID',
  PRIMARY KEY (`DSIG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7213 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_facility
-- ----------------------------
DROP TABLE IF EXISTS `c_facility`;
CREATE TABLE `c_facility`  (
  `FAC_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `FAC_Code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `FAC_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型名称',
  PRIMARY KEY (`FAC_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_facility
-- ----------------------------
INSERT INTO `c_facility` VALUES (1, 'FAC001', '雅达111684电表屏');
INSERT INTO `c_facility` VALUES (2, 'FAC002', 'RTST_IO模块');
INSERT INTO `c_facility` VALUES (3, 'FAC003', 'TCL空调');

-- ----------------------------
-- Table structure for c_schoolinfor
-- ----------------------------
DROP TABLE IF EXISTS `c_schoolinfor`;
CREATE TABLE `c_schoolinfor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学校ID',
  `schoolName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名',
  `belongArea` int(10) NOT NULL COMMENT '学校所属区域ID',
  `location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校详细地址',
  `lngAndLat` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_signal
-- ----------------------------
DROP TABLE IF EXISTS `c_signal`;
CREATE TABLE `c_signal`  (
  `SIG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `SIG_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '编号',
  `SIG_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号名称',
  `SIG_Unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号单位',
  `SIG_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号类型',
  `SIG_FAC_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号设备编号',
  `SIG_Address` int(11) NULL DEFAULT NULL COMMENT '寄存器开始地址',
  `SIG_AddressNum` int(11) NULL DEFAULT NULL COMMENT '地址个数',
  `SIG_DataType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SIG_State` int(11) NULL DEFAULT 0 COMMENT '参数状态值，表示是否启用',
  `flag` int(10) NULL DEFAULT NULL COMMENT '电表分类',
  `typeFlag` int(2) NULL DEFAULT 0 COMMENT 'IO模块温度湿度标识',
  PRIMARY KEY (`SIG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_signalcollect
-- ----------------------------
DROP TABLE IF EXISTS `c_signalcollect`;
CREATE TABLE `c_signalcollect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comPort` int(11) NULL DEFAULT NULL COMMENT 'COM端口号',
  `deviceId` int(11) NULL DEFAULT NULL COMMENT '设备ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_site
-- ----------------------------
DROP TABLE IF EXISTS `c_site`;
CREATE TABLE `c_site`  (
  `siteId` int(10) NOT NULL AUTO_INCREMENT COMMENT '学校下属机房站点ID',
  `schoolId` int(10) NULL DEFAULT NULL COMMENT '学校ID',
  `siteName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机房名',
  PRIMARY KEY (`siteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `permissionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `filePath` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `id` int(11) NULL DEFAULT NULL COMMENT '页面ID',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '页面父ID',
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `resourceType` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径url',
  `iconPath` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标路径',
  PRIMARY KEY (`permissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '/', 1, 0, '/', '首页', 'vue', '/', 'dashboard');
INSERT INTO `sys_permission` VALUES (2, '/electric-report', 2, 0, '/electric-report', '历史查询', 'vue', '/electric-report', 'ElectricReport');
INSERT INTO `sys_permission` VALUES (3, '/history', 3, 2, 'electric', '电能', 'vue', '/electric', 'place');
INSERT INTO `sys_permission` VALUES (4, '/history', 4, 2, 'three', '三楼信息', 'vue', '/three', 'ElectricReport');
INSERT INTO `sys_permission` VALUES (5, '/history', 5, 2, 'four', '四楼信息', 'vue', '/four', 'signal');
INSERT INTO `sys_permission` VALUES (6, '/alarm', 6, 0, '/alarm', '告警', 'vue', '/alarm', 'alarmstatistics');
INSERT INTO `sys_permission` VALUES (7, '/manage', 7, 0, '/manage', '通讯管理', 'vue', '/manage', 'manage');
INSERT INTO `sys_permission` VALUES (8, '/signal', 8, 0, '/signal', '信号采集', 'vue', '/signal', 'signal');
INSERT INTO `sys_permission` VALUES (9, '/place', 9, 0, '/place', '学校', 'vue', '/place', 'place');
INSERT INTO `sys_permission` VALUES (10, '/userManage', 10, 0, '/userManage', '用户管理', 'vue', '/userManage', 'place');
INSERT INTO `sys_permission` VALUES (11, '/getData', 11, 0, '/getData', '设备参数', 'vue', '/getData', 'place');
INSERT INTO `sys_permission` VALUES (12, '/roles', 12, 0, '/roles', '权限管理', 'vue', '/roles', 'place');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `available` int(11) NULL DEFAULT NULL COMMENT '是否启用',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 1, '管理员', 'admin');
INSERT INTO `sys_role` VALUES (2, 1, '测试人员', 'test');
INSERT INTO `sys_role` VALUES (3, 1, '会员', 'VIP');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `permissionId` int(10) NOT NULL COMMENT '权限ID',
  `roleId` int(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `roleId_permissionId`(`permissionId`, `roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (2, 2, 1);
INSERT INTO `sys_role_permission` VALUES (3, 3, 1);
INSERT INTO `sys_role_permission` VALUES (4, 4, 1);
INSERT INTO `sys_role_permission` VALUES (5, 5, 1);
INSERT INTO `sys_role_permission` VALUES (6, 6, 1);
INSERT INTO `sys_role_permission` VALUES (7, 7, 1);
INSERT INTO `sys_role_permission` VALUES (8, 8, 1);
INSERT INTO `sys_role_permission` VALUES (9, 9, 1);
INSERT INTO `sys_role_permission` VALUES (10, 10, 1);
INSERT INTO `sys_role_permission` VALUES (11, 11, 1);
INSERT INTO `sys_role_permission` VALUES (12, 12, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `roleId` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 3 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for sys_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_userinfo`;
CREATE TABLE `sys_userinfo`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `expiredDate` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态',
  `userName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `schoolId` int(11) NULL DEFAULT NULL COMMENT '学校ID',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_userinfo
-- ----------------------------
INSERT INTO `sys_userinfo` VALUES (1, '2020-04-14 10:10:10', '2021-04-14 00:00:00', 'e10adc3949ba59abbe56e057f20f883e', 1, 'admin', 1);

SET FOREIGN_KEY_CHECKS = 1;
