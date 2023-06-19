-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2023 at 09:55 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas_rpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `bhs_indo_ib`
--

CREATE TABLE `bhs_indo_ib` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bhs_indo_ib`
--

INSERT INTO `bhs_indo_ib` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL),
('Dewa', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bhs_indo_iiia`
--

CREATE TABLE `bhs_indo_iiia` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bhs_inggris_ia`
--

CREATE TABLE `bhs_inggris_ia` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bhs_inggris_ia`
--

INSERT INTO `bhs_inggris_ia` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Surya', NULL, NULL, NULL, NULL, NULL, NULL),
('Wahyu', NULL, NULL, NULL, NULL, NULL, NULL),
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL),
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bhs_inggris_iva`
--

CREATE TABLE `bhs_inggris_iva` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `daftar_mapel`
--

CREATE TABLE `daftar_mapel` (
  `nama_mapel` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftar_mapel`
--

INSERT INTO `daftar_mapel` (`nama_mapel`, `kelas`) VALUES
('matematika', 'ia'),
('pkn', 'ib'),
('ips', 'ib'),
('ipa', 'iia'),
('bhs_indo', 'iiia'),
('ipa', 'ia'),
('bhs_inggris', 'ia'),
('bhs_inggris', 'iva'),
('pjok', 'iiib'),
('matematika', 'ib'),
('bhs_indo', 'ib');

-- --------------------------------------------------------

--
-- Table structure for table `ipa_ia`
--

CREATE TABLE `ipa_ia` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ipa_ia`
--

INSERT INTO `ipa_ia` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Surya', 70, 80, 90, 80, 100, 90),
('Wahyu', NULL, NULL, NULL, NULL, NULL, NULL),
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL),
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `ipa_iia`
--

CREATE TABLE `ipa_iia` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ips_ib`
--

CREATE TABLE `ips_ib` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ips_ib`
--

INSERT INTO `ips_ib` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL),
('Dewa', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `matematika_ia`
--

CREATE TABLE `matematika_ia` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matematika_ia`
--

INSERT INTO `matematika_ia` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Surya', 60, 70, 80, 70, 70, 70),
('Wahyu', 60, 60, 70, 63.333333333333336, 50, 56.66666666666667),
('Bebas', 70, 80, 90, 80, 90, 85),
('Bebas', 70, 80, 90, 80, 90, 85);

-- --------------------------------------------------------

--
-- Table structure for table `matematika_ib`
--

CREATE TABLE `matematika_ib` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matematika_ib`
--

INSERT INTO `matematika_ib` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Bebas', 70, 80, 90, 80, 90, 85),
('Dewa', 70, 80, 90, 80, 90, 85);

-- --------------------------------------------------------

--
-- Table structure for table `pjok_iiib`
--

CREATE TABLE `pjok_iiib` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pjok_iiib`
--

INSERT INTO `pjok_iiib` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Purnomo', 90, 95, 93, 92.66666666666667, 89, 90.83333333333334),
('Bebas', 70, 80, 90, 80, 90, 85);

-- --------------------------------------------------------

--
-- Table structure for table `pkn_ib`
--

CREATE TABLE `pkn_ib` (
  `nama` varchar(40) DEFAULT NULL,
  `s1` int(11) DEFAULT NULL,
  `s2` int(11) DEFAULT NULL,
  `s3` int(11) DEFAULT NULL,
  `nas` double DEFAULT NULL,
  `sas` int(11) DEFAULT NULL,
  `rapor` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pkn_ib`
--

INSERT INTO `pkn_ib` (`nama`, `s1`, `s2`, `s3`, `nas`, `sas`, `rapor`) VALUES
('Bebas', NULL, NULL, NULL, NULL, NULL, NULL),
('Dewa', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `nama` varchar(40) NOT NULL,
  `kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`nama`, `kelas`) VALUES
('Surya', 'ia'),
('Wahyu', 'ia'),
('Purnomo', 'iiib'),
('Bebas', 'iiib'),
('Bebas', 'ia'),
('Bebas', 'ia'),
('Bebas', 'ib'),
('Dewa', 'ib');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
