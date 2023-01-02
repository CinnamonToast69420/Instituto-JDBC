-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2022 a las 16:54:17
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instituto`
--
CREATE DATABASE IF NOT EXISTS `instituto` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `instituto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `id_alumno` int(4) NOT NULL,
  `nombre` varchar(90) NOT NULL,
  `fecha_nac` date NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nia` int(8) NOT NULL,
  `aula` int(4) NOT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `nota` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id_alumno`, `nombre`, `fecha_nac`, `dni`, `nia`, `aula`, `telefono`, `email`, `nota`) VALUES
(1, 'Carlos Martinez Lopez', '1997-04-14', '67679434T', 56574458, 1, '658934025', 'carlos345@gmail.com', 4.5),
(2, 'Luis Gonzalez gomez', '1999-05-19', '84594502J', 59930123, 1, '667451295', 'luisCar75@gmail.com', 8.4),
(3, 'Juan Costa Martinez', '2002-12-01', '67586923G', 52367892, 1, '657329021', 'jnCosMart@gmail.com', 6.7),
(4, 'Roberto Kalogeropoúlou Beltrán', '2001-07-21', '83929835L', 51903245, 1, '659434902', 'kalosRob07_1@gmail.com', 9.3),
(5, 'Sofía Tarazona Pérez', '2000-09-24', '73432389F', 50945032, 1, '658934023', 'tar_sofia@gmail.com', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `idAula` int(4) NOT NULL,
  `nombre` varchar(10) DEFAULT NULL,
  `centro` varchar(50) DEFAULT NULL,
  `localidad` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`idAula`, `nombre`, `centro`, `localidad`) VALUES
(1, 'C.0.7', 'IES EDUARDO PRIMO MARQUES', 'CARLET');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD UNIQUE KEY `id_alumno_uq` (`id_alumno`),
  ADD KEY `aula_alumno` (`aula`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD UNIQUE KEY `id_aula_uq` (`idAula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `id_alumno` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `aula`
--
ALTER TABLE `aula`
  MODIFY `idAula` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `aula_alumno` FOREIGN KEY (`aula`) REFERENCES `aula` (`idAula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
