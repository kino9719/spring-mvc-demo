CREATE DATABASE IF NOT EXISTS shop;

USE shop;


SET NAMES utf8;
SET character_set_client = utf8;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(300) NOT NULL,
  `name` varchar(30) NOT NULL,
  `is_admin` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `account` WRITE;
INSERT INTO `account` (`id`, `username`, `password`, `name`, `is_admin`) VALUES (1,'admin','$2y$10$MACt5540ZVicG3ybHYeT/Ooxb9ptrUYIhrsrgtrPdE0lW9PzoL3Hi','Admin',1);
INSERT INTO `account` (`id`, `username`, `password`, `name`, `is_admin`) VALUES (2,'user','$2y$10$boDhj6TghoPjabKlZD8NC.yY8xU4QmuyguxSoaf5L92CKBFXG8Uq2','User',0);
INSERT INTO `account` (`id`, `username`, `password`, `name`, `is_admin`) VALUES (3,'user2','$2y$10$boDhj6TghoPjabKlZD8NC.yY8xU4QmuyguxSoaf5L92CKBFXG8Uq2','User2',0);
INSERT INTO `account` (`id`, `username`, `password`, `name`, `is_admin`) VALUES (4,'user3','$2y$10$boDhj6TghoPjabKlZD8NC.yY8xU4QmuyguxSoaf5L92CKBFXG8Uq2','User3',0);
INSERT INTO `account` (`id`, `username`, `password`, `name`, `is_admin`) VALUES (5,'user4','$2y$10$boDhj6TghoPjabKlZD8NC.yY8xU4QmuyguxSoaf5L92CKBFXG8Uq2','User4',0);
UNLOCK TABLES;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `item` WRITE;
INSERT INTO `item` (`id`, `name`, `price`) VALUES (1,'蘋果',20);
INSERT INTO `item` (`id`, `name`, `price`) VALUES (2,'香蕉',10);
INSERT INTO `item` (`id`, `name`, `price`) VALUES (3,'芭樂',15);
UNLOCK TABLES;


DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `item_id` int(10) unsigned NOT NULL,
  `amount` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `order_item` WRITE;
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (1,1,2,3);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (2,1,1,1);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (3,2,3,2);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (4,3,1,1);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (5,3,3,3);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (6,4,2,1);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (7,5,1,1);
INSERT INTO `order_item` (`id`, `order_id`, `item_id`, `amount`) VALUES (8,5,2,3);
UNLOCK TABLES;


DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(11) unsigned NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(60) NOT NULL,
  `created_time` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `user_order` WRITE;
INSERT INTO `user_order` (`id`, `account_id`, `phone`, `address`, `created_time`) VALUES (1,2,'0987654123','台北市南港區研究院路239號',1595077206);
INSERT INTO `user_order` (`id`, `account_id`, `phone`, `address`, `created_time`) VALUES (2,2,'0987654123','台北市南港區研究院路239號',1595078206);
INSERT INTO `user_order` (`id`, `account_id`, `phone`, `address`, `created_time`) VALUES (3,3,'0981654100','台北市南港區研究院路272號',1595079206);
INSERT INTO `user_order` (`id`, `account_id`, `phone`, `address`, `created_time`) VALUES (4,4,'0921654102','台北市南港區研究院路212號',1595079212);
INSERT INTO `user_order` (`id`, `account_id`, `phone`, `address`, `created_time`) VALUES (5,5,'0921634102','台北市南港區研究院路242號',1595079256);
UNLOCK TABLES;


