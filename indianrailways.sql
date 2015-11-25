-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2015 at 10:38 AM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `indianrailways`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`cid`, `cname`) VALUES
(1, 'dehradun'),
(2, 'saharanpur'),
(3, 'muradabad'),
(4, 'allahabad'),
(5, 'kanpur'),
(6, 'mugalsarai');

-- --------------------------------------------------------

--
-- Table structure for table `routes`
--

CREATE TABLE IF NOT EXISTS `routes` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rscid` int(11) NOT NULL,
  `rdcid` int(11) NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `rdcid` (`rdcid`),
  KEY `rscid` (`rscid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `routes`
--

INSERT INTO `routes` (`rid`, `rscid`, `rdcid`) VALUES
(1, 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `stations`
--

CREATE TABLE IF NOT EXISTS `stations` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `rid` (`rid`,`cid`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `stations`
--

INSERT INTO `stations` (`sid`, `rid`, `cid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `traininfo`
--

CREATE TABLE IF NOT EXISTS `traininfo` (
  `trainno` varchar(50) NOT NULL,
  `trainname` varchar(100) NOT NULL,
  `sourcecid` int(11) NOT NULL,
  `destcid` int(11) NOT NULL,
  `runningdays` varchar(52) NOT NULL,
  `status` varchar(50) NOT NULL,
  `arrivaltime` varchar(48) NOT NULL,
  `depttime` varchar(84) NOT NULL,
  PRIMARY KEY (`trainno`),
  KEY `sourcecid` (`sourcecid`),
  KEY `destcid` (`destcid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `traininfo`
--

INSERT INTO `traininfo` (`trainno`, `trainname`, `sourcecid`, `destcid`, `runningdays`, `status`, `arrivaltime`, `depttime`) VALUES
('15001', 'Lichchvi Express', 1, 6, 'mon,sun', 'available', '10:30 pm', '10:45 pm'),
('15002', 'patliputra express', 2, 5, 'tue,thur', 'regret', '8:15am', '8:25am');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `routes`
--
ALTER TABLE `routes`
  ADD CONSTRAINT `routes_ibfk_1` FOREIGN KEY (`rscid`) REFERENCES `city` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `routes_ibfk_2` FOREIGN KEY (`rdcid`) REFERENCES `city` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stations`
--
ALTER TABLE `stations`
  ADD CONSTRAINT `stations_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `routes` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stations_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `city` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `traininfo`
--
ALTER TABLE `traininfo`
  ADD CONSTRAINT `traininfo_ibfk_1` FOREIGN KEY (`sourcecid`) REFERENCES `city` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `traininfo_ibfk_2` FOREIGN KEY (`destcid`) REFERENCES `city` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
