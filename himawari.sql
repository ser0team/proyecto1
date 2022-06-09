CREATE DATABASE  IF NOT EXISTS `himawari` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `himawari`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: himawari
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `almacen` (
  `idalmacen` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `municipio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colonia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codpost` int DEFAULT NULL,
  `calle` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `noext` int DEFAULT NULL,
  `noint` int DEFAULT NULL,
  `fechareg` date DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idalmacen`),
  KEY `idusuario_idx` (`idusuario`),
  KEY `idempresa_idx` (`idempresa`),
  CONSTRAINT `idempr_alm` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_alm` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anaqueles`
--

DROP TABLE IF EXISTS `anaqueles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anaqueles` (
  `idanaquel` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idbin` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idanaquel`),
  KEY `idusu_ana_idx` (`idusuario`),
  KEY `idemp_ana_idx` (`idempresa`),
  CONSTRAINT `idempr_ana` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_ana` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anaqueles`
--

LOCK TABLES `anaqueles` WRITE;
/*!40000 ALTER TABLE `anaqueles` DISABLE KEYS */;
/*!40000 ALTER TABLE `anaqueles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bines`
--

DROP TABLE IF EXISTS `bines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bines` (
  `idbin` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idbin`),
  KEY `idusu_bin_idx` (`idusuario`),
  KEY `id_empr_bin_idx` (`idempresa`),
  CONSTRAINT `id_empr_bin` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_bin` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bines`
--

