/*
 Navicat Premium Data Transfer

 Source Server         : mysqlConn
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : online_system

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 05/07/2018 10:39:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_exam
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examDate` datetime(0) NULL DEFAULT NULL,
  `moreScore` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  `singleScore` int(11) NULL DEFAULT NULL,
  `paperId` int(11) NULL DEFAULT NULL,
  `studentId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_l14kkd2w86mpy8v2snw37hskx`(`paperId`) USING BTREE,
  INDEX `FK_sl2v4qucyp0qe9yvnk6icka10`(`studentId`) USING BTREE,
  CONSTRAINT `FK_l14kkd2w86mpy8v2snw37hskx` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_sl2v4qucyp0qe9yvnk6icka10` FOREIGN KEY (`studentId`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam
-- ----------------------------
INSERT INTO `t_exam` VALUES (2, '2018-07-04 18:00:53', 0, 0, 0, 1, '2015036534');
INSERT INTO `t_exam` VALUES (3, '2018-07-04 18:01:10', 0, 40, 40, 1, '2015036534');
INSERT INTO `t_exam` VALUES (4, '2018-07-04 19:18:28', 0, 60, 60, 1, '2015036534');

-- ----------------------------
-- Table structure for t_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_manager`;
CREATE TABLE `t_manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_manager
-- ----------------------------
INSERT INTO `t_manager` VALUES (1, '管理员', '123', 'admin');

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `joinDate` datetime(0) NULL DEFAULT NULL,
  `paperName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_paper
-- ----------------------------
INSERT INTO `t_paper` VALUES (1, '2014-01-01 00:00:00', 'Java试卷一');
INSERT INTO `t_paper` VALUES (2, '2014-02-01 00:00:00', '语文试卷二');
INSERT INTO `t_paper` VALUES (3, '2014-01-01 00:00:00', '数学试卷一');
INSERT INTO `t_paper` VALUES (7, '2018-04-27 00:00:00', '计算机基础知识');
INSERT INTO `t_paper` VALUES (9, '2018-04-28 00:00:00', '大学英语');
INSERT INTO `t_paper` VALUES (21, '2018-07-03 20:12:26', 'test试卷');

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `joinTime` datetime(0) NULL DEFAULT NULL,
  `optionA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `optionB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `optionC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `optionD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ebouwob97chiilpjmc6gtgwkw`(`paperId`) USING BTREE,
  CONSTRAINT `FK_ebouwob97chiilpjmc6gtgwkw` FOREIGN KEY (`paperId`) REFERENCES `t_paper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES (1, 'D', '2014-01-01 00:00:00', 'A. a1', 'B. $1', 'C. _1', 'D .11', '下列不可作为java语言修饰符的是？', '1', 1);
INSERT INTO `t_question` VALUES (2, 'A', '2014-01-01 00:00:00', 'A. a1.java', 'B. a.class', 'C. a1', 'D. 都可以', '有一段java应用程序，它的主类名是a1，那么保存 它的源文件名可以是？', '1', 1);
INSERT INTO `t_question` VALUES (3, 'A,B', '2014-01-01 00:00:00', 'A. String []a', 'B. String a[]', 'C. char a[][]', 'D. String a[10]', '下面正确声明一个一维数组的是？', '2', 1);
INSERT INTO `t_question` VALUES (4, 'A,D', '2014-01-01 00:00:00', 'A. 在java中只允许单继承。', 'B. 在java中一个类只能实现一个接口。', 'C. 在java中一个类不能同时继承一个类和实现一个接口。', 'D. java的单一继承使代码更可靠。', '下面关于继承的叙述哪些是正确的？', '2', 1);
INSERT INTO `t_question` VALUES (5, 'C', '2014-01-01 00:00:00', 'A. 一个子类可以有多个父类，一个父类也可以有多个子类', 'B. 一个子类可以有多个父类，但一个父类只可以有一个子类', 'C. 一个子类可以有一个父类，但一个父类可以有多个子类', 'D. 上述说法都不对', '在Java中？', '1', 1);
INSERT INTO `t_question` VALUES (6, 'A,D', '2014-01-01 00:00:00', 'A. 包的声明必须是源文件的第一句代码。', 'B. 包的声明必须紧跟在import语句的后面。', 'C. 只有公共类才能放在包中。', 'D. 可以将多个源文件中的类放在同一个包中。', '可以将多个源文件中的类放在同一个包中？', '2', 1);
INSERT INTO `t_question` VALUES (7, 'C', '2014-01-01 00:00:00', 'A. Java是跨平台的编程语言', 'B. Java支持分布式计算', 'C. Java是面向过程的编程语言', 'D. Java是面向对象的编程语言', '下列关于Java语言的特点，描述错误的是？', '1', 1);
INSERT INTO `t_question` VALUES (16, 'A,B', '2014-07-09 00:00:00', '1122', '2223', '3322', '4422', '测试题目2', '2', 2);
INSERT INTO `t_question` VALUES (17, 'A,D', '2014-07-17 00:00:00', '2321', '321', '321', '321', '测试题目', '2', 1);
INSERT INTO `t_question` VALUES (18, 'A', '2014-09-12 00:00:00', '11141', '22241', '33341', '44441', '测试题目22334', '1', 1);
INSERT INTO `t_question` VALUES (19, 'A,D', '2014-09-11 00:00:00', '22', '32', '42', '52', '12', '2', 2);
INSERT INTO `t_question` VALUES (20, 'A,D', '2014-09-12 00:00:00', '测试选项一2', '测试选项二2', '测试选项三2', '测试选项四2', '测试题目2', '2', 1);
INSERT INTO `t_question` VALUES (21, 'A', '2018-04-27 00:00:00', '太湖神威之光', '阿尔法狗', '不知道', '没有最快，只有更快', '目前世界上最快的计算机叫什么？', '1', 7);
INSERT INTO `t_question` VALUES (22, 'A,B,C,D', '2018-04-27 00:00:00', 'java', 'c', 'c++', 'php', '下列那些是计算机编程语言？', '2', 7);
INSERT INTO `t_question` VALUES (23, 'A', '2018-04-26 00:00:00', '一门编程语言', '咖啡', '不知道', '爱啥啥，跟我有啥关系', 'java是什么？', '1', 7);
INSERT INTO `t_question` VALUES (24, 'A,B,C,D', '2018-04-18 00:00:00', '说的对', '有道理', '瞎几把吹', '跟我有关系么？', '有人说PHP是世界上最好的语言，你怎么看？', '2', 7);
INSERT INTO `t_question` VALUES (25, 'A', '2018-04-16 00:00:00', 'reading', 'sleeping', 'running', 'eating', 'what are you doing？', '1', 9);
INSERT INTO `t_question` VALUES (26, 'A,B,C', '2018-04-12 00:00:00', 'a', 'b', 'c', 'd', 'who are u?', '2', 9);
INSERT INTO `t_question` VALUES (27, 'A', '2018-04-10 00:00:00', 'i am fine thks', 'ha', 'ha ha', 'h', 'how are u?', '1', 9);
INSERT INTO `t_question` VALUES (32, 'A', '2018-07-04 00:00:00', 'testA', 'testB', 'testC', 'testD', 'java123132', '2', 21);
INSERT INTO `t_question` VALUES (33, 'A', '2018-06-04 00:00:00', 'testA', 'testB', 'testC', 'testD', '下列不可作为java语言修饰符的是12321321？', '2', 21);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `carNo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profession` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('2015036534', '789789789', 'test', '123456', '物联网', '男');
INSERT INTO `t_student` VALUES ('TX20180704042947', '456446', 'test', '123', '1', '男');
INSERT INTO `t_student` VALUES ('TX20180704082343', '456446', 'test', '123', '1', '男');

SET FOREIGN_KEY_CHECKS = 1;
