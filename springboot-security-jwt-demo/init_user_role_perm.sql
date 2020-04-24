-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_spring_security
-- ------------------------------------------------------
-- Server version	8.0.12

 SET NAMES utf8 ;
--
-- Table structure for table `tb_perm`
--

DROP TABLE IF EXISTS `tb_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_perm` (
  `perm_id` int(11) NOT NULL,
  `perm_name` varchar(255) DEFAULT NULL,
  `perm_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perm`
--

LOCK TABLES `tb_perm` WRITE;
/*!40000 ALTER TABLE `tb_perm` DISABLE KEYS */;
INSERT INTO `tb_perm` VALUES (1001,'PERM_SUPER_ADMIN','超级管理员权限'),(1002,'PERM_ADMIN','管理员权限'),(1003,'PERM_USER','用户权限');
/*!40000 ALTER TABLE `tb_perm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role`
--

DROP TABLE IF EXISTS `tb_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_name_cn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role`
--

LOCK TABLES `tb_role` WRITE;
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` VALUES (1001,'ROLE_USER','用户角色'),(1002,'ROLE_ADMIN','管理员角色'),(1003,'ROLE_SUPER_ADMIN','超级管理员角色');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_role_perms`
--

DROP TABLE IF EXISTS `tb_role_perms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_role_perms` (
  `role_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FKe4pg9abk9r1fqdg9cnns770fs` (`perm_id`),
  KEY `FKh3374c7rkn9pq8taocj138sya` (`role_id`),
  CONSTRAINT `FKe4pg9abk9r1fqdg9cnns770fs` FOREIGN KEY (`perm_id`) REFERENCES `tb_perm` (`perm_id`),
  CONSTRAINT `FKh3374c7rkn9pq8taocj138sya` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_role_perms`
--

LOCK TABLES `tb_role_perms` WRITE;
/*!40000 ALTER TABLE `tb_role_perms` DISABLE KEYS */;
INSERT INTO `tb_role_perms` VALUES (1003,1001,1),(1003,1002,2),(1003,1003,3),(1002,1003,4),(1002,1002,5),(1001,1003,6);
/*!40000 ALTER TABLE `tb_role_perms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_4wv83hfajry5tdoamn8wsqa6x` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (2,'$2a$10$je3bwT5qx5g7IwkMl2cAhOanNvYQ.yS2tPTVV8RE5YWncjNSLQqXa','user',NULL,NULL,NULL),(3,'$2a$10$n3YK/Qg6zhqdSsE42nChSORJeiBLDJLjPvH.D6R/rA6A3qk25p98K','admin',NULL,NULL,NULL),(4,'$2a$10$UQdfbm83cSo.kQPwUxBhyOVuKALVSeGEUEClvK5EwxVkc.T5Nii96','super_admin',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_roles`
--

DROP TABLE IF EXISTS `tb_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tb_user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `FK5o9d9rl9k13q40whacubb68iw` (`user_id`),
  KEY `FK74x8ohevn3n8ear73rrmbmn19` (`role_id`),
  CONSTRAINT `FK5o9d9rl9k13q40whacubb68iw` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `FK74x8ohevn3n8ear73rrmbmn19` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_roles`
--

LOCK TABLES `tb_user_roles` WRITE;
/*!40000 ALTER TABLE `tb_user_roles` DISABLE KEYS */;
INSERT INTO `tb_user_roles` VALUES (2,1001,1),(3,1002,2),(3,1001,3),(4,1001,4),(4,1002,5),(4,1003,6);
/*!40000 ALTER TABLE `tb_user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
