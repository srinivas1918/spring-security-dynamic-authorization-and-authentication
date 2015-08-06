/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.29 : Database - security_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`security_test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `security_test`;

/*Table structure for table `action` */

CREATE TABLE `action` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `action` */

insert  into `action`(`ID`,`NAME`) values (1,'/userPage');
insert  into `action`(`ID`,`NAME`) values (2,'/adminPage');
insert  into `action`(`ID`,`NAME`) values (3,'/dashboard');

/*Table structure for table `role` */

CREATE TABLE `role` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `role` */

insert  into `role`(`ROLE_ID`,`ROLE_NAME`) values (1,'ROLE_ADMIN');
insert  into `role`(`ROLE_ID`,`ROLE_NAME`) values (2,'ROLE_USER');

/*Table structure for table `role_action` */

CREATE TABLE `role_action` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(11) DEFAULT NULL,
  `ACTION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ROLE_ID` (`ROLE_ID`),
  KEY `ACTION_ID` (`ACTION_ID`),
  CONSTRAINT `role_action_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`),
  CONSTRAINT `role_action_ibfk_2` FOREIGN KEY (`ACTION_ID`) REFERENCES `action` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `role_action` */

insert  into `role_action`(`ID`,`ROLE_ID`,`ACTION_ID`) values (1,1,2);
insert  into `role_action`(`ID`,`ROLE_ID`,`ACTION_ID`) values (2,2,1);
insert  into `role_action`(`ID`,`ROLE_ID`,`ACTION_ID`) values (3,1,3);
insert  into `role_action`(`ID`,`ROLE_ID`,`ACTION_ID`) values (7,2,3);

/*Table structure for table `user` */

CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (1,'srinivas','srinivas');
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (2,'rajesh','rajesh');
insert  into `user`(`ID`,`USERNAME`,`PASSWORD`) values (4,'ben','ben');

/*Table structure for table `user_role` */

CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `USER_ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `USER_ID` (`USER_ID`),
  KEY `USER_ROLE` (`USER_ROLE`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`USER_ROLE`) REFERENCES `role` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `user_role` */

insert  into `user_role`(`ID`,`USER_ID`,`USER_ROLE`) values (1,1,1);
insert  into `user_role`(`ID`,`USER_ID`,`USER_ROLE`) values (2,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
