CREATE DATABASE  IF NOT EXISTS `pos_cats`;
USE `pos_cats`;

--
-- Table structure for table `cats`
--

DROP TABLE IF EXISTS `cats`;

CREATE TABLE `cats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;