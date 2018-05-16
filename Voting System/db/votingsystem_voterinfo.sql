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
-- Table structure for table `voterinfo`
--

DROP TABLE IF EXISTS `voterinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voterinfo` (
  `Vid` int(11) NOT NULL AUTO_INCREMENT,
  `Vfirstname` varchar(45) NOT NULL,
  `Vmiddlename` varchar(45) DEFAULT NULL,
  `Vlastname` varchar(45) NOT NULL,
  `DOB` varchar(45) NOT NULL,
  `Vdivision` varchar(45) NOT NULL,
  `Vdistrict` varchar(45) NOT NULL,
  `Vsubdistrict` varchar(45) NOT NULL,
  `Vphotopath` varchar(45) NOT NULL,
  `Vfathersname` varchar(45) NOT NULL,
  `Vmothersname` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `VoteCounter` int(11) NOT NULL,
  `Vsex` varchar(45) NOT NULL,
  PRIMARY KEY (`Vid`)
) ENGINE=InnoDB AUTO_INCREMENT=56783231 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voterinfo`
--

LOCK TABLES `voterinfo` WRITE;
/*!40000 ALTER TABLE `voterinfo` DISABLE KEYS */;
INSERT INTO `voterinfo` VALUES (56783227,'Nahid','','Niaz','21/9/2001','Dhaka','Tangail','Tangail Sadar','download.jpg','Abdul Alim','Nargis Parvin','tut',0,'Male'),(56783228,'Sekh','','Hasina','17/12/1940','Dhaka','Tangail','Tangail Sadar','sekh hasina.jpg','Sekh Mujibar Rahman','Sekh Fazilatunnesa','SekhHasina',0,'Female'),(56783229,'Khaleda','','Zia','10/12/1935','Dhaka','Tangail','Tangail Sadar','khaledazia.jpg','ghvd','wsbyhb','KhaledaZia',0,'Female');
/*!40000 ALTER TABLE `voterinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-04 18:52:32
