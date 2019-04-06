#数据库创建
CREATE DATABASE `DaDa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

#用户表创建

use  dada;
#用户表创建
CREATE TABLE `user_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `user_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名（登录名）',
 `user_pwd` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码',
 `user_mobile` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号\n',
 `user_icon` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头像\n',
 `user_real_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名\n',
 `user_identity_card` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证\n',
 `user_nick_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '昵称\n',
 `user_sign` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '个性签名\n',
 `user_state` varchar(2) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '用户登录状态\n',
 `push_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建轮播图表
CREATE TABLE `banner_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `bannerImageUrl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '轮播图Url',
 `clickUrl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '跳转url',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

# 创建频道表
CREATE TABLE `channel_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `channelUrl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '频道Url',
 `channelName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '频道名',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建公告栏
CREATE TABLE `comment_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `urlText` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公告url',
 `showText` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公告名',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建头条商品
CREATE TABLE `top_news_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `leftTopImageUrl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头条title图标',
 `topName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头条title',
 `topDesc` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头条描述',
 `goodsUrlLeft` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头条左商品url',
 `goodsUrlRight` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '头条右商品url',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建为您推荐
CREATE TABLE `recommend_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goodsImageUrl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '为您推荐图片url',
 `goodsName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名',
 `goodsPrice` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品价格',
 `goodsLabel` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'label标签',
 `address` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
 `manName` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商家名',
 `releaseTime` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布时间',
 `goodsDesc` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品描述',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

# 创建分类
CREATE TABLE `classify_type_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `typeName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类title',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建子条目1
CREATE TABLE `classify_desc_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `classifyTypeId` int(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类id',
 `typeName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '子条目名',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


# 创建子条目2
CREATE TABLE `goods_type_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `classifyDescId` int(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '子条目id',
 `goodsImageUrl` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品图片url',
 `goodsName` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



#购物车表创建
CREATE TABLE `cart_goods` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_count` int(11) DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 `goods_sku` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品分类创建
CREATE TABLE `category` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `category_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `category_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `parent_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品信息表创建
CREATE TABLE `goods_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `category_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_banner` text COLLATE utf8_unicode_ci,
 `goods_detail_one` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_detail_two` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_sales_count` int(11) DEFAULT NULL,
 `goods_stock_count` int(11) DEFAULT NULL,
 `goods_code` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_default_sku` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#商品sku表创建
CREATE TABLE `goods_sku` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_sku_title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_sku_content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

#消息表创建
CREATE TABLE `message_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `msg_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_title` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `msg_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#订单商品表创建
	CREATE TABLE `order_goods` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `goods_id` int(11) DEFAULT NULL,
 `goods_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_price` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `goods_count` int(11) DEFAULT NULL,
 `goods_sku` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
 `order_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#订单信息表创建
CREATE TABLE `order_info` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `user_id` int(11) DEFAULT NULL,
 `pay_type` int(11) DEFAULT NULL,
 `ship_id` int(11) DEFAULT NULL,
 `total_price` int(11) DEFAULT NULL,
 `order_status` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
#地址管理表创建
	CREATE TABLE `ship_address` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `ship_user_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_user_mobile` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
 `ship_is_default` int(11) DEFAULT NULL,
 `user_id` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci


