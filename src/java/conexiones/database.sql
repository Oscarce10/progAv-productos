-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-09-2019 a las 16:51:56
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_tallerjavaweb`
--
CREATE DATABASE IF NOT EXISTS `producto` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;

USE producto;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `valor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `cantidad`, `valor`) VALUES
(1, 'Cafe', 'Cafe suave, granulado en tarro', 10, 11000),
(2, 'azucar', 'azucar refinada con vitamina d', 20, 1000),
(3, 'pan integral', 'pan integral sin conservantes', 25, 500),
(4, 'leche entera', 'leche entera bolsa', 10, 1500),
(5, 'vasos', 'vasos de plastico color azul', 12, 50),
(6, 'vino', 'vino de manzana', 5, 12500),
(7, 'arroz', 'arroz integral', 10, 2500);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;


create table administrador(
  id int auto_increment,
  nombre varchar(30),
  apellido varchar(30),
  correo varchar(50) not null,
  clave varchar(150) not null,
  salt varchar(20),
  primary key(id)
  );

CREATE TABLE cliente(
  id int NOT null auto_increment,
  nit varchar(30) not null,
  razon_social varchar(70),
  nombre_rl varchar(30),
  apellido_rl varchar(30),
  num_doc_rl varchar(30),
  telefono varchar(8),
  celular varchar(10),
  correo varchar(30),
  salt varchar(20),
  direccion varchar(30),
  descripcion varchar(30),
  tipo_persona char(1),
  primary key(id)
);      


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;