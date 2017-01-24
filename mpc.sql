/*
SQLyog Community v12.3.2 (64 bit)
MySQL - 5.5.53-log : Database - mpc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mpc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mpc`;

/*Table structure for table `conversation` */

DROP TABLE IF EXISTS `conversation`;

CREATE TABLE `conversation` (
  `conversationId` int(10) NOT NULL AUTO_INCREMENT,
  `TopicId` int(10) DEFAULT NULL,
  `SubTopicId` int(10) DEFAULT NULL,
  `UserId` int(10) DEFAULT NULL,
  `ContentText` text,
  `StartedDate` varchar(60) DEFAULT NULL,
  `FollowedDate` varchar(60) DEFAULT NULL,
  `NoOfCon` int(10) DEFAULT NULL,
  PRIMARY KEY (`conversationId`),
  KEY `TopicId` (`TopicId`),
  KEY `SubTopicId` (`SubTopicId`),
  KEY `UserId` (`UserId`),
  CONSTRAINT `conversation_ibfk_1` FOREIGN KEY (`TopicId`) REFERENCES `topic` (`TopicId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `conversation_ibfk_2` FOREIGN KEY (`SubTopicId`) REFERENCES `subtopic` (`SubTopicId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `conversation_ibfk_3` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conversation` */

/*Table structure for table `conversationcomment` */

DROP TABLE IF EXISTS `conversationcomment`;

CREATE TABLE `conversationcomment` (
  `CommentId` int(10) NOT NULL AUTO_INCREMENT,
  `conversationId` int(10) DEFAULT NULL,
  `CommentText` text,
  `DateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`CommentId`),
  KEY `conversationId` (`conversationId`),
  CONSTRAINT `conversationcomment_ibfk_1` FOREIGN KEY (`conversationId`) REFERENCES `conversation` (`conversationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `conversationcomment` */

/*Table structure for table `subtopic` */

DROP TABLE IF EXISTS `subtopic`;

CREATE TABLE `subtopic` (
  `SubTopicId` int(10) NOT NULL AUTO_INCREMENT,
  `TopicId` int(10) DEFAULT NULL,
  `SubTopicName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`SubTopicId`),
  KEY `TopicId` (`TopicId`),
  CONSTRAINT `subtopic_ibfk_1` FOREIGN KEY (`TopicId`) REFERENCES `topic` (`TopicId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subtopic` */

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `TopicId` int(10) NOT NULL AUTO_INCREMENT,
  `TopicName` varchar(60) DEFAULT NULL,
  `VesselName` varchar(60) DEFAULT NULL,
  `QCNO` int(10) DEFAULT NULL,
  `alertNo` int(10) DEFAULT NULL,
  PRIMARY KEY (`TopicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserId` int(10) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
