-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 24 فبراير 2024 الساعة 15:15
-- إصدار الخادم: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `team2_net2_2023`
--

-- --------------------------------------------------------

--
-- بنية الجدول `conferencess`
--

CREATE TABLE `conferencess` (
  `id_conference` int(11) NOT NULL,
  `name_conference` varchar(50) NOT NULL,
  `conference_location` varchar(50) DEFAULT NULL,
  `conference_start_date` date DEFAULT NULL,
  `conference_photo` longblob DEFAULT NULL,
  `id_section` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `conferencess`
--

INSERT INTO `conferencess` (`id_conference`, `name_conference`, `conference_location`, `conference_start_date`, `conference_photo`, `id_section`) VALUES
(1, 'it', 'libya', '2024-02-23', NULL, 1),
(2, 'هندسة', NULL, NULL, NULL, 1),
(3, 'هندسة', NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `conference_objectives`
--

CREATE TABLE `conference_objectives` (
  `id_conference_objectives` int(11) NOT NULL,
  `conference_objectives` text DEFAULT NULL,
  `id_conference` int(11) NOT NULL,
  `volume` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `conference_objectives`
--

INSERT INTO `conference_objectives` (`id_conference_objectives`, `conference_objectives`, `id_conference`, `volume`) VALUES
(13, 'ة', 1, NULL),
(14, 'و', 3, NULL);

-- --------------------------------------------------------

--
-- بنية الجدول `conference_topics`
--

CREATE TABLE `conference_topics` (
  `id_conference_topics` int(11) NOT NULL,
  `conference_topics` text DEFAULT NULL,
  `id_conference` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `section`
--

CREATE TABLE `section` (
  `department_name` varchar(50) NOT NULL,
  `section_image` longblob DEFAULT NULL,
  `id_section` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `section`
--

INSERT INTO `section` (`department_name`, `section_image`, `id_section`) VALUES
('it', NULL, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `speaker`
--

CREATE TABLE `speaker` (
  `id_speaker` int(11) NOT NULL,
  `speaker_name` varchar(50) NOT NULL,
  `speaker_age` date DEFAULT NULL,
  `speaker_function` varchar(50) DEFAULT NULL,
  `speaker_email` varchar(50) DEFAULT NULL,
  `speaker_image` longblob DEFAULT NULL,
  `id_conference` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `frist_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_birty` date NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `conferencess`
--
ALTER TABLE `conferencess`
  ADD PRIMARY KEY (`id_conference`),
  ADD KEY `id_section` (`id_section`);

--
-- Indexes for table `conference_objectives`
--
ALTER TABLE `conference_objectives`
  ADD PRIMARY KEY (`id_conference_objectives`),
  ADD KEY `fk_conferenc` (`id_conference`);

--
-- Indexes for table `conference_topics`
--
ALTER TABLE `conference_topics`
  ADD PRIMARY KEY (`id_conference_topics`),
  ADD KEY `fk_conferencee` (`id_conference`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`id_section`);

--
-- Indexes for table `speaker`
--
ALTER TABLE `speaker`
  ADD PRIMARY KEY (`id_speaker`),
  ADD KEY `fk_conference` (`id_conference`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `conferencess`
--
ALTER TABLE `conferencess`
  MODIFY `id_conference` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `conference_objectives`
--
ALTER TABLE `conference_objectives`
  MODIFY `id_conference_objectives` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `conference_topics`
--
ALTER TABLE `conference_topics`
  MODIFY `id_conference_topics` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `section`
--
ALTER TABLE `section`
  MODIFY `id_section` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `speaker`
--
ALTER TABLE `speaker`
  MODIFY `id_speaker` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- قيود الجداول المُلقاة.
--

--
-- قيود الجداول `conferencess`
--
ALTER TABLE `conferencess`
  ADD CONSTRAINT `id_section` FOREIGN KEY (`id_section`) REFERENCES `section` (`id_section`) ON DELETE CASCADE;

--
-- قيود الجداول `conference_objectives`
--
ALTER TABLE `conference_objectives`
  ADD CONSTRAINT `fk_conferenc` FOREIGN KEY (`id_conference`) REFERENCES `conferencess` (`id_conference`) ON DELETE CASCADE;

--
-- قيود الجداول `conference_topics`
--
ALTER TABLE `conference_topics`
  ADD CONSTRAINT `fk_conferencee` FOREIGN KEY (`id_conference`) REFERENCES `conferencess` (`id_conference`) ON DELETE CASCADE;

--
-- قيود الجداول `speaker`
--
ALTER TABLE `speaker`
  ADD CONSTRAINT `fk_conference` FOREIGN KEY (`id_conference`) REFERENCES `conferencess` (`id_conference`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
