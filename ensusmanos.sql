-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-05-2020 a las 05:24:38
-- Versión del servidor: 5.5.20
-- Versión de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ensusmanos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE IF NOT EXISTS `eventos` (
  `Id_eventos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_eventos` varchar(70) NOT NULL,
  `descripcion_eventos` varchar(100) NOT NULL,
  `fecha_eventos` varchar(10) NOT NULL,
  `hora_eventos` varchar(10) NOT NULL,
  `Id_usuarios_eventos` int(11) NOT NULL,
  PRIMARY KEY (`Id_eventos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=212 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos`
--

CREATE TABLE IF NOT EXISTS `puntos` (
  `Id_puntos` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_puntos` varchar(100) NOT NULL,
  `Id_usuarios_puntos` int(11) NOT NULL,
  `Id_eventos_puntos` int(11) NOT NULL,
  PRIMARY KEY (`Id_puntos`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id_usuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuarios` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_usuarios` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `barrio_usuarios` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `usu_usuario` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pass_usuarios` varchar(70) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`Id_usuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=115 ;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
