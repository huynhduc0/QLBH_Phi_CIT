-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2018 at 06:28 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qlbh`
--

-- --------------------------------------------------------

--
-- Table structure for table `qlbh`
--

CREATE TABLE IF NOT EXISTS `qlbh` (
  `MaSP` int(50) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `HangSX` varchar(50) NOT NULL,
  `GiaNhap` int(50) NOT NULL,
  `GiaBan` int(50) NOT NULL,
  `TonKho` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qlbh`
--

INSERT INTO `qlbh` (`MaSP`, `TenSP`, `HangSX`, `GiaNhap`, `GiaBan`, `TonKho`) VALUES
(1, 'Nokia 12801', 'Apple', 200000, 500000, 98),
(2, 'qqqq', 'Apple', 1231, 12121, 11),
(3, 'qqqq', 'HTC', 333, 3333, 33),
(7, 'qqqq', 'HTC', 333, 3333, 33);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `qlbh`
--
ALTER TABLE `qlbh`
 ADD PRIMARY KEY (`MaSP`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
