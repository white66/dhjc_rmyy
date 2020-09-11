/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : rmyy

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 10/09/2020 10:33:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_alarm
-- ----------------------------
DROP TABLE IF EXISTS `c_alarm`;
CREATE TABLE `c_alarm`  (
  `Warn_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Warn_DateTime` datetime(0) NULL DEFAULT NULL COMMENT '报警时间',
  `Warn_Content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警信息',
  `organizationId` int(11) NULL DEFAULT NULL COMMENT '组织ID',
  `Warn_SIG_Code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  PRIMARY KEY (`Warn_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `c_area` VALUES (421022, 421000, '公安县');
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
  `organizationId` int(3) NOT NULL COMMENT '所属学校ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_dsignal
-- ----------------------------
DROP TABLE IF EXISTS `c_dsignal`;
CREATE TABLE `c_dsignal`  (
  `DSIG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSIG_Value` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '采集值',
  `DSIG_SIG_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  `DSIG_DateTime` datetime(0) NULL DEFAULT NULL COMMENT '采集时间',
  `organizationId` int(11) NULL DEFAULT NULL COMMENT '所属组织ID',
  PRIMARY KEY (`DSIG_ID`) USING BTREE,
  INDEX `time_index`(`DSIG_DateTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_energyday
-- ----------------------------
DROP TABLE IF EXISTS `c_energyday`;
CREATE TABLE `c_energyday`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `energyValue` float(10, 2) NULL DEFAULT 0.00 COMMENT '日耗电能值',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日期',
  `sigCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_energymonth
-- ----------------------------
DROP TABLE IF EXISTS `c_energymonth`;
CREATE TABLE `c_energymonth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `energyValue` float(10, 2) NULL DEFAULT NULL COMMENT '月电能能耗值',
  `sigCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '月份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_energyyear
-- ----------------------------
DROP TABLE IF EXISTS `c_energyyear`;
CREATE TABLE `c_energyyear`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `energyValue` float(10, 2) NULL DEFAULT NULL COMMENT '年电能能耗值',
  `sigCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数码',
  `dateTime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_facility
-- ----------------------------
DROP TABLE IF EXISTS `c_facility`;
CREATE TABLE `c_facility`  (
  `FAC_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `FAC_Code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `FAC_Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型名称',
  PRIMARY KEY (`FAC_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_facility
-- ----------------------------
INSERT INTO `c_facility` VALUES (1, 'FAC001', '雅达111684电表屏');
INSERT INTO `c_facility` VALUES (2, 'FAC002', 'RTST_IO模块');
INSERT INTO `c_facility` VALUES (3, 'FAC003', 'TCL空调');
INSERT INTO `c_facility` VALUES (4, 'FAC004', 'UPS');

-- ----------------------------
-- Table structure for c_organization
-- ----------------------------
DROP TABLE IF EXISTS `c_organization`;
CREATE TABLE `c_organization`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织ID',
  `organizationName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组织名',
  `belongArea` int(10) NOT NULL COMMENT '组织所属区域ID',
  `location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织详细地址',
  `lngAndLat` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经纬度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_organization
-- ----------------------------
INSERT INTO `c_organization` VALUES (1, '荆州市公安县人民医院', 421022, '荆州市公安县', '36.5,48');

-- ----------------------------
-- Table structure for c_signal
-- ----------------------------
DROP TABLE IF EXISTS `c_signal`;
CREATE TABLE `c_signal`  (
  `SIG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `SIG_Code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '编号',
  `SIG_Name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号名称',
  `SIG_Unit` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号单位',
  `SIG_Type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号类型',
  `SIG_FAC_ID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信号设备编号',
  `SIG_Address` int(11) NULL DEFAULT NULL COMMENT '寄存器开始地址',
  `SIG_AddressNum` int(11) NULL DEFAULT NULL COMMENT '地址个数',
  `SIG_DataType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SIG_State` int(11) NULL DEFAULT 0 COMMENT '参数状态值，表示是否启用',
  `flag` int(11) NULL DEFAULT NULL COMMENT '模块区分，表示区分机房',
  `typeFlag` int(11) NULL DEFAULT 0 COMMENT 'IO模块温度湿度标识',
  PRIMARY KEY (`SIG_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 229 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_signal
-- ----------------------------
INSERT INTO `c_signal` VALUES (1, 'SIG0001', 'A相电压(机房1)', 'V', '配电参数', 'FAC001', 0, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (2, 'SIG0002', 'B相电压(机房1)', 'V', '配电参数', 'FAC001', 4, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (3, 'SIG0003', 'C相电压(机房1)', 'V', '配电参数', 'FAC001', 8, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (4, 'SIG0004', 'A相电流(机房1)', 'A', '配电参数', 'FAC001', 12, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (5, 'SIG0005', 'B相电流(机房1)', 'A', '配电参数', 'FAC001', 16, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (6, 'SIG0006', 'C相电流(机房1)', 'A', '配电参数', 'FAC001', 20, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (7, 'SIG0007', 'A相功率(机房1)', 'kW', '配电参数', 'FAC001', 24, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (8, 'SIG0008', 'B相功率(机房1)', 'kW', '配电参数', 'FAC001', 28, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (9, 'SIG0009', 'C相功率(机房1)', 'kW', '配电参数', 'FAC001', 32, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (10, 'SIG0010', '正向有功电能(机房1)', 'kWh', '配电参数', 'FAC001', 36, 4, '32flaot', 1, 1, 0);
INSERT INTO `c_signal` VALUES (11, 'SIG0011', '温度1(机房1)', '℃', 'IO参数', 'FAC002', 40, 4, '32flaot', 1, 1, 1);
INSERT INTO `c_signal` VALUES (12, 'SIG0012', '温度2(机房1)', '℃', 'IO参数', 'FAC002', 44, 4, '32flaot', 1, 1, 1);
INSERT INTO `c_signal` VALUES (13, 'SIG0013', '湿度(机房1)', '%', 'IO参数', 'FAC002', 48, 4, '32flaot', 1, 1, 2);
INSERT INTO `c_signal` VALUES (14, 'SIG0014', '水浸(机房1)', '', 'IO参数', 'FAC002', 52, 4, '32flaot', 1, 1, 3);
INSERT INTO `c_signal` VALUES (15, 'SIG0015', '烟感(机房1)', '', 'IO参数', 'FAC002', 56, 4, '32flaot', 1, 1, 4);
INSERT INTO `c_signal` VALUES (16, 'SIG0016', 'A相电压(机房2)', 'V', '配电参数', 'FAC001', 0, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (17, 'SIG0017', 'B相电压(机房2)', 'V', '配电参数', 'FAC001', 4, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (18, 'SIG0018', 'C相电压(机房2)', 'V', '配电参数', 'FAC001', 8, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (19, 'SIG0019', 'A相电流(机房2)', 'A', '配电参数', 'FAC001', 12, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (20, 'SIG0020', 'B相电流(机房2)', 'A', '配电参数', 'FAC001', 16, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (21, 'SIG0021', 'C相电流(机房2)', 'A', '配电参数', 'FAC001', 20, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (22, 'SIG0022', 'A相功率(机房2)', 'kW', '配电参数', 'FAC001', 24, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (23, 'SIG0023', 'B相功率(机房2)', 'kW', '配电参数', 'FAC001', 28, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (24, 'SIG0024', 'C相功率(机房2)', 'kW', '配电参数', 'FAC001', 32, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (25, 'SIG0025', '正向有功电能(机房2)', 'kWh', '配电参数', 'FAC001', 36, 4, '32flaot', 1, 2, 0);
INSERT INTO `c_signal` VALUES (26, 'SIG0026', '温度1(机房2)', '℃', 'IO参数', 'FAC002', 40, 4, '32flaot', 1, 2, 1);
INSERT INTO `c_signal` VALUES (27, 'SIG0027', '温度2(机房2)', '℃', 'IO参数', 'FAC002', 44, 4, '32flaot', 1, 2, 1);
INSERT INTO `c_signal` VALUES (28, 'SIG0028', '湿度(机房2)', '%', 'IO参数', 'FAC002', 48, 4, '32flaot', 1, 2, 2);
INSERT INTO `c_signal` VALUES (29, 'SIG0029', '水浸(机房2)', '', 'IO参数', 'FAC002', 52, 4, '32flaot', 1, 2, 3);
INSERT INTO `c_signal` VALUES (30, 'SIG0030', '烟感(机房2)', '', 'IO参数', 'FAC002', 56, 4, '32flaot', 1, 2, 4);
INSERT INTO `c_signal` VALUES (36, 'SIG0036', '输入A相电压', 'v', 'UPS参数', 'FAC004', 80, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (37, 'SIG0037', '输入B相电压', 'v', 'UPS参数', 'FAC004', 84, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (38, 'SIG0038', '输入C相电压', 'v', 'UPS参数', 'FAC004', 88, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (39, 'SIG0039', '输入频率', 'HZ', 'UPS参数', 'FAC004', 92, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (40, 'SIG0040', '输入A相电流', 'A', 'UPS参数', 'FAC004', 96, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (41, 'SIG0041', '输入B相电流', 'A', 'UPS参数', 'FAC004', 100, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (42, 'SIG0042', '输入C相电流', 'A', 'UPS参数', 'FAC004', 104, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (43, 'SIG0043', '输入A相功因', '', 'UPS参数', 'FAC004', 108, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (44, 'SIG0044', '输入B相功因', '', 'UPS参数', 'FAC004', 112, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (45, 'SIG0045', '输入C相功因', '', 'UPS参数', 'FAC004', 116, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (46, 'SIG0046', '输出A相电压', 'v', 'UPS参数', 'FAC004', 120, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (47, 'SIG0047', '输出B相电压', 'v', 'UPS参数', 'FAC004', 124, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (48, 'SIG0048', '输出相C电压', 'v', 'UPS参数', 'FAC004', 128, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (49, 'SIG0049', '输出频率', 'HZ', 'UPS参数', 'FAC004', 132, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (50, 'SIG0050', '输出A相电流', 'A', 'UPS参数', 'FAC004', 136, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (51, 'SIG0051', '输出B相电流', 'A', 'UPS参数', 'FAC004', 140, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (52, 'SIG0052', '输出C相电流', 'A', 'UPS参数', 'FAC004', 144, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (53, 'SIG0053', '输出A相有功功率', 'KW', 'UPS参数', 'FAC004', 148, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (54, 'SIG0054', '输出B相有功功率', 'KW', 'UPS参数', 'FAC004', 152, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (55, 'SIG0055', '输出C相有功功率', 'KW', 'UPS参数', 'FAC004', 156, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (56, 'SIG0056', '输出A相负载率', '%', 'UPS参数', 'FAC004', 160, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (57, 'SIG0057', '输出B相负载率', '%', 'UPS参数', 'FAC004', 164, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (58, 'SIG0058', '输出C相负载率', '%', 'UPS参数', 'FAC004', 168, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (59, 'SIG0059', '输出A相负载峰值比', '', 'UPS参数', 'FAC004', 172, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (60, 'SIG0060', '输出B相负载峰值比', '', 'UPS参数', 'FAC004', 176, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (61, 'SIG0061', '输出C相负载峰值比', '', 'UPS参数', 'FAC004', 180, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (62, 'SIG0062', '旁路A相电压', 'v', 'UPS参数', 'FAC004', 184, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (63, 'SIG0063', '旁路B相电压', 'v', 'UPS参数', 'FAC004', 188, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (64, 'SIG0064', '旁路C相电压', 'v', 'UPS参数', 'FAC004', 192, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (65, 'SIG0065', '旁路频率', 'Hz', 'UPS参数', 'FAC004', 196, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (66, 'SIG0066', '正组电池电压', 'v', 'UPS参数', 'FAC004', 200, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (67, 'SIG0067', '夫组电池电压', 'v', 'UPS参数', 'FAC004', 204, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (68, 'SIG0068', '正组电池放电电流', 'v', 'UPS参数', 'FAC004', 208, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (69, 'SIG0069', '负组电池放电电流', 'A', 'UPS参数', 'FAC004', 212, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (70, 'SIG0070', '正组电池充电电流', 'A', 'UPS参数', 'FAC004', 216, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (71, 'SIG0071', '负组电池充电电流', 'A', 'UPS参数', 'FAC004', 220, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (72, 'SIG0072', '电池容量率', '%', 'UPS参数', 'FAC004', 224, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (73, 'SIG0073', '电池后备时间', '分钟', 'UPS参数', 'FAC004', 228, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (74, 'SIG0074', '电池温度', '', 'UPS参数', 'FAC004', 232, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (75, 'SIG0075', '环境温度', '', 'UPS参数', 'FAC004', 236, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (76, 'SIG0076', '电池放电时间', '分钟', 'UPS参数', 'FAC004', 240, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (77, 'SIG0077', '并机上电总台数', '', 'UPS参数', 'FAC004', 244, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (78, 'SIG0078', '并机逆变供电台数', '', 'UPS参数', 'FAC004', 248, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (79, 'SIG0079', '并机输出A相总视在功率', 'VA', 'UPS参数', 'FAC004', 252, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (80, 'SIG0080', '并机输出B相总视在功率', 'VA', 'UPS参数', 'FAC004', 256, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (81, 'SIG0081', '并机输出C相总视在功率', 'VA', 'UPS参数', 'FAC004', 260, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (82, 'SIG0082', '并机输出A相有功功率', 'VW', 'UPS参数', 'FAC004', 264, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (83, 'SIG0083', '并机输出B相有功功率', 'VW', 'UPS参数', 'FAC004', 268, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (84, 'SIG0084', '并机输出C相有功功率', 'VW', 'UPS参数', 'FAC004', 272, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (85, 'SIG0085', '运行状态', '', 'UPS参数', 'FAC004', 276, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (86, 'SIG0086', '整机状态位信息1', '', 'UPS参数', 'FAC004', 280, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (87, 'SIG0087', '整机状态位信息2', '', 'UPS参数', 'FAC004', 284, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (88, 'SIG0088', '整机状态位信息3', '', 'UPS参数', 'FAC004', 288, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (89, 'SIG0089', '整机状态位信息4', '', 'UPS参数', 'FAC004', 292, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (90, 'SIG0090', '整机告警位信息1', '', 'UPS参数', 'FAC004', 296, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (91, 'SIG0091', '整机告警位信息2', '', 'UPS参数', 'FAC004', 300, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (92, 'SIG0092', '整机告警位信息3', '', 'UPS参数', 'FAC004', 304, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (93, 'SIG0093', '整机告警位信息4', '', 'UPS参数', 'FAC004', 308, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (94, 'SIG0094', '监控系统状态位信息', '', 'UPS参数', 'FAC004', 312, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (95, 'SIG0095', '监控系统告警位信息', '', 'UPS参数', 'FAC004', 316, 4, '32flaot', 1, 1, 6);
INSERT INTO `c_signal` VALUES (96, 'SIG0096', 'UPS额定容量', '', 'UPS参数', 'FAC004', 320, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (97, 'SIG0097', '并机系统 ID', '', 'UPS参数', 'FAC004', 324, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (98, 'SIG0098', '机内模块数量', '', 'UPS参数', 'FAC004', 328, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (99, 'SIG0099', '工作模式', '', 'UPS参数', 'FAC004', 332, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (100, 'SIG0100', '系统电压等级', '', 'UPS参数', 'FAC004', 336, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (101, 'SIG0101', '输出频率等级', '', 'UPS参数', 'FAC004', 340, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (102, 'SIG0102', '系统并机总台数', '', 'UPS参数', 'FAC004', 344, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (103, 'SIG0103', '并机冗余台数', '', 'UPS参数', 'FAC004', 348, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (104, 'SIG0104', '旁路切换次数', '', 'UPS参数', 'FAC004', 352, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (105, 'SIG0105', '热备份主从机交替周期', '', 'UPS参数', 'FAC004', 356, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (106, 'SIG0106', '旁路频率跟踪范围', '', 'UPS参数', 'FAC004', 360, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (107, 'SIG0107', '旁路电压保护范围上限', '', 'UPS参数', 'FAC004', 364, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (108, 'SIG0108', '旁路电压保护范围下限', '', 'UPS参数', 'FAC004', 368, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (109, 'SIG0109', '逆变输出电压微调', '', 'UPS参数', 'FAC004', 372, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (110, 'SIG0110', '电池节数', '', 'UPS参数', 'FAC004', 376, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (111, 'SIG0111', '单节电池电压', '', 'UPS参数', 'FAC004', 380, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (112, 'SIG0112', '电池并联组数', '', 'UPS参数', 'FAC004', 384, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (113, 'SIG0113', '均充电压上限', '', 'UPS参数', 'FAC004', 388, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (114, 'SIG0114', '浮充电压基准', '', 'UPS参数', 'FAC004', 392, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (115, 'SIG0115', 'EOD 电压', '', 'UPS参数', 'FAC004', 396, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (116, 'SIG0116', '单节电池容量', '', 'UPS参数', 'FAC004', 400, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (117, 'SIG0117', '电池电压低预报警时间', '', 'UPS参数', 'FAC004', 404, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (118, 'SIG0118', '最大充电电流', '', 'UPS参数', 'FAC004', 408, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (119, 'SIG0119', 'Power walk in', '', 'UPS参数', 'FAC004', 412, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (120, 'SIG0120', '均充持续时间', '', 'UPS参数', 'FAC004', 416, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (121, 'SIG0121', 'LBS 设置', '', 'UPS参数', 'FAC004', 420, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (122, 'SIG0122', '状态控制位', '', 'UPS参数', 'FAC004', 424, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (123, 'SIG0123', '浮充电压温度补偿系数', '', 'UPS参数', 'FAC004', 428, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (124, 'SIG0124', '年月', '', 'UPS参数', 'FAC004', 432, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (125, 'SIG0125', '日时', '', 'UPS参数', 'FAC004', 436, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (126, 'SIG0126', '分秒', '', 'UPS参数', 'FAC004', 440, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (127, 'SIG0127', '高位字节：控制位 低位字节：日（星期）', '', 'UPS参数', 'FAC004', 444, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (128, 'SIG0128', '高位字节：时 低位字节：分', '', 'UPS参数', 'FAC004', 448, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (129, 'SIG0129', '自检时间', '', 'UPS参数', 'FAC004', 452, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (130, 'SIG0130', '额定记录总数(高位字)', '', 'UPS参数', 'FAC004', 456, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (131, 'SIG0131', '额定记录总数(低位字)', '', 'UPS参数', 'FAC004', 460, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (132, 'SIG0132', '已有记录总数(高位字)', '', 'UPS参数', 'FAC004', 464, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (133, 'SIG0133', '已有记录总数(低位字)', '', 'UPS参数', 'FAC004', 468, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (134, 'SIG0134', '当前记录指针(高位字)', '', 'UPS参数', 'FAC004', 472, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (135, 'SIG0135', '当前记录指针(低位字)', '', 'UPS参数', 'FAC004', 476, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (136, 'SIG0136', '高位字节：分组号 低位字节：控制位', '', 'UPS参数', 'FAC004', 480, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (137, 'SIG0137', '高位字节：保留 低位字节：开机日（星期）', '', 'UPS参数', 'FAC004', 484, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (138, 'SIG0138', '高位字节：开机时 低位字节：开机分', '', 'UPS参数', 'FAC004', 488, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (139, 'SIG0139', '高位字节：保留 低位字节：关机日 (星期)', '', 'UPS参数', 'FAC004', 492, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (140, 'SIG0140', '高位字节：关机时 低位字节：关机分', '', 'UPS参数', 'FAC004', 496, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (141, 'SIG0141', '年份', '', 'UPS参数', 'FAC004', 500, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (142, 'SIG0142', '高位字节：月  低位字节：日', '', 'UPS参数', 'FAC004', 504, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (143, 'SIG0143', '运行状态屏蔽字', '', 'UPS参数', 'FAC004', 508, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (144, 'SIG0144', '整机状态位信息 1 屏蔽字', '', 'UPS参数', 'FAC004', 512, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (145, 'SIG0145', '整机状态位信息 2 屏蔽字', '', 'UPS参数', 'FAC004', 516, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (146, 'SIG0146', '整机状态位信息 3 屏蔽字', '', 'UPS参数', 'FAC004', 520, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (147, 'SIG0147', '整机状态位信息 4 屏蔽字', '', 'UPS参数', 'FAC004', 524, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (148, 'SIG0148', '整机告警位信息 1 屏蔽字', '', 'UPS参数', 'FAC004', 528, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (149, 'SIG0149', '整机告警位信息 2 屏蔽字', '', 'UPS参数', 'FAC004', 532, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (150, 'SIG0150', '整机告警位信息 3 屏蔽字', '', 'UPS参数', 'FAC004', 536, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (151, 'SIG0151', '整机告警位信息 4 屏蔽字', '', 'UPS参数', 'FAC004', 540, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (152, 'SIG0152', '监控系统状态位信息屏蔽字', '', 'UPS参数', 'FAC004', 544, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (153, 'SIG0153', '监控系统告警位信息屏蔽字', '', 'UPS参数', 'FAC004', 548, 4, '32flaot', 1, 1, 7);
INSERT INTO `c_signal` VALUES (154, 'SIG0154', '输入空开状态', '', 'UPS参数', 'FAC004', 552, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (155, 'SIG0155', '输出空开状态', '', 'UPS参数', 'FAC004', 556, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (156, 'SIG0156', '维修旁路空开状态', '', 'UPS参数', 'FAC004', 560, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (157, 'SIG0157', '旁路空开状态', '', 'UPS参数', 'FAC004', 564, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (158, 'SIG0158', '旁路柜旁路空开状态', '', 'UPS参数', 'FAC004', 568, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (159, 'SIG0159', '外部输出空开状态', '', 'UPS参数', 'FAC004', 572, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (160, 'SIG0160', '逆变主机', '', 'UPS参数', 'FAC004', 576, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (161, 'SIG0161', '逆变待机(ECO 状态)', '', 'UPS参数', 'FAC004', 580, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (162, 'SIG0162', 'LBS 系统激活', '', 'UPS参数', 'FAC004', 584, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (163, 'SIG0163', '电池自检', '', 'UPS参数', 'FAC004', 588, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (164, 'SIG0164', '电池充电', '', 'UPS参数', 'FAC004', 592, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (165, 'SIG0165', '正组电池均充 ', '', 'UPS参数', 'FAC004', 596, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (166, 'SIG0166', '负组电池均充', '', 'UPS参数', 'FAC004', 600, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (167, 'SIG0167', '整流器状态', '', 'UPS参数', 'FAC004', 604, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (168, 'SIG0168', '整流器限流', '', 'UPS参数', 'FAC004', 608, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (169, 'SIG0169', '输入供电状态', '', 'UPS参数', 'FAC004', 612, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (170, 'SIG0170', '输入供电模式', '', 'UPS参数', 'FAC004', 616, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (171, 'SIG0171', '逆变开关机状态 1', '', 'UPS参数', 'FAC004', 620, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (172, 'SIG0172', '逆变开关机状态 2 ', '', 'UPS参数', 'FAC004', 624, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (173, 'SIG0173', 'UPS 供电状态 1 ', '', 'UPS参数', 'FAC004', 628, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (174, 'SIG0174', 'UPS 供电状态 2 ', '', 'UPS参数', 'FAC004', 632, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (175, 'SIG0175', '间断切换提示 ', '', 'UPS参数', 'FAC004', 636, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (176, 'SIG0176', '关机将导致断电告警', '', 'UPS参数', 'FAC004', 640, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (177, 'SIG0177', '关机将导致过载告警', '', 'UPS参数', 'FAC004', 644, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (178, 'SIG0178', '发电机接入', '', 'UPS参数', 'FAC004', 648, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (179, 'SIG0179', '启动容量不足 ', '', 'UPS参数', 'FAC004', 652, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (180, 'SIG0180', '过载延时到关机', '', 'UPS参数', 'FAC004', 656, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (181, 'SIG0181', '负载冲击切旁路', '', 'UPS参数', 'FAC004', 660, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (182, 'SIG0182', '并机系统转旁路', '', 'UPS参数', 'FAC004', 664, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (183, 'SIG0183', '电池电压低关机', '', 'UPS参数', 'FAC004', 668, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (184, 'SIG0184', '切换次数到', '', 'UPS参数', 'FAC004', 672, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (185, 'SIG0185', '整流器故障', '', 'UPS参数', 'FAC004', 676, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (186, 'SIG0186', '逆变器故障', '', 'UPS参数', 'FAC004', 680, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (187, 'SIG0187', '辅助电源故障', '', 'UPS参数', 'FAC004', 684, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (188, 'SIG0188', '风扇故障', '', 'UPS参数', 'FAC004', 688, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (189, 'SIG0189', '输入晶闸管故障', '', 'UPS参数', 'FAC004', 692, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (190, 'SIG0190', '逆变晶闸管故障', '', 'UPS参数', 'FAC004', 696, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (191, 'SIG0191', '旁路晶闸管故障', '', 'UPS参数', 'FAC004', 700, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (192, 'SIG0192', '熔丝断', '', 'UPS参数', 'FAC004', 704, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (193, 'SIG0193', '母线电压异常', '', 'UPS参数', 'FAC004', 708, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (194, 'SIG0194', '初始化故障', '', 'UPS参数', 'FAC004', 712, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (195, 'SIG0195', '电池晶闸管故障', '', 'UPS参数', 'FAC004', 716, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (196, 'SIG0196', '充电器故障 ', '', 'UPS参数', 'FAC004', 720, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (197, 'SIG0197', '并机故障', '', 'UPS参数', 'FAC004', 724, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (198, 'SIG0198', '开机无效', '', 'UPS参数', 'FAC004', 728, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (199, 'SIG0199', '逆变直流分量过大', '', 'UPS参数', 'FAC004', 732, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (200, 'SIG0200', '输入电压相序反', '', 'UPS参数', 'FAC004', 736, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (201, 'SIG0201', '输入缺零', '', 'UPS参数', 'FAC004', 740, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (202, 'SIG0202', '旁路反序', '', 'UPS参数', 'FAC004', 744, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (203, 'SIG0203', '电池反', '', 'UPS参数', 'FAC004', 748, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (204, 'SIG0204', '电池无', '', 'UPS参数', 'FAC004', 752, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (205, 'SIG0205', '回馈保护', '', 'UPS参数', 'FAC004', 756, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (206, 'SIG0206', '电池损坏', '', 'UPS参数', 'FAC004', 760, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (207, 'SIG0207', '电池过温', '', 'UPS参数', 'FAC004', 764, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (208, 'SIG0208', '过载', '', 'UPS参数', 'FAC004', 768, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (209, 'SIG0209', '并机过载', '', 'UPS参数', 'FAC004', 772, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (210, 'SIG0210', '电池电压低', '', 'UPS参数', 'FAC004', 776, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (211, 'SIG0211', '电池电压高', '', 'UPS参数', 'FAC004', 780, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (212, 'SIG0212', '电池欠压预告警 ', '', 'UPS参数', 'FAC004', 784, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (213, 'SIG0213', '市电频率异常', '', 'UPS参数', 'FAC004', 788, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (214, 'SIG0214', '市电电压异常', '', 'UPS参数', 'FAC004', 792, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (215, 'SIG0215', '旁路超跟踪', '', 'UPS参数', 'FAC004', 796, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (216, 'SIG0216', '旁路超保护 ', '', 'UPS参数', 'FAC004', 800, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (217, 'SIG0217', '旁路过流', '', 'UPS参数', 'FAC004', 804, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (218, 'SIG0218', 'LBS 超跟踪', '', 'UPS参数', 'FAC004', 808, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (219, 'SIG0219', '不同步', '', 'UPS参数', 'FAC004', 812, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (220, 'SIG0220', '火灾报警', '', 'UPS参数', 'FAC004', 816, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (221, 'SIG0221', '烟雾报警', '', 'UPS参数', 'FAC004', 820, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (222, 'SIG0222', '主路异常', '', 'UPS参数', 'FAC004', 824, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (223, 'SIG0223', '电池低压', '', 'UPS参数', 'FAC004', 828, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (224, 'SIG0224', '旁路输出', '', 'UPS参数', 'FAC004', 832, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (225, 'SIG0225', 'UPS 故障', '', 'UPS参数', 'FAC004', 836, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (226, 'SIG0226', '逆变输出', '', 'UPS参数', 'FAC004', 840, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (227, 'SIG0227', 'UPS 电源综合故障报警', '', 'UPS参数', 'FAC004', 844, 4, '32flaot', 1, 1, 5);
INSERT INTO `c_signal` VALUES (228, 'SIG0228', '温度过高 ', '', 'UPS参数', 'FAC004', 848, 4, '32flaot', 1, 1, 5);

-- ----------------------------
-- Table structure for c_signalcollect
-- ----------------------------
DROP TABLE IF EXISTS `c_signalcollect`;
CREATE TABLE `c_signalcollect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comPort` int(11) NULL DEFAULT NULL COMMENT 'COM端口号',
  `deviceId` int(11) NULL DEFAULT NULL COMMENT '设备ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_site
-- ----------------------------
DROP TABLE IF EXISTS `c_site`;
CREATE TABLE `c_site`  (
  `siteId` int(10) NOT NULL AUTO_INCREMENT COMMENT '学校下属机房站点ID',
  `organizationId` int(10) NULL DEFAULT NULL COMMENT '学校ID',
  `siteName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机房名',
  PRIMARY KEY (`siteId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_site
-- ----------------------------
INSERT INTO `c_site` VALUES (1, 1, '网络中心4楼机房');
INSERT INTO `c_site` VALUES (2, 1, '东院12楼机房');

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
  PRIMARY KEY (`permissionId`) USING BTREE,
  UNIQUE INDEX `index_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '/', 1, 0, '/', '首页', 'vue', '/', 'dashboard');
INSERT INTO `sys_permission` VALUES (2, '/electric-report', 3, 0, '/electric-report', '历史查询', 'vue', '/electric-report', 'ElectricReport');
INSERT INTO `sys_permission` VALUES (3, '/history', 4, 3, 'electric', '电能', 'vue', '/electric', 'place');
INSERT INTO `sys_permission` VALUES (4, '/history', 5, 3, 'three', '温湿度', 'vue', '/three', 'ElectricReport');
INSERT INTO `sys_permission` VALUES (5, '/alarm', 6, 0, '/alarm', '运行状态', 'vue', '/alarm', 'alarmstatistics');
INSERT INTO `sys_permission` VALUES (6, '/manage', 13, 0, '/manage', '通讯管理', 'vue', '/manage', 'manage');
INSERT INTO `sys_permission` VALUES (7, '/signal', 7, 0, '/signal', '信号采集', 'vue', '/signal', 'signal');
INSERT INTO `sys_permission` VALUES (8, '/place', 8, 0, '/place', '单位信息', 'vue', '/place', 'place');
INSERT INTO `sys_permission` VALUES (9, '/userManage', 9, 0, '/userManage', '用户管理', 'vue', '/userManage', 'place');
INSERT INTO `sys_permission` VALUES (10, '/getData', 10, 0, '/getData', '设备参数', 'vue', '/getData', 'place');
INSERT INTO `sys_permission` VALUES (11, '/roles', 11, 0, '/roles', '权限管理', 'vue', '/roles', 'place');
INSERT INTO `sys_permission` VALUES (12, '/history', 12, 3, 'alarmList', '告警列表', 'vue', '/alarmList', 'alarmstatistics');
INSERT INTO `sys_permission` VALUES (13, '/ups', 2, 0, '/ups', 'ups', 'vue', '/ups', 'dashboard');

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
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` VALUES (17, 1, 2);
INSERT INTO `sys_role_permission` VALUES (15, 1, 3);
INSERT INTO `sys_role_permission` VALUES (2, 2, 1);
INSERT INTO `sys_role_permission` VALUES (18, 2, 2);
INSERT INTO `sys_role_permission` VALUES (12, 2, 3);
INSERT INTO `sys_role_permission` VALUES (3, 3, 1);
INSERT INTO `sys_role_permission` VALUES (19, 3, 2);
INSERT INTO `sys_role_permission` VALUES (13, 3, 3);
INSERT INTO `sys_role_permission` VALUES (4, 4, 1);
INSERT INTO `sys_role_permission` VALUES (20, 4, 2);
INSERT INTO `sys_role_permission` VALUES (14, 4, 3);
INSERT INTO `sys_role_permission` VALUES (5, 5, 1);
INSERT INTO `sys_role_permission` VALUES (21, 5, 2);
INSERT INTO `sys_role_permission` VALUES (16, 5, 3);
INSERT INTO `sys_role_permission` VALUES (6, 6, 1);
INSERT INTO `sys_role_permission` VALUES (7, 7, 1);
INSERT INTO `sys_role_permission` VALUES (8, 8, 1);
INSERT INTO `sys_role_permission` VALUES (9, 9, 1);
INSERT INTO `sys_role_permission` VALUES (10, 10, 1);
INSERT INTO `sys_role_permission` VALUES (11, 11, 1);
INSERT INTO `sys_role_permission` VALUES (22, 12, 1);
INSERT INTO `sys_role_permission` VALUES (23, 12, 2);
INSERT INTO `sys_role_permission` VALUES (24, 12, 3);
INSERT INTO `sys_role_permission` VALUES (25, 13, 1);
INSERT INTO `sys_role_permission` VALUES (26, 13, 2);
INSERT INTO `sys_role_permission` VALUES (27, 13, 3);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `roleId` int(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 3 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
  `state` int(11) NULL DEFAULT NULL COMMENT '设置是否发送告警邮件',
  `userName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `organizationId` int(11) NULL DEFAULT NULL COMMENT '组织ID',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户绑定的邮箱',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_userinfo
-- ----------------------------
INSERT INTO `sys_userinfo` VALUES (1, '2020-04-14 10:10:10', '2021-04-14 00:00:00', 'e10adc3949ba59abbe56e057f20f883e', 1, 'admin', 1, NULL);
INSERT INTO `sys_userinfo` VALUES (2, '2020-06-22 10:12:23', NULL, '', 1, 'liute', 1, '422124935@qq.com');
INSERT INTO `sys_userinfo` VALUES (3, '2020-06-22 14:50:50', NULL, NULL, 1, 'TE', 1, 'm15072471966@163.com');

SET FOREIGN_KEY_CHECKS = 1;
