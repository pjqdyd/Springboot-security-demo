-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_spring_security_oauth2
-- ------------------------------------------------------
-- Server version	8.0.12

 SET NAMES utf8 ;

DROP TABLE IF EXISTS `tb_perm`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_perm` (
  `perm_id` int(11) NOT NULL,
  `perm_name` varchar(255) DEFAULT NULL,
  `perm_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tb_perm` WRITE;
INSERT INTO `tb_perm` VALUES (3001,'管理员查看权限','PERM_ADMIN_SELECT'),(3002,'管理员删除权限','PERM_ADMIN_DELETE'),(3003,'用户查看权限','PERM_USER_SELECT'),(3004,'用户删除权限','PERM_USER_DELETE');
UNLOCK TABLES;

DROP TABLE IF EXISTS `tb_role`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tb_role` WRITE;
INSERT INTO `tb_role` VALUES (2001,'管理员','ROLE_ADMIN'),(2002,'用户','ROLE_USER');
UNLOCK TABLES;


DROP TABLE IF EXISTS `tb_role_perm`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_role_perm` (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `tb_role_perm` WRITE;
INSERT INTO `tb_role_perm` VALUES (2001,3001,1),(2001,3002,2),(2002,3003,3),(2002,3004,4);
UNLOCK TABLES;


DROP TABLE IF EXISTS `tb_user`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_4wv83hfajry5tdoamn8wsqa6x` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tb_user` WRITE;
INSERT INTO `tb_user` VALUES (1001,18,'$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi','admin'),(1002,18,'$2a$10$9ZhDOBp.sRKat4l14ygu/.LscxrMUcDAfeVOEPiYwbcRkoB09gCmi','user');
UNLOCK TABLES;


DROP TABLE IF EXISTS `tb_user_role`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `tb_user_role` WRITE;
INSERT INTO `tb_user_role` VALUES (2001,1001,1),(2002,1001,2),(2002,1002,3);
UNLOCK TABLES;
