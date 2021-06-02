CREATE DATABASE  IF NOT EXISTS `cityhall` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cityhall`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: cityhall
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `idaddress` varchar(500) NOT NULL,
  `addressname` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `postalcode` varchar(6) NOT NULL,
  `iduser` varchar(100) NOT NULL,
  PRIMARY KEY (`idaddress`),
  KEY `user_fk_idx` (`iduser`),
  CONSTRAINT `userfk` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('3f06c8a1-ad41-4761-9260-b45d25c3cc9e','Str. Ciocarliei, nr. 42','Cluj-Napoca','400619','2'),('62d2a401-a07d-4e12-b0b5-078deffc5d99','Str. Ciocarliei, nr 42, ap 21','Cluj','123455','497d03b6-a3a1-4b87-be45-8f39eb32f660'),('99b59b23-2f00-4901-8eec-13463453f8b0','Str. Mare nr. 34','Cluj-Napoca','400692','497d03b6-a3a1-4b87-be45-8f39eb32f660');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `iddocument` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `idrequest` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iddocument`),
  KEY `FK7ykoe3qi3rfwk1a6bj7g8pjtk` (`idrequest`),
  CONSTRAINT `FK7ykoe3qi3rfwk1a6bj7g8pjtk` FOREIGN KEY (`idrequest`) REFERENCES `request` (`idrequest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES ('4f43e715-ee26-45be-92f9-caa562a3e6d8','Cerere tip 1','Cerere',NULL);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `idrequest` varchar(500) NOT NULL,
  `iddocument` varchar(100) NOT NULL,
  `iduser` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `approved` int DEFAULT NULL,
  `idaddress` varchar(255) DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idrequest`),
  KEY `user_fk_idx` (`iduser`),
  KEY `document_fk_idx` (`iddocument`),
  KEY `address_fk` (`idaddress`) /*!80000 INVISIBLE */,
  KEY `FKq7tqwh7y86vat5v5tcqkoxrr6` (`document`),
  KEY `FKswvn4b6grbe0csree72kdshu1` (`address`),
  CONSTRAINT `address_fk` FOREIGN KEY (`idaddress`) REFERENCES `address` (`idaddress`),
  CONSTRAINT `document_fk` FOREIGN KEY (`iddocument`) REFERENCES `document` (`iddocument`),
  CONSTRAINT `FKq7tqwh7y86vat5v5tcqkoxrr6` FOREIGN KEY (`document`) REFERENCES `document` (`iddocument`),
  CONSTRAINT `FKswvn4b6grbe0csree72kdshu1` FOREIGN KEY (`address`) REFERENCES `address` (`idaddress`),
  CONSTRAINT `user_fk` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES ('2','4f43e715-ee26-45be-92f9-caa562a3e6d8','497d03b6-a3a1-4b87-be45-8f39eb32f660','2021-03-25 00:00:00',1,'99b59b23-2f00-4901-8eec-13463453f8b0',NULL,NULL),('66696774-a83c-4e69-b9f3-b4e584b6b3d6','4f43e715-ee26-45be-92f9-caa562a3e6d8','497d03b6-a3a1-4b87-be45-8f39eb32f660','2021-03-25 00:00:00',-1,'62d2a401-a07d-4e12-b0b5-078deffc5d99',NULL,NULL);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  `CNP` varchar(13) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` int NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','Streang Florena','0757176949','streangflorena@gmail.com','2990607123444','123123',1),('2','Streang Florena','0757176949','streangflorena@gmail.com','2990607123444','123123',1),('3','Cosmin','0788987867','cos@mn.com','1990908123111','123Abc!dd',0),('497d03b6-a3a1-4b87-be45-8f39eb32f660','Florena','0789098754','flo@mn.com','1990607123111','abc123A!er',0),('d1e2e5d0-6cfb-4b66-adf5-dad7c1aa9e42','Cuibus Cosmin','0743127845','cuibus.alex@yahoo.com','9876543211011','Alex!2399',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cityhall'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-26  7:53:52
