-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2017 at 07:55 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rkm1`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `data_mahasiswa` (
`KodeTraining` int(11) NOT NULL,
  `Angkatan` varchar(5) NOT NULL,
  `JenisKelamin` varchar(15) NOT NULL,
  `IPK` varchar(3) NOT NULL,
  `NilaiIKH413` varchar(3) NOT NULL,
  `NilaiIKL435` varchar(3) NOT NULL,
  `NilaiIUM462` varchar(3) NOT NULL,
  `Konsentrasi` varchar(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_mahasiswa`
--

INSERT INTO `data_mahasiswa` (`KodeTraining`, `Angkatan`, `JenisKelamin`, `IPK`, `NilaiIKH413`, `NilaiIKL435`, `NilaiIUM462`, `Konsentrasi`) VALUES
(1, '2010', 'Perempuan', 'I01', 'N03', 'N01', 'N01', 'K01'),
(2, '2013', 'Perempuan', 'I02', 'N02', 'N01', 'N01', 'K01'),
(3, '2011', 'Laki-laki', 'I01', 'N01', 'N03', 'N02', 'K01'),
(4, '2014', 'Perempuan', 'I01', 'N01', 'N01', 'N01', 'K01'),
(5, '2010', 'Laki-laki', 'I03', 'N04', 'N04', 'N04', 'K02'),
(6, '2012', 'Perempuan', 'I01', 'N03', 'N03', 'N02', 'K02'),
(7, '2014', 'Laki-laki', 'I04', 'N04', 'N03', 'N04', 'K02'),
(8, '2011', 'Laki-laki', 'I03', 'N04', 'N04', 'N02', 'K03'),
(9, '2013', 'Laki-laki', 'I02', 'N02', 'N01', 'N02', 'K03'),
(10, '2012', 'Perempuan', 'I01', 'N01', 'N01', 'N02', 'K03');

-- --------------------------------------------------------

--
-- Table structure for table `data_uji`
--

CREATE TABLE IF NOT EXISTS `data_uji` (
`KodeUji` int(11) NOT NULL,
  `Angkatan` varchar(5) NOT NULL,
  `JenisKelamin` varchar(15) NOT NULL,
  `IPK` varchar(3) NOT NULL,
  `NilaiIKH413` varchar(3) NOT NULL,
  `NilaiIKL435` varchar(3) NOT NULL,
  `NilaiIUM462` varchar(3) NOT NULL,
  `Konsentrasi` varchar(3) NOT NULL,
  `Hasil` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_uji`
--

INSERT INTO `data_uji` (`KodeUji`, `Angkatan`, `JenisKelamin`, `IPK`, `NilaiIKH413`, `NilaiIKL435`, `NilaiIUM462`, `Konsentrasi`, `Hasil`) VALUES
(41, '2013', 'Perempuan', 'I01', 'N03', 'N01', 'N02', 'K01', 'K01'),
(42, '2014', 'Laki-laki', 'I02', 'N02', 'N02', 'N01', 'K03', 'K01');

-- --------------------------------------------------------

--
-- Table structure for table `ket_ipk`
--

CREATE TABLE IF NOT EXISTS `ket_ipk` (
  `IDIPK` varchar(3) NOT NULL,
  `KetIPK` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ket_ipk`
--

INSERT INTO `ket_ipk` (`IDIPK`, `KetIPK`) VALUES
('I01', 'Sangat Baik'),
('I02', 'Baik'),
('I03', 'Cukup'),
('I04', 'Tidak Baik');

-- --------------------------------------------------------

--
-- Table structure for table `ket_konsentrasi`
--

CREATE TABLE IF NOT EXISTS `ket_konsentrasi` (
  `IDKonsentrasi` varchar(3) NOT NULL,
  `KetKonsentrasi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ket_konsentrasi`
--

INSERT INTO `ket_konsentrasi` (`IDKonsentrasi`, `KetKonsentrasi`) VALUES
('K01', 'Rekayasa Perangkat Lunak'),
('K02', 'Grafika Komputer'),
('K03', 'Keamanan Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `ket_nilai`
--

CREATE TABLE IF NOT EXISTS `ket_nilai` (
  `IDNilai` varchar(3) NOT NULL,
  `KetNilai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ket_nilai`
--

INSERT INTO `ket_nilai` (`IDNilai`, `KetNilai`) VALUES
('N01', 'Sangat Baik'),
('N02', 'Baik'),
('N03', 'Cukup'),
('N04', 'Tidak Baik');

-- --------------------------------------------------------

--
-- Table structure for table `temp_hasil`
--

CREATE TABLE IF NOT EXISTS `temp_hasil` (
  `konsentrasi` varchar(3) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_hasil`
--

INSERT INTO `temp_hasil` (`konsentrasi`, `nilai`) VALUES
('K01', 0.00010986328125),
('K02', 0.000024479596086665),
('K03', 0.00011015818238999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_mahasiswa`
--
ALTER TABLE `data_mahasiswa`
 ADD PRIMARY KEY (`KodeTraining`);

--
-- Indexes for table `data_uji`
--
ALTER TABLE `data_uji`
 ADD PRIMARY KEY (`KodeUji`);

--
-- Indexes for table `ket_ipk`
--
ALTER TABLE `ket_ipk`
 ADD PRIMARY KEY (`IDIPK`);

--
-- Indexes for table `ket_konsentrasi`
--
ALTER TABLE `ket_konsentrasi`
 ADD PRIMARY KEY (`IDKonsentrasi`);

--
-- Indexes for table `ket_nilai`
--
ALTER TABLE `ket_nilai`
 ADD PRIMARY KEY (`IDNilai`);

--
-- Indexes for table `temp_hasil`
--
ALTER TABLE `temp_hasil`
 ADD PRIMARY KEY (`konsentrasi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_mahasiswa`
--
ALTER TABLE `data_mahasiswa`
MODIFY `KodeTraining` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `data_uji`
--
ALTER TABLE `data_uji`
MODIFY `KodeUji` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=43;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
