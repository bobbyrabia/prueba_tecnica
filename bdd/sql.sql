/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.24-MariaDB : Database - empresas
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`empresas` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `empresas`;

/*Table structure for table `department_employees` */

DROP TABLE IF EXISTS `department_employees`;

CREATE TABLE `department_employees` (
  `id` int(20) NOT NULL,
  `created_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `id_department` int(20) DEFAULT NULL,
  `id_employee` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dpemp_emp` (`id_employee`),
  KEY `fk_dpemp_dep` (`id_department`),
  CONSTRAINT `fk_dpemp_dep` FOREIGN KEY (`id_department`) REFERENCES `departments` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_dpemp_emp` FOREIGN KEY (`id_employee`) REFERENCES `employees` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `department_employees` */

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `id` int(20) NOT NULL,
  `created_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `id_enterprise` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dep_enter` (`id_enterprise`),
  CONSTRAINT `fk_dep_enter` FOREIGN KEY (`id_enterprise`) REFERENCES `enterprises` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `departments` */

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int(20) NOT NULL,
  `created_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `position` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `surname` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employees` */

/*Table structure for table `enterprises` */

DROP TABLE IF EXISTS `enterprises`;

CREATE TABLE `enterprises` (
  `id` int(20) NOT NULL,
  `created_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `address` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `enterprises` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
