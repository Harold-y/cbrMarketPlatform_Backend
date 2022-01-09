/*
 Navicat Premium Data Transfer

 Source Server         : CBRServer
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : cbrmarketplatform

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 08/01/2022 20:16:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authen_clearance
-- ----------------------------
DROP TABLE IF EXISTS `authen_clearance`;
CREATE TABLE `authen_clearance`  (
  `authen_allow_id` int(0) NOT NULL AUTO_INCREMENT,
  `authen_id` int(0) NULL DEFAULT NULL,
  `authen_item_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`authen_allow_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authen_clearance
-- ----------------------------
INSERT INTO `authen_clearance` VALUES (1, 1, 1);
INSERT INTO `authen_clearance` VALUES (3, 1, 10);
INSERT INTO `authen_clearance` VALUES (5, 1, 2);
INSERT INTO `authen_clearance` VALUES (6, 2, 2);
INSERT INTO `authen_clearance` VALUES (8, 2, 3);
INSERT INTO `authen_clearance` VALUES (9, 2, 4);
INSERT INTO `authen_clearance` VALUES (10, 4, 10);
INSERT INTO `authen_clearance` VALUES (11, 2, 15);
INSERT INTO `authen_clearance` VALUES (12, 5, 14);
INSERT INTO `authen_clearance` VALUES (13, 4, 17);
INSERT INTO `authen_clearance` VALUES (14, 3, 16);

-- ----------------------------
-- Table structure for authen_item
-- ----------------------------
DROP TABLE IF EXISTS `authen_item`;
CREATE TABLE `authen_item`  (
  `auth_item_id` int(0) NOT NULL AUTO_INCREMENT,
  `auth_item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auth_item_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`auth_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authen_item
-- ----------------------------
INSERT INTO `authen_item` VALUES (1, 'Grand Pass', 'give right to all operations, top clearance');
INSERT INTO `authen_item` VALUES (14, 'Authen', 'Give right to proceed authentication ops');
INSERT INTO `authen_item` VALUES (15, 'Personnel', 'Give right to proceed personnel ops');
INSERT INTO `authen_item` VALUES (16, 'Merchandise', 'Give right to proceed merchandise ops');
INSERT INTO `authen_item` VALUES (17, 'Seller', 'Give right to publish and revise own goods');
INSERT INTO `authen_item` VALUES (18, 'Buyer', 'Give right to purchase');

-- ----------------------------
-- Table structure for authen_normal
-- ----------------------------
DROP TABLE IF EXISTS `authen_normal`;
CREATE TABLE `authen_normal`  (
  `auth_id` int(0) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auth_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`auth_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authen_normal
-- ----------------------------
INSERT INTO `authen_normal` VALUES (1, 'True Administrator', NULL);
INSERT INTO `authen_normal` VALUES (2, 'HR', '');
INSERT INTO `authen_normal` VALUES (3, 'Merch Manager', '');
INSERT INTO `authen_normal` VALUES (4, 'Seller', NULL);
INSERT INTO `authen_normal` VALUES (5, 'Administrator', 'Administrator of Executive');
INSERT INTO `authen_normal` VALUES (8, 'Individual Buyer', '');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `cart_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `merch_sub_id` int(0) NULL DEFAULT NULL,
  `cart_merch_number_to_buy` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `city_id` int(0) NOT NULL AUTO_INCREMENT,
  `state_id` int(0) NULL DEFAULT NULL,
  `city_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES (1, 53, 'Taipei');
INSERT INTO `city` VALUES (2, 40, 'Madison');
INSERT INTO `city` VALUES (3, 53, 'Gaoxiong');
INSERT INTO `city` VALUES (4, 56, 'Zhengzhou');
INSERT INTO `city` VALUES (5, 56, 'Xinxiang');
INSERT INTO `city` VALUES (6, 56, 'Luoyang');
INSERT INTO `city` VALUES (7, 56, 'Jiaozuo');
INSERT INTO `city` VALUES (8, 41, 'Los Angeles');
INSERT INTO `city` VALUES (9, 41, 'San Francisco');
INSERT INTO `city` VALUES (10, 53, 'Zhanghua');
INSERT INTO `city` VALUES (11, 53, 'Jiayi');
INSERT INTO `city` VALUES (14, 65, 'Duck');
INSERT INTO `city` VALUES (15, 64, 'TheFuck');

-- ----------------------------
-- Table structure for merchandise
-- ----------------------------
DROP TABLE IF EXISTS `merchandise`;
CREATE TABLE `merchandise`  (
  `merch_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_type_id` int(0) NULL DEFAULT NULL,
  `merch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_photo_folder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_create_date` datetime(0) NULL DEFAULT NULL,
  `merch_status` int(0) NULL DEFAULT NULL COMMENT '0 for no longer active, 1 for sale, 2 for on sale',
  `merch_year_sale_stat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'the number of sale item of this year',
  `merch_special` int(0) NULL DEFAULT NULL COMMENT 'gongyi_zuanshi_prime etc',
  `merch_photo_set` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_id` int(0) NULL DEFAULT NULL COMMENT 'who published this item',
  `description` int(0) NULL DEFAULT NULL COMMENT 'the number of photos that belongs to the description',
  `merch_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchandise
-- ----------------------------
INSERT INTO `merchandise` VALUES (1, 1, 'Maple Processer', 'K892YUC', '2021-01-05 15:40:39', 1, '1000', 0, '2-4-1-3-5-6-', 1, 5, NULL);
INSERT INTO `merchandise` VALUES (6, 1, 'Yollo M51 Laptop/4K Screen/AM next generation AM Northern Lights© C5500S，10GHz Processor', 'Yollo M51 Laptop_220142d6-0e62-4500-ab71-01252664018e', '2022-01-06 17:41:52', 1, '260', 0, '1-', 3, 4, 'Yollo M51 has excellent next generation AM Northern Lights© C5500S，10GHz Processor from AM Tech.');
INSERT INTO `merchandise` VALUES (7, 1, 'AM LK610 Gaming Laptop, 17.3 Inch Thin Bezel FHD 144Hz 72% NTSC, Intel i7-11800H, RTX 3060 6GB, 16GB RAM, 1TB NVMe SSD, Windows 10', 'AM LK610 Gaming Laptop_5106d235-7df6-4295-b829-9d8b9f714a70', '2022-01-07 09:55:33', 1, '900', 0, '1-', 3, 4, 'LK 610 has fully equipped with ST Maple© P3100，8.5GHz newest processor from Southern Tech.');
INSERT INTO `merchandise` VALUES (8, 1, 'AM LK710 Gaming Laptop Plus | Intel Core i5-10300H | NVIDIA GeForce RTX 3050 Laptop GPU | 15.6\" FHD 144Hz IPS Display | 8GB DDR4 | 256GB NVMe SSD | Intel Wi-Fi 6 | Backlit Keyboard', 'AM LK710 Gaming Laptop_2952aa9c-baf6-4460-81da-de2a139c6b07', '2022-01-07 10:11:17', 1, '100', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (9, 1, 'Russia Laptop T1', 'Russia Laptop T1_64c09211-3724-4b4a-b8d4-10e60e96217f', '2022-01-07 18:49:34', 1, '900', 0, '1-', 8, 5, NULL);
INSERT INTO `merchandise` VALUES (10, 1, 'ST Cryo610 Laptop | 15.6\" FHD 144Hz Display, Quad-Core i7-11370H up to 4.80 GHz, GeForce RTX 3060, 24GB RAM 3200MHz, 512GB PCIe SSD, Thunderbolt 4, Backlit Keyboard, WiFi 6, Win 10', 'ST Cryo610 Laptop_dc03fade-fd95-4f84-94e7-1d25056adcc4', '2022-01-08 14:45:50', 1, '4675', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (11, 1, 'ST Cryo680 Laptop | Intel Core i5-10300H | NVIDIA GeForce RTX 3050 Laptop GPU | 15.6\" FHD 144Hz IPS Display | 8GB DDR4 | 256GB NVMe SSD | Intel Wi-Fi 6 | Backlit Keyboard', 'ST Cryo680_af552d03-e2e7-4b06-8d11-b7139430fdf2', '2022-01-08 14:47:03', 1, '47', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (12, 1, 'ST Ultra800 Laptop 12GB+256GB 10th Intel Core i3-1005G1 Laptop Computer Up to 3.4GHz 15W Process 1920x1080 FHD Thin Traditional Laptop Computers HDMI 5G WiFi BT Type-C USB3.0 Zoom Study', 'ST Ultra800 Laptop_b670d767-d8ab-4bbd-87f9-718defc1f32d', '2022-01-08 14:50:24', 1, '59', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (13, 1, 'ROG Gaming Laptop 15.6\" FHD Touchscreen Laptop. Intel Core i7-1065G7 Processor, 20GB RAM, 1TB SSD, Backlit Keyboard, Webcam, WiFi, HDMI, Bluetooth, Compact Design, Long Battery Life, Win 10', 'ROG Gaming Laptop_4f7c72cc-bbcf-4415-b27d-960d730cc529', '2022-01-08 14:50:48', 1, '12', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (14, 1, 'Razar Gaming Laptop I 17.3” FHD IPS 144Hz Display I AMD 8-core Ryzen 7 5800H I 16GB DDR4 512GB SSD I Radeon RX6600M 8GB I USB-C Backlit Win10 + 32GB MicroSD Card', 'Razar Gaming Laptop_0ac5e475-dfae-4ca0-9490-0343e0232379', '2022-01-08 14:51:06', 1, '41', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (15, 1, 'HP Shadow Elf 7 Laptop | 15.6” 300Hz IPS Type FHD Display, NVIDIA GeForce RTX 3070, AMD Ryzen R9-5900HX, 32GB DDR4, 1TB PCIe SSD, Per-Key RGB Keyboard, Windows 10', 'HP Shadow Elf 7 Laptop_6dc0892e-6534-4cd7-8568-f5dd9e288e70', '2022-01-08 14:51:37', 1, '6', 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (16, 1, 'AM LK800 Gaming Laptop | Intel Core i5-9300H Processor, NVIDIA GeForce GTX 1650 (4 GB), 8 GB SDRAM, 256 GB SSD, Windows 10 Home (15-dk0020nr, Shadow Black/Acid Green)', 'AM LK800 Gaming Laptop_6aa9ff3a-f37b-4c77-adcc-bb0c9daa98d2', '2022-01-08 14:51:58', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (17, 6, '1984 By George Orwell', '1984 By George Orwell_c2669175-f41a-4b4b-9cb6-ea616c336814', '2022-01-08 19:55:24', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (18, 6, 'Peaceful Night', 'Peaceful Night_15867e16-c7ef-4d5c-b811-fc266e414c8e', '2022-01-08 19:56:43', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (19, 6, 'Titanic', 'Titanic_28e52aba-2c78-411c-947c-ad36a2f8dd6e', '2022-01-08 19:57:21', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (20, 6, 'GRE Vocabulary', 'GRE Vocabulary_35508bfd-e41c-4f59-ab2e-9f33458e5921', '2022-01-08 19:58:16', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (21, 3, 'Onion', 'Onion_1d064052-502d-446e-910a-f4cf148f6f79', '2022-01-08 19:58:57', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (22, 3, 'Banana', 'Food_620076be-dc64-4a25-9bca-5a69ff998b20', '2022-01-08 20:00:26', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (23, 3, 'Tomato', 'Tomato_8a7317e3-e999-4571-9f56-5550fb50a5ba', '2022-01-08 20:01:54', 1, NULL, 0, '1-', 3, NULL, NULL);
INSERT INTO `merchandise` VALUES (24, 3, 'Lemon', 'Lemon_30a77b84-099b-40b9-aeff-aeb67ac9b1e2', '2022-01-08 20:02:44', 1, NULL, 0, '1-', 3, NULL, NULL);

-- ----------------------------
-- Table structure for merchandise_gen_type
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_gen_type`;
CREATE TABLE `merchandise_gen_type`  (
  `merch_gen_type_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_gen_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merch_gen_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchandise_gen_type
-- ----------------------------
INSERT INTO `merchandise_gen_type` VALUES (1, 'Electronic Devices');
INSERT INTO `merchandise_gen_type` VALUES (2, 'Entertainments');
INSERT INTO `merchandise_gen_type` VALUES (3, 'Foods');
INSERT INTO `merchandise_gen_type` VALUES (4, 'Animal Related');
INSERT INTO `merchandise_gen_type` VALUES (5, 'Health & Care');
INSERT INTO `merchandise_gen_type` VALUES (6, 'Home');
INSERT INTO `merchandise_gen_type` VALUES (7, 'Books');
INSERT INTO `merchandise_gen_type` VALUES (8, 'Clothes');
INSERT INTO `merchandise_gen_type` VALUES (9, 'Luxury');
INSERT INTO `merchandise_gen_type` VALUES (10, 'Gift');
INSERT INTO `merchandise_gen_type` VALUES (11, 'Toy & Children');
INSERT INTO `merchandise_gen_type` VALUES (12, 'Sports');
INSERT INTO `merchandise_gen_type` VALUES (13, 'Outdoors');
INSERT INTO `merchandise_gen_type` VALUES (14, 'Pharmacy');
INSERT INTO `merchandise_gen_type` VALUES (15, 'Industrial & Scientific');
INSERT INTO `merchandise_gen_type` VALUES (16, 'Other');

-- ----------------------------
-- Table structure for merchandise_property
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_property`;
CREATE TABLE `merchandise_property`  (
  `merch_property_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_property_type_id` int(0) NULL DEFAULT NULL,
  `merch_id` int(0) NULL DEFAULT NULL,
  `merch_property_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merch_property_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for merchandise_property_type
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_property_type`;
CREATE TABLE `merchandise_property_type`  (
  `merch_property_type_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_property_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_type_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`merch_property_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchandise_property_type
-- ----------------------------
INSERT INTO `merchandise_property_type` VALUES (1, 'Graphic Card Model', 1);
INSERT INTO `merchandise_property_type` VALUES (2, 'Screen Parameter', 1);
INSERT INTO `merchandise_property_type` VALUES (3, 'Memory', 1);
INSERT INTO `merchandise_property_type` VALUES (4, 'Disk', 1);
INSERT INTO `merchandise_property_type` VALUES (5, 'CPU', 1);
INSERT INTO `merchandise_property_type` VALUES (8, 'Motherboard', 1);

-- ----------------------------
-- Table structure for merchandise_sub
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_sub`;
CREATE TABLE `merchandise_sub`  (
  `merch_sub_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_id` int(0) NULL DEFAULT NULL,
  `merch_sub_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_sub_price` decimal(10, 2) NULL DEFAULT NULL,
  `merch_sub_onsale_price` decimal(10, 2) NULL DEFAULT NULL,
  `merch_sub_status` int(0) NULL DEFAULT NULL COMMENT '0 for no longer sale, 1 for sale, 2 for on sale',
  `merch_sub_photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_sub_remaining` bigint(0) NULL DEFAULT NULL COMMENT 'storage remaining',
  `merch_sub_create_date` datetime(0) NULL DEFAULT NULL,
  `merch_sub_onsale_end_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`merch_sub_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchandise_sub
-- ----------------------------
INSERT INTO `merchandise_sub` VALUES (1, 6, '256G Memory + 10T SSD', 7000.00, NULL, 1, '7f2a2e96-a770-4a59-a1af-982f8d32ea00.jpg', 100, '2022-01-07 16:16:44', NULL);
INSERT INTO `merchandise_sub` VALUES (2, 6, '512G Memory + 20T SSD', 9000.50, NULL, 1, '3a633bca-4a8a-4302-9e69-6092e42f42f5.jpg', 10000, '2022-01-07 17:05:16', '2022-01-09 17:47:14');
INSERT INTO `merchandise_sub` VALUES (3, 6, '1T Memory + 50T SSD', 12000.50, NULL, 1, NULL, 1000, '2022-01-07 17:07:32', '2022-01-10 17:47:59');
INSERT INTO `merchandise_sub` VALUES (4, 9, '16G + 512G SSD', 1200.00, NULL, 1, '0da0c8b7-de30-49b6-a64c-38f3cd1f8244.jpg', 1000, '2022-01-07 18:51:23', NULL);
INSERT INTO `merchandise_sub` VALUES (5, 9, '32G + 1T SSD', 1700.00, NULL, 1, '9bd54260-61a6-4675-9850-5dd512c9dd35.jpg', 560, '2022-01-07 18:51:42', NULL);
INSERT INTO `merchandise_sub` VALUES (6, 10, '64G Memory + 10T SSD', 1000.00, NULL, 1, NULL, 500, '2022-01-08 14:46:41', NULL);
INSERT INTO `merchandise_sub` VALUES (7, 7, 'RTX3060 + 16GB RAM, 1T SSD', 1250.00, NULL, 1, NULL, 200, '2022-01-08 15:32:03', NULL);
INSERT INTO `merchandise_sub` VALUES (8, 8, 'i5-10300H + RTX3050', 900.00, NULL, 1, NULL, 203, '2022-01-08 15:32:40', NULL);
INSERT INTO `merchandise_sub` VALUES (9, 11, '16GB RAM + 2T SSD', 1200.00, NULL, 1, NULL, 145, '2022-01-08 15:33:07', NULL);
INSERT INTO `merchandise_sub` VALUES (10, 13, 'i7-1065G7 + 20GB RAM + 1TSSD', 2000.00, NULL, 1, NULL, 925, '2022-01-08 15:33:35', NULL);
INSERT INTO `merchandise_sub` VALUES (11, 14, '144HZ, R7 5800H, 16GB RAM, 512GB SSD', 1890.00, NULL, 1, NULL, 233, '2022-01-08 15:34:03', NULL);
INSERT INTO `merchandise_sub` VALUES (12, 15, 'RTX3070, R9 5900HX, 32GB RAM, 1T SSD', 2199.00, NULL, 1, NULL, 9677, '2022-01-08 15:34:40', NULL);
INSERT INTO `merchandise_sub` VALUES (13, 16, 'i5-9300H + GTX1650, 8G RAM, 245G SSD', 269.00, NULL, 1, NULL, 24, '2022-01-08 15:35:11', NULL);
INSERT INTO `merchandise_sub` VALUES (14, 16, 'i7 8750H + GTX1660ti', 1700.00, NULL, 1, NULL, 1275, '2022-01-08 18:36:57', NULL);
INSERT INTO `merchandise_sub` VALUES (15, 15, 'RTX3060ti, R7 5800H', 1900.00, NULL, 1, NULL, 23, '2022-01-08 18:37:23', NULL);
INSERT INTO `merchandise_sub` VALUES (16, 17, 'Normal Edition', 1000.00, NULL, 1, NULL, 200, '2022-01-08 19:56:09', NULL);
INSERT INTO `merchandise_sub` VALUES (17, 17, 'Collection Edition', 1200.00, NULL, 1, NULL, 20, '2022-01-08 19:56:21', NULL);
INSERT INTO `merchandise_sub` VALUES (18, 18, 'Normal Edition', 1000.00, NULL, 1, NULL, 200, '2022-01-08 19:56:58', NULL);
INSERT INTO `merchandise_sub` VALUES (19, 18, 'Collection Edition', 1200.00, NULL, 1, NULL, 23, '2022-01-08 19:57:07', NULL);
INSERT INTO `merchandise_sub` VALUES (20, 19, 'Normal Edition', 1000.00, NULL, 1, NULL, 290, '2022-01-08 19:57:35', NULL);
INSERT INTO `merchandise_sub` VALUES (21, 19, 'Collection Edition', 1200.00, NULL, 1, NULL, 29, '2022-01-08 19:57:46', NULL);
INSERT INTO `merchandise_sub` VALUES (22, 20, 'Green Book', 900.00, NULL, 1, NULL, 123, '2022-01-08 19:58:39', NULL);
INSERT INTO `merchandise_sub` VALUES (23, 20, 'Plus Edition', 1000.00, NULL, 1, NULL, 20, '2022-01-08 19:58:47', NULL);
INSERT INTO `merchandise_sub` VALUES (24, 21, '15 lbs', 5.30, NULL, 1, NULL, 2000, '2022-01-08 19:59:37', NULL);
INSERT INTO `merchandise_sub` VALUES (25, 21, '7lbs', 2.50, NULL, 1, NULL, 1000, '2022-01-08 19:59:56', NULL);
INSERT INTO `merchandise_sub` VALUES (26, 22, '3lbs', 1.00, NULL, 1, NULL, 2000, '2022-01-08 20:00:43', NULL);
INSERT INTO `merchandise_sub` VALUES (27, 22, '8lbs', 2.10, NULL, 1, NULL, 800, '2022-01-08 20:01:03', NULL);
INSERT INTO `merchandise_sub` VALUES (28, 23, '5 lbs', 2.49, NULL, 1, NULL, 9000, '2022-01-08 20:02:15', NULL);
INSERT INTO `merchandise_sub` VALUES (29, 23, '15lbs', 6.40, NULL, 1, NULL, 1090, '2022-01-08 20:02:28', NULL);
INSERT INTO `merchandise_sub` VALUES (30, 24, '2 lbs', 2.20, NULL, 1, NULL, 2000, '2022-01-08 20:03:00', NULL);
INSERT INTO `merchandise_sub` VALUES (31, 24, '4 lbs', 4.00, NULL, 1, NULL, 10000, '2022-01-08 20:03:10', NULL);

-- ----------------------------
-- Table structure for merchandise_type
-- ----------------------------
DROP TABLE IF EXISTS `merchandise_type`;
CREATE TABLE `merchandise_type`  (
  `merch_type_id` int(0) NOT NULL AUTO_INCREMENT,
  `merch_gen_type_id` int(0) NULL DEFAULT NULL,
  `merch_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merch_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of merchandise_type
-- ----------------------------
INSERT INTO `merchandise_type` VALUES (1, 1, 'Computers');
INSERT INTO `merchandise_type` VALUES (2, 1, 'Cameras');
INSERT INTO `merchandise_type` VALUES (3, 3, 'Vegetable');
INSERT INTO `merchandise_type` VALUES (6, 7, 'Books');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `user_payment_id` int(0) NULL DEFAULT NULL,
  `order_status` int(0) NULL DEFAULT NULL,
  `order_shipping_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merch_sub_id` int(0) NULL DEFAULT NULL,
  `order_how_many_item` int(0) NULL DEFAULT NULL,
  `order_single_price` decimal(10, 2) NULL DEFAULT NULL,
  `order_total_price` decimal(10, 2) NULL DEFAULT NULL,
  `order_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel`  (
  `personnel_id` int(0) NOT NULL AUTO_INCREMENT,
  `personnel_status` int(0) NULL DEFAULT NULL,
  `personnel_type_id` int(0) NULL DEFAULT NULL,
  `personnel_first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_mid_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_enroll_time` datetime(0) NULL DEFAULT NULL,
  `personnel_resign_time` datetime(0) NULL DEFAULT NULL,
  `personnel_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`personnel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES (1, 1, 1, 'Harold', NULL, 'Finch', '2021-12-30 00:00:00', NULL, 'F.harold@mit.edu', '+iI1DTi6v3TiRp5ltjxbeg==', NULL);
INSERT INTO `personnel` VALUES (2, 1, 1, 'John', '', 'Reese', '2022-01-04 09:56:46', NULL, 'R.John@CIA.gov', '', NULL);
INSERT INTO `personnel` VALUES (3, 1, 1, 'Harold', '', 'ClearIce', '2022-01-04 09:57:19', '2022-01-05 11:54:10', 'harold@cbr.gov', 'lRfkyNi+X6xfebC0Tp5tcw==', NULL);
INSERT INTO `personnel` VALUES (8, 1, 6, 'Peter', '', 'Yogorov', '2022-01-06 18:37:32', NULL, 'peter@ny.com', 'Yj3e8OLvEkZ0cruQr5C4kw==', NULL);
INSERT INTO `personnel` VALUES (9, 1, 10, 'Joss', '', 'Carter', '2022-01-08 17:10:09', NULL, 'j.carter@ny.pd', 'K6/d62WBZFA7U3FMv+2PvA==', NULL);
INSERT INTO `personnel` VALUES (10, 1, 5, 'Lionel', '', '', '2022-01-08 17:12:35', NULL, 'l@l.com', 'sDN8ufs/ZUSCw12o6nOCIw==', NULL);

-- ----------------------------
-- Table structure for personnel_auth
-- ----------------------------
DROP TABLE IF EXISTS `personnel_auth`;
CREATE TABLE `personnel_auth`  (
  `personnel_clearance_id` int(0) NOT NULL AUTO_INCREMENT,
  `auth_id` int(0) NULL DEFAULT NULL,
  `personnel_type_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`personnel_clearance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personnel_auth
-- ----------------------------
INSERT INTO `personnel_auth` VALUES (1, 1, 1);
INSERT INTO `personnel_auth` VALUES (2, 2, 2);
INSERT INTO `personnel_auth` VALUES (3, 3, 2);
INSERT INTO `personnel_auth` VALUES (5, 3, 1);
INSERT INTO `personnel_auth` VALUES (6, 2, 1);
INSERT INTO `personnel_auth` VALUES (10, 5, 1);
INSERT INTO `personnel_auth` VALUES (11, 4, 6);
INSERT INTO `personnel_auth` VALUES (12, 3, 3);
INSERT INTO `personnel_auth` VALUES (13, 5, 2);
INSERT INTO `personnel_auth` VALUES (14, 5, 9);
INSERT INTO `personnel_auth` VALUES (15, 4, 1);
INSERT INTO `personnel_auth` VALUES (16, 8, 10);

-- ----------------------------
-- Table structure for personnel_type
-- ----------------------------
DROP TABLE IF EXISTS `personnel_type`;
CREATE TABLE `personnel_type`  (
  `personnel_type_id` int(0) NOT NULL AUTO_INCREMENT,
  `personnel_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`personnel_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personnel_type
-- ----------------------------
INSERT INTO `personnel_type` VALUES (1, 'Administrator');
INSERT INTO `personnel_type` VALUES (2, 'CEO');
INSERT INTO `personnel_type` VALUES (3, 'Business Manager');
INSERT INTO `personnel_type` VALUES (5, 'Janitor');
INSERT INTO `personnel_type` VALUES (6, 'Seller');
INSERT INTO `personnel_type` VALUES (8, 'Business Contacter');
INSERT INTO `personnel_type` VALUES (9, 'Admin Lite');
INSERT INTO `personnel_type` VALUES (10, 'Buyer');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `region_id` int(0) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region_shortname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`region_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (1, 'United States', 'US');
INSERT INTO `region` VALUES (2, 'China mainland', 'CN');
INSERT INTO `region` VALUES (3, 'Canada', 'CA');
INSERT INTO `region` VALUES (4, 'Japan', 'JP');
INSERT INTO `region` VALUES (5, 'Korea', 'KR');
INSERT INTO `region` VALUES (6, 'Hong Kong SAR', 'HK');
INSERT INTO `region` VALUES (7, 'Macau', 'MO');
INSERT INTO `region` VALUES (8, 'Taiwan', 'TW');
INSERT INTO `region` VALUES (9, 'India', 'IN');
INSERT INTO `region` VALUES (10, 'United Kingdom', 'UK');
INSERT INTO `region` VALUES (12, 'France', 'FR');
INSERT INTO `region` VALUES (23, 'Chengbing Republic', 'CBR');
INSERT INTO `region` VALUES (28, 'Democratic Ordious Republic', 'DOP');
INSERT INTO `region` VALUES (29, 'Leucious Republic', 'LUP');
INSERT INTO `region` VALUES (30, 'United Morncia Republic', 'UMP');
INSERT INTO `region` VALUES (33, 'Democratic Republic of Hubris', 'DRH');
INSERT INTO `region` VALUES (35, 'Singapore', 'SG');
INSERT INTO `region` VALUES (37, 'United Wild Chicken Kindom', 'UWCK');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state`  (
  `state_id` int(0) NOT NULL AUTO_INCREMENT,
  `region_id` int(0) NULL DEFAULT NULL,
  `state_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`state_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES (1, 1, 'Alabama');
INSERT INTO `state` VALUES (3, 1, 'Hawaii');
INSERT INTO `state` VALUES (4, 1, 'Kanas');
INSERT INTO `state` VALUES (5, 1, 'Massachusetts');
INSERT INTO `state` VALUES (6, 1, 'Montana');
INSERT INTO `state` VALUES (7, 1, 'New Mexico');
INSERT INTO `state` VALUES (8, 1, 'Oklahoma');
INSERT INTO `state` VALUES (9, 1, 'South Dakota');
INSERT INTO `state` VALUES (10, 1, 'Virginia');
INSERT INTO `state` VALUES (11, 1, 'Alaska');
INSERT INTO `state` VALUES (12, 1, 'Connecticut');
INSERT INTO `state` VALUES (13, 1, 'Idaho');
INSERT INTO `state` VALUES (14, 1, 'Kentucky');
INSERT INTO `state` VALUES (15, 1, 'Michigan');
INSERT INTO `state` VALUES (16, 1, 'Nebraska');
INSERT INTO `state` VALUES (17, 1, 'New York');
INSERT INTO `state` VALUES (18, 1, 'Oregon');
INSERT INTO `state` VALUES (19, 1, 'Tennessee');
INSERT INTO `state` VALUES (20, 1, 'Washington');
INSERT INTO `state` VALUES (21, 1, 'Arizona');
INSERT INTO `state` VALUES (22, 1, 'Delaware');
INSERT INTO `state` VALUES (23, 1, 'Illinois');
INSERT INTO `state` VALUES (24, 1, 'Louisiana');
INSERT INTO `state` VALUES (25, 1, 'Minnesota');
INSERT INTO `state` VALUES (26, 1, 'Nevada');
INSERT INTO `state` VALUES (27, 1, 'North Carolina');
INSERT INTO `state` VALUES (28, 1, 'Pennsylvania');
INSERT INTO `state` VALUES (29, 1, 'Texas');
INSERT INTO `state` VALUES (30, 1, 'West Virginia');
INSERT INTO `state` VALUES (31, 1, 'Arkansas');
INSERT INTO `state` VALUES (32, 1, 'Florida');
INSERT INTO `state` VALUES (33, 1, 'Indiana');
INSERT INTO `state` VALUES (34, 1, 'Maine');
INSERT INTO `state` VALUES (35, 1, 'Mississippi');
INSERT INTO `state` VALUES (36, 1, 'New Hampshire');
INSERT INTO `state` VALUES (37, 1, 'North Dakota');
INSERT INTO `state` VALUES (38, 1, 'Rhode Island');
INSERT INTO `state` VALUES (39, 1, 'Utah');
INSERT INTO `state` VALUES (40, 1, 'Wisconsin');
INSERT INTO `state` VALUES (41, 1, 'California');
INSERT INTO `state` VALUES (42, 1, 'Georgia');
INSERT INTO `state` VALUES (43, 1, 'Lowa');
INSERT INTO `state` VALUES (44, 1, 'Maryland');
INSERT INTO `state` VALUES (45, 1, 'Missouri');
INSERT INTO `state` VALUES (46, 1, 'New Jersey');
INSERT INTO `state` VALUES (47, 1, 'Ohio');
INSERT INTO `state` VALUES (48, 1, 'South Carolina');
INSERT INTO `state` VALUES (49, 1, 'Vermont');
INSERT INTO `state` VALUES (50, 1, 'Wyoming');
INSERT INTO `state` VALUES (51, 6, 'Hong Kong SAR');
INSERT INTO `state` VALUES (52, 7, 'Macau SAR');
INSERT INTO `state` VALUES (53, 8, 'Taiwan');
INSERT INTO `state` VALUES (56, 2, 'Henan');
INSERT INTO `state` VALUES (57, 2, 'Zhejiang');
INSERT INTO `state` VALUES (58, 2, 'Hainan');
INSERT INTO `state` VALUES (60, 1, 'Colorado');
INSERT INTO `state` VALUES (61, 37, 'Chickenbreast');
INSERT INTO `state` VALUES (62, 37, 'Chickenwings');
INSERT INTO `state` VALUES (63, 37, 'Drumstick');
INSERT INTO `state` VALUES (64, 37, 'Chickessence');
INSERT INTO `state` VALUES (65, 37, 'Taitaile');

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics`  (
  `statistics_id` int(0) NOT NULL AUTO_INCREMENT,
  `statistics_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `statistics_month` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `personnel_id` int(0) NULL DEFAULT NULL COMMENT 'seller id',
  `statistics_money_sold` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `statistics_item_sold` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`statistics_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload`  (
  `uploadFolderId` int(0) NOT NULL AUTO_INCREMENT,
  `uploadFolder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uploadFolderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES (1, 'http://127.0.0.1:8887/upload/');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_pron` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_addr
-- ----------------------------
DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr`  (
  `user_addr_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `addr_region_id` int(0) NULL DEFAULT NULL,
  `addr_state_id` int(0) NULL DEFAULT NULL,
  `addr_city_id` int(0) NULL DEFAULT NULL,
  `addr_postcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_addr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_payment
-- ----------------------------
DROP TABLE IF EXISTS `user_payment`;
CREATE TABLE `user_payment`  (
  `user_payment_id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `user_payment_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_payment_card_exp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_payment_card_cvs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_payment_pref` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_payment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
