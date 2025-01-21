CREATE DATABASE  IF NOT EXISTS `sistemamecatec` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sistemamecatec`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemamecatec
-- ------------------------------------------------------
-- Server version	9.1.0

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
-- Table structure for table `cabecera_venta`
--

DROP TABLE IF EXISTS `cabecera_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cabecera_venta` (
  `id_cabecera` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `valor_pagar` double NOT NULL,
  `fecha_venta` datetime(6) DEFAULT NULL,
  `estado` int NOT NULL,
  PRIMARY KEY (`id_cabecera`),
  KEY `cabecera_venta_ibfk_1` (`id_cliente`),
  CONSTRAINT `cabecera_venta_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cabecera_venta`
--

LOCK TABLES `cabecera_venta` WRITE;
/*!40000 ALTER TABLE `cabecera_venta` DISABLE KEYS */;
INSERT INTO `cabecera_venta` VALUES (7,1,20,'2025-01-20 00:00:00.000000',1);
/*!40000 ALTER TABLE `cabecera_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (5,'FILTROS DE AIRE',1),(6,'FILTRO DE COMBUSTIBLE',1),(7,'FILTRO DE ACEITE',1),(8,'FILTRO DE REFRIGERANTE',1),(9,'EMPAQUE',1);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `dni_ruc` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'DNI','73200713','Sergio Junior Quispe Castro','907218182','Av. Aviación Mz. B Lt. 10',0),(4,'RUC','1234567 ','Ricardo Angelo','907218182','Masisea',1),(8,'DNI','20071004','Richard Quispe Espinoza','959746341','Av. Yarina',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `id_cabecera` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio_unitario` double NOT NULL,
  `descuento` double NOT NULL,
  `igv` double NOT NULL,
  `total_pagar` int DEFAULT NULL,
  `estado` int NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_cabecera` (`id_cabecera`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_cabecera`) REFERENCES `cabecera_venta` (`id_cabecera`),
  CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (5,7,1,1,0,0,0,0,1);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio` double(10,2) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `igv` int DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `categoriaDescripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'26510353','PERKINS','FILTRO DE AIRE',3,0.00,'',0,5,1,NULL),(2,'26510337','PERKINS','FILTRO DE AIRE',1,0.00,'',0,5,1,NULL),(3,'135326206 - AF27867','PERKINS','FILTRO DE AIRE',2,0.00,'',0,5,1,NULL),(4,'5543095','PERKINS','FILTRO DE AIRE',2,0.00,'',0,5,1,NULL),(5,'26510337 - AF25526','PERKINS','FILTRO DE AIRE',2,0.00,'',0,5,1,NULL),(6,'P777639','DONALDSON','FILTRO DE AIRE',4,0.00,'ELEMENTO DE FILTRO SECUNDARIO',0,5,1,NULL),(7,'1R-1804','CAT','FILTRO SEPARADOR',6,185.00,'',0,6,1,NULL),(8,'4816635','PERKINS','FILTRO DE COMBUSTIBLE',6,150.00,'',0,6,1,NULL),(9,'4627133','PERKINS','FILTRO DE ACEITE',3,0.00,'',0,7,1,NULL),(10,'26560145','PERKINS','FILTRO DE COMBUSTIBLE',3,0.00,'',0,6,1,NULL),(11,'4816636','PERKINS','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(12,'2654403','PERKINS','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(13,'26561117','PERKINS','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(14,'901-249','GEN','FILTRO DE COMBUSTIBLE',3,0.00,'',18,6,1,NULL),(15,'26560143','PERKINS','FILTRO DE COMBUSTIBLE',5,0.00,'',0,6,1,NULL),(16,'130306380','PERKINS','FILTRO DE COMBUSTIBLE',2,0.00,'',0,6,1,NULL),(17,'LF701','FLEETGUARD','FILTRO DE ACEITE',4,0.00,'',0,7,1,NULL),(18,'FS1006 - 4095189','FLEETGUARD','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(19,'LF667','FLEETGUARD','FILTRO DE ACEITE',2,0.00,'',0,7,1,NULL),(20,'LF670','FLEETGUARD','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(21,'FS19934','FLEETGUARD','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(22,'FS1216 - 3313304','FLEETGUARD','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(23,'FF2203','FLEETGUARD','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(24,'FF5461','FLEETGUARD','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(25,'FS19624','FLEETGUARD','FILTRO DE COMBUSTIBLE',15,0.00,'',0,6,1,NULL),(26,'FF5021','FLEETGUARD','FILTRO DE COMBUSTIBLE',12,0.00,'',0,6,1,NULL),(27,'FS1000 - 3329289','FLEETGUARD','FILTRO DE COMBUSTIBLE',4,0.00,'',0,6,1,NULL),(28,'FF5319','FLEETGUARD','FILTRO DE ACEITE',2,9.00,'',0,7,1,NULL),(29,'FS1212 - 3315843','FLEETGUARD','FILTRO DE COMBUSTIBLE',2,0.00,'',0,6,1,NULL),(30,'WF2073','FLEETGUARD','FILTRO DE REFRIGERANTE',1,0.00,'',0,8,1,NULL),(31,'FF5488 - 3959612','FLEETGUARD','FILTRO DE COMBUSTIBLE',4,0.00,'',0,6,1,NULL),(32,'P554005','DONALDSON','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(33,'P550774','DONALDSON','FILTRO DE COMBUSTIBLE',3,0.00,'',0,6,1,NULL),(34,'P550900','DONALDSON','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(35,'P553004','DONALDSON','FILTRO DE COMBUSTIBLE',3,0.00,'',0,6,1,NULL),(36,'6495042','N/A','FILTRO DE COMBUSTIBLE',2,0.00,'10 MICRON',0,6,1,NULL),(37,'WC-5705','SAKURA','FILTRO DE REFRIGERANTE',1,0.00,'9N-3368; 3315116; 1289132',0,8,1,NULL),(38,'T-160','PUROLATOR','FILTRO DE PETROLEO',1,0.00,'',0,6,1,NULL),(39,'BLS-1A','WILLY BUSCH','FILTRO DE ACEITE',1,0.00,'',0,7,1,NULL),(40,'84348882','CNH','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(41,'4415122','PERKINS','FILTRO DE COMBUSTIBLE',6,0.00,'',0,6,1,NULL),(42,'140517050','PERKINS','FILTRO DE ACEITE',2,0.00,'',0,7,1,NULL),(43,'26561118','PERKINS','FILTRO DE COMBUSTIBLE',10,0.00,'',0,6,1,NULL),(44,'4461492 - R50FCPE005','PERKINS','FILTRO DE COMBUSTIBLE',1,0.00,'',0,6,1,NULL),(45,'131390 - CUM3017750','PAI','EMPAQUE DE BALANCIN',2,0.00,'PAQUETE CONTIENE 3',0,9,1,NULL),(46,'3067459','N/A','EMPAQUE DE BALANCIN',3,0.00,'',0,9,1,NULL),(47,'IDP-3634664','IPD','EMPAQUE DE CULATA',6,0.00,'',0,9,1,NULL),(48,'IPD4920076','IPD','EMPAQUE DE BALANCIN',3,0.00,'',0,9,1,NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `estado` int NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Sergio Junior','Quispe Castro','sergio','1234','9072181821',1),(3,'Ricardo Angelo','Quispe Castro','ricardo','1234','9072181821123',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-20 21:19:02
