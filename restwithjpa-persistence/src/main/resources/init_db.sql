CREATE DATABASE  IF NOT EXISTS `restwithjpa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `restwithjpa`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restwithjpa
-- ------------------------------------------------------
-- Server version	5.6.10-log

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

-- `create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
-- `create_user` varchar(100) DEFAULT NULL,

--
-- Table structure for table `podcasts`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` varchar(500) NULL,
  `album_id` bigint(20) NOT NULL ,
  
  PRIMARY KEY (`id`),
  FOREIGN KEY (album_id) REFERENCES album(id)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `artist_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (artist_id) REFERENCES artist(id)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playlist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `track_id` bigint(20) NOT NULL ,
  PRIMARY KEY (`id`),
  FOREIGN KEY (track_id) REFERENCES track(id)

) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `playlist_item`;
CREATE TABLE `restwithjpa`.`playlist_item` (
  `playlist_id` INT NOT NULL,
  `track_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`, `track_id`),
  INDEX `playlist_item` (`playlist_id` ASC, `track_id` ASC)
 
    );
