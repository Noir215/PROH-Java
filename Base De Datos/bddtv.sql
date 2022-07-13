-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2022 a las 21:11:58
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bddtv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `codigo_pedido` int(11) NOT NULL,
  `codigo_producto` int(11) NOT NULL,
  `unidades` int(11) DEFAULT NULL,
  `precio_unitario` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`codigo_pedido`, `codigo_producto`, `unidades`, `precio_unitario`) VALUES
(1, 3, 2, '59.99'),
(42, 1, 3, '29.99'),
(42, 2, 2, '19.99'),
(49, 1, 1, '29.99'),
(50, 1, 2, '29.99'),
(50, 2, 3, '19.99'),
(51, 2, 1, '19.99'),
(51, 3, 2, '59.99'),
(51, 4, 3, '39.99'),
(52, 7, 1, '19.99'),
(52, 8, 3, '19.99');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `codigo` int(11) NOT NULL,
  `persona` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `importe` decimal(8,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `pago` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `poblacion` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `provincia` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `domicilio` varchar(32) COLLATE utf8mb4_bin NOT NULL,
  `destinatario` varchar(32) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`codigo`, `persona`, `fecha`, `importe`, `estado`, `pago`, `poblacion`, `provincia`, `domicilio`, `destinatario`) VALUES
(1, 3, '2022-04-30', '60.99', 2, 'transferencia', '', '', '', ''),
(7, 1, '2022-12-12', '200.99', 2, 'tarjeta', '', '', '', ''),
(8, 1, '2022-12-12', '200.99', 2, 'tarjeta', '', '', '', ''),
(9, 1, '2022-12-12', '200.99', 2, 'transferencia', '', '', '', ''),
(41, 1, '2022-06-24', '129.95', 1, 'tarjeta', 'Valencia', 'Valencia', 'Calle', 'Angel'),
(42, 1, '2022-06-24', '129.95', 2, 'tarjeta', 'Valencia', 'Valencia', 'Calle', 'Angel'),
(49, 1, '2022-06-24', '29.99', 2, 'tarjeta', 'Valencia', 'Valencia', 'Calle', 'Angel'),
(50, 1, '2022-06-25', '119.95', 0, 'transferencia', 'Valencia', 'Valencia', 'Calle', 'David'),
(51, 1, '2022-06-26', '259.94', 0, 'transferencia', 'Valencia', 'Valencia', 'Calle Juan de Garay', 'Guillermo'),
(52, 1, '2022-06-27', '79.96', 0, 'tarjeta', 'Valencia', 'Valencia', 'Calle', 'Angel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `precio` decimal(8,2) DEFAULT NULL,
  `existencias` int(11) DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `descripcion`, `precio`, `existencias`, `imagen`) VALUES
(1, 'Moonlighter', '19.99', 2, '../img/Bloodborne.png'),
(2, 'Bloodborne', '59.99', 100, '../img/Bloodborne.png'),
(3, 'Elden Ring', '59.99', 400, '../img/EldenRing.png'),
(4, 'Death Stranding', '39.99', 100, '../img/Bloodborne.png'),
(7, 'Hades', '19.99', 100, '../img/EldenRing.png'),
(8, 'Dark Souls 2', '19.99', 50, '../img/DiscoElysium.png'),
(9, 'Disco Elysium', '12.65', 10, '../img/DiscoElysium.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `codigo` int(11) NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  `usuario` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `clave` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `nombre` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `apellidos` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `domicilio` varchar(128) COLLATE utf8mb4_bin DEFAULT NULL,
  `poblacion` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL,
  `provincia` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL,
  `cp` char(5) COLLATE utf8mb4_bin DEFAULT NULL,
  `telefono` char(9) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo`, `activo`, `admin`, `usuario`, `clave`, `nombre`, `apellidos`, `domicilio`, `poblacion`, `provincia`, `cp`, `telefono`) VALUES
(1, 1, 1, 'lifthrasir', 'clave', 'Angel', 'Dolz', 'Calle', 'Valencia', 'Valencia', '46009', '691478110'),
(2, 1, 0, 'Vermillion', 'clave_clave', 'Miguel', 'Dolz González', 'Calle Juan de Garay', 'Valencia', 'Valencia', '46007', '691478111'),
(3, 1, 0, 's_carbonell', 'clave_123', 'Susana', 'Carbonell', 'Calle Recogidas', 'Granada', 'Granada', '58002', '691478112'),
(4, 0, 0, 'hermanos215', 'clave123', 'Antonio', 'Carola', 'Calle de la piruleta', 'Cadiz', 'Mordor', '40158', '691478114'),
(16, 1, 0, 'DavidR', '1234', 'David', 'Ramirez', 'Calle de la felicidad', 'Madrid', 'Madrid', '45678', '987654321'),
(17, 1, 0, 'Davkram', '12345', 'David', 'Pacheco', 'Calle de Ramon', 'Cataluña', 'Barcelona', '25847', '69154789');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`codigo_pedido`,`codigo_producto`),
  ADD KEY `codigo_producto` (`codigo_producto`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `persona` (`persona`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`codigo_pedido`) REFERENCES `pedidos` (`codigo`),
  ADD CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo`);

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`persona`) REFERENCES `usuarios` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
