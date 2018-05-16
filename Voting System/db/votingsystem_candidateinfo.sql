-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: votingsystem
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `candidateinfo`
--

DROP TABLE IF EXISTS `candidateinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidateinfo` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Cfirstname` varchar(45) NOT NULL,
  `Cmiddlename` varchar(45) DEFAULT NULL,
  `Clastname` varchar(45) NOT NULL,
  `Cphoto` varchar(45) NOT NULL,
  `Cvid` varchar(45) NOT NULL,
  `Cdistrict` varchar(45) NOT NULL,
  `Cdivision` varchar(45) NOT NULL,
  `Csubdistrict` varchar(45) NOT NULL,
  `CSign` varchar(45) NOT NULL,
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cid_UNIQUE` (`Cid`),
  UNIQUE KEY `Cphoto_UNIQUE` (`Cphoto`)
) ENGINE=InnoDB AUTO_INCREMENT=454568863 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidateinfo`
--

LOCK TABLES `candidateinfo` WRITE;
/*!40000 ALTER TABLE `candidateinfo` DISABLE KEYS */;
INSERT INTO `candidateinfo` VALUES (454568857,'Khaleda','','Zia','khaledazia.jpg','56783229','Tangail','Dhaka','Tangail Sadar','d.jpg'),(454568858,'Sekh','','Hasina','sekh hasina.jpg','56783228','Tangail','Dhaka','Tangail Sadar','b.jpg');
/*!40000 ALTER TABLE `candidateinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-04 18:52:31
