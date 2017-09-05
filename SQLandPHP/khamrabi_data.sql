-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Aug 27, 2017 at 10:20 PM
-- Server version: 5.6.33-log
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `khamrabi_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE IF NOT EXISTS `medicine` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `medname` varchar(70) NOT NULL,
  `description` varchar(40) NOT NULL,
  `price` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`id`, `medname`, `description`, `price`) VALUES
(1, 'Panadol', 'demam', '20'),
(2, 'Pain Killer', 'bila perlu', '100'),
(3, 'p', '', 'p'),
(5, 'qw', '', 'qeq'),
(6, 'qw', 'qwqw', 'wqwqw'),
(7, '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `username`, `password`, `email`) VALUES
('admin', 'admin', '123456', 'admin@pocketmedicine.com'),
('Massolihen Dasuki', 'masso', '123456', 'massodasuki@gmail.com'),
('massolihen', 'massodasuki', '123456', 'masso@gmail.com'),
('nasuha', 'suha', 'chuaa97', 'siti.nasuha1997@gmail.com'),
('syakira', 'syakira', 'sayala97', 'syakiraajiera97@gmail.com');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
