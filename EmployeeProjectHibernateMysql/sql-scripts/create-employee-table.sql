CREATE DATABASE  IF NOT EXISTS `employee_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `employee_database`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hb_student_tracker
-- ------------------------------------------------------
-- Server version	8.0.12



--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `employee`
--


INSERT INTO `employee` VALUES (1,'Ion Popescu',2121,'PROGRAMMER','2018-10-24'),(2,'Rusnac Boris',5,'MANAGER','2018-10-25'),(64,'Gheorghe Sprancean',10000,'MANAGER','2017-01-02');

-- Dump completed on 2018-11-02 15:43:42