LOCK TABLES `bines` WRITE;
/*!40000 ALTER TABLE `bines` DISABLE KEYS */;
/*!40000 ALTER TABLE `bines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caja` (
  `idcaja` int NOT NULL,
  `caja` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idcaja`),
  KEY `idusu_caja_idx` (`idusuario`),
  KEY `idempr_caja_idx` (`idempresa`),
  CONSTRAINT `idempr_caja` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_caja` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rfc` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `municipio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codpost` int DEFAULT NULL,
  `colonia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `clientescol` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `calle` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `noext` int DEFAULT NULL,
  `noint` int DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idusuario` int DEFAULT NULL,
  `idempresa` int DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `idusu_cli_idx` (`idusuario`),
  KEY `idusu_emp_bin_idx` (`idempresa`),
  CONSTRAINT `idempr_cli` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_cli` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `idcompra` int NOT NULL,
  `idproveedor` int NOT NULL,
  `proveedor` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechacom` date DEFAULT NULL,
  `observaciones` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  `idempleado` int NOT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `idempl_comp_idx` (`idproveedor`,`idempleado`),
  KEY `idusu_comp_idx` (`idusuario`),
  KEY `idempr_comp_idx` (`idempresa`),
  KEY `idempl_comp_idx1` (`idempleado`),
  CONSTRAINT `idempl_com` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`),
  CONSTRAINT `idempr_com` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idprov_com` FOREIGN KEY (`idproveedor`) REFERENCES `proveedores` (`idproveedor`),
  CONSTRAINT `idusu_com` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_productos`
--

DROP TABLE IF EXISTS `compras_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_productos` (
  `idcompracreada` int NOT NULL,
  `idcompra` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idcompracreada`),
  KEY `idusu_comprod_idx` (`idusuario`),
  KEY `idempr_comprod_idx` (`idempresa`),
  KEY `idprod_comprod_idx` (`idproducto`),
  KEY `idcomp_comprod_idx` (`idcompra`),
  CONSTRAINT `idcomp_comprod` FOREIGN KEY (`idcompra`) REFERENCES `compras` (`idcompra`),
  CONSTRAINT `idempr_comprod` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idprod_comprod` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_comprod` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_productos`
--

LOCK TABLES `compras_productos` WRITE;
/*!40000 ALTER TABLE `compras_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corte`
--

DROP TABLE IF EXISTS `corte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corte` (
  `idcorte` int NOT NULL,
  `corte` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechacorte` date DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idcorte`),
  KEY `idusu_cor_idx` (`idusuario`),
  KEY `idempr_cor_idx` (`idempresa`),
  CONSTRAINT `idempr_cor` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_cor` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corte`
--

LOCK TABLES `corte` WRITE;
/*!40000 ALTER TABLE `corte` DISABLE KEYS */;
/*!40000 ALTER TABLE `corte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idempleado` int NOT NULL,
  `nombre` varchar(70) COLLATE utf8_spanish_ci NOT NULL,
  `paterno` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `materno` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechanac` date NOT NULL,
  `direccion` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `idempr_empl_idx` (`idempresa`),
  CONSTRAINT `idempr_empl` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `idempresa` int NOT NULL,
  `razonsocial` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rfc` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pais` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `municipio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `colonia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `calle` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `noext` int DEFAULT NULL,
  `noint` int DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `idfactura` int NOT NULL,
  `idventa` int NOT NULL,
  `tipo venta` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idcliente` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `idvent_fact_idx` (`idventa`),
  KEY `idcli_fact_idx` (`idcliente`),
  KEY `idusu_fact_idx` (`idusuario`),
  KEY `idempr_fact_idx` (`idempresa`),
  CONSTRAINT `idcli_fact` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`),
  CONSTRAINT `idempr_fact` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_fact` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`),
  CONSTRAINT `idvent_fact` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `idinventario` int NOT NULL,
  `idproducto` int NOT NULL,
  `idalmacen` int NOT NULL,
  `idpasillo` int NOT NULL,
  `idanaquel` int NOT NULL,
  `idbin` int NOT NULL,
  `cantidadtotal` double DEFAULT NULL,
  `fechacadu` date DEFAULT NULL,
  `fechaentalm` date DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idinventario`),
  KEY `idprod_inv_idx` (`idproducto`),
  KEY `idalm_inv_idx` (`idalmacen`),
  KEY `idpasi_inv_idx` (`idpasillo`),
  KEY `idana_inv_idx` (`idanaquel`),
  KEY `idbin_inv_idx` (`idbin`),
  KEY `idusu_inv_idx` (`idusuario`),
  KEY `idempr_inv_idx` (`idempresa`),
  CONSTRAINT `idalm_inv` FOREIGN KEY (`idalmacen`) REFERENCES `almacen` (`idalmacen`),
  CONSTRAINT `idana_inv` FOREIGN KEY (`idanaquel`) REFERENCES `anaqueles` (`idanaquel`),
  CONSTRAINT `idbin_inv` FOREIGN KEY (`idbin`) REFERENCES `bines` (`idbin`),
  CONSTRAINT `idempr_inv` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idpasi_inv` FOREIGN KEY (`idpasillo`) REFERENCES `pasillos` (`idpasillo`),
  CONSTRAINT `idprod_inv` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_inv` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia_prima` (
  `idmatprim` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechareg` date DEFAULT NULL,
  `idalmacen` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  `idproducto` int NOT NULL,
  PRIMARY KEY (`idmatprim`),
  KEY `idalm_matprim_idx` (`idalmacen`),
  KEY `idusu_matprim_idx` (`idusuario`),
  KEY `idempr_matprim_idx` (`idempresa`),
  KEY `idprod_matprim_idx` (`idproducto`),
  CONSTRAINT `idalm_matprim` FOREIGN KEY (`idalmacen`) REFERENCES `almacen` (`idalmacen`),
  CONSTRAINT `idempr_matprim` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idprod_matprim` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_matprim` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia_prima`
--

LOCK TABLES `materia_prima` WRITE;
/*!40000 ALTER TABLE `materia_prima` DISABLE KEYS */;
/*!40000 ALTER TABLE `materia_prima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas_venta`
--

DROP TABLE IF EXISTS `notas_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas_venta` (
  `idnota` int NOT NULL,
  `idventa` int NOT NULL,
  `tipoventa` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idnota`),
  KEY `idvenres_nota_idx` (`idventa`),
  KEY `idusu_nota_idx` (`idusuario`),
  KEY `idempr_nota_idx` (`idempresa`),
  CONSTRAINT `idempr_nota` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_nota` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`),
  CONSTRAINT `idvenres_nota` FOREIGN KEY (`idventa`) REFERENCES `ventas_restaurant` (`idventarest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas_venta`
--

LOCK TABLES `notas_venta` WRITE;
/*!40000 ALTER TABLE `notas_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_ventas`
--

DROP TABLE IF EXISTS `orden_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_ventas` (
  `idordenventa` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` double DEFAULT NULL,
  `fechaov` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idordenventa`),
  KEY `idprod_orven_idx` (`idproducto`),
  KEY `idusu_orven_idx` (`idusuario`),
  KEY `idempr_orven_idx` (`idempresa`),
  CONSTRAINT `idempr_orven` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idprod_orven` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_orven` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_ventas`
--

LOCK TABLES `orden_ventas` WRITE;
/*!40000 ALTER TABLE `orden_ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasillos`
--

DROP TABLE IF EXISTS `pasillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasillos` (
  `idpasillo` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idanaquel` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idpasillo`),
  KEY `idana_pasi_idx` (`idanaquel`),
  KEY `idusu_pasi_idx` (`idusuario`),
  KEY `idempr_pasi_idx` (`idempresa`),
  CONSTRAINT `idana_pasi` FOREIGN KEY (`idanaquel`) REFERENCES `anaqueles` (`idanaquel`),
  CONSTRAINT `idempr_pasi` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_pasi` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasillos`
--

LOCK TABLES `pasillos` WRITE;
/*!40000 ALTER TABLE `pasillos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasillos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillos`
--

DROP TABLE IF EXISTS `platillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillos` (
  `idplatillo` int NOT NULL,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fechareg` date DEFAULT NULL,
  `idreceta` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idplatillo`),
  KEY `idrece_plat_idx` (`idreceta`),
  KEY `idusu_plat_idx` (`idusuario`),
  KEY `idempr_plat_idx` (`idempresa`),
  CONSTRAINT `idempr_plat` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idrece_plat` FOREIGN KEY (`idreceta`) REFERENCES `recetas` (`idreceta`),
  CONSTRAINT `idusu_plat` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillos`
--

LOCK TABLES `platillos` WRITE;
/*!40000 ALTER TABLE `platillos` DISABLE KEYS */;
/*!40000 ALTER TABLE `platillos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproducto` int NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codigobarras` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cantmax` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cantmin` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  `idcompra` int NOT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `idusu_prod_idx` (`idusuario`),
  KEY `idempr_prod_idx` (`idempresa`),
  KEY `idcomp_prod_idx` (`idcompra`),
  CONSTRAINT `idcomp_prod` FOREIGN KEY (`idcompra`) REFERENCES `compras` (`idcompra`),
  CONSTRAINT `idempr_prod` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_prod` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idproveedor` int NOT NULL,
  `razonsocial` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `rfc` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `pais` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `municipio` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `colonia` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `codpost` int DEFAULT NULL,
  `calle` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `noint` int DEFAULT NULL,
  `fechareg` date DEFAULT NULL COMMENT 'Fecha de Registro',
  `telefono` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idproveedor`),
  KEY `idempr_prov_idx` (`idempresa`),
  KEY `idusu_prov` (`idusuario`),
  CONSTRAINT `idempr_prov` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idusu_prov` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recetas`
--

DROP TABLE IF EXISTS `recetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recetas` (
  `idreceta` int NOT NULL,
  `cantidad` double DEFAULT NULL,
  `fechareg` date DEFAULT NULL,
  `idmatprim` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  `idproducto` int NOT NULL,
  PRIMARY KEY (`idreceta`),
  KEY `idmatprim_rece_idx` (`idmatprim`),
  KEY `idusu_rece_idx` (`idusuario`),
  KEY `idempr_rece_idx` (`idempresa`),
  KEY `idprod_rece_idx` (`idproducto`),
  CONSTRAINT `idempr_rece` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idmatprim_rece` FOREIGN KEY (`idmatprim`) REFERENCES `materia_prima` (`idmatprim`),
  CONSTRAINT `idprod_rece` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_rece` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recetas`
--

LOCK TABLES `recetas` WRITE;
/*!40000 ALTER TABLE `recetas` DISABLE KEYS */;
/*!40000 ALTER TABLE `recetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuario` int NOT NULL,
  `usuario` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `pass` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `idempleado` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `idempresa_idx` (`idempresa`),
  KEY `idempresa_idxu` (`idempresa`),
  KEY `idempl_usu_idx` (`idempleado`),
  CONSTRAINT `idempl_usu` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`),
  CONSTRAINT `idempr_usu` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idventa` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` double DEFAULT NULL,
  `fechaventa` date DEFAULT NULL,
  `totalventa` double DEFAULT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `idprod_ven_idx` (`idproducto`),
  KEY `idusu_ven_idx` (`idusuario`),
  KEY `idempr_ven_idx` (`idempresa`),
  CONSTRAINT `idempr_ven` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idprod_ven` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_ven` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas_restaurant`
--

DROP TABLE IF EXISTS `ventas_restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas_restaurant` (
  `idventarest` int NOT NULL,
  `comanda` varchar(150) COLLATE utf8_spanish_ci NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` double DEFAULT NULL,
  `fechaventa` date DEFAULT NULL,
  `totalventa` double DEFAULT NULL,
  `idordenventa` int NOT NULL,
  `idusuario` int NOT NULL,
  `idempresa` int NOT NULL,
  PRIMARY KEY (`idventarest`),
  KEY `idordenventa_idx` (`idordenventa`),
  KEY `idprod_ventest_idx` (`idproducto`),
  KEY `idusu_venrest_idx` (`idusuario`),
  KEY `idempr_venrest_idx` (`idempresa`),
  CONSTRAINT `idempr_venrest` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`),
  CONSTRAINT `idorven_venrest` FOREIGN KEY (`idordenventa`) REFERENCES `orden_ventas` (`idordenventa`),
  CONSTRAINT `idprod_ventest` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `idusu_venrest` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_restaurant`
--

LOCK TABLES `ventas_restaurant` WRITE;
/*!40000 ALTER TABLE `ventas_restaurant` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas_restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-08 22:59:09
