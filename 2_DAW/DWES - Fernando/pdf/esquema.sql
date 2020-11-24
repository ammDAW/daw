DROP TABLE IF EXISTS `pdf_facturas`;
DROP TABLE IF EXISTS `pdf_lineas_factura`;

CREATE TABLE `pdf_facturas` (
  `FACTURA_ID` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `EMPRESA_NIF` varchar(10) NOT NULL,
  `EMPRESA_NOMBRE` varchar(10) NOT NULL,
  `EMPRESA_DIRECCION` varchar(50) NOT NULL,
  `EMPRESA_CP` varchar(50) NOT NULL,
  `EMPRESA_LOCALIDAD` varchar(50) NOT NULL,
  `CLIENTE_NIF` varchar(10) NOT NULL,
  `CLIENTE_NOMBRE` varchar(10) NOT NULL,
  `CLIENTE_DIRECCION` varchar(50) NOT NULL,
  `CLIENTE_CP` varchar(50) NOT NULL,
  `CLIENTE_LOCALIDAD` varchar(50) NOT NULL,
  `TOTAL` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `pdf_facturas`
  ADD PRIMARY KEY (`FACTURA_ID`);

INSERT INTO `pdf_facturas` (`FACTURA_ID`, `FECHA`, `EMPRESA_NIF`, `EMPRESA_NOMBRE`, `EMPRESA_DIRECCION`, `EMPRESA_CP`, `EMPRESA_LOCALIDAD`, `CLIENTE_NIF`, `CLIENTE_NOMBRE`, `CLIENTE_DIRECCION`, `CLIENTE_CP`, `CLIENTE_LOCALIDAD`, `TOTAL`) VALUES
(1, '2016-12-05', '22222222K', 'SOLCON SL', 'C. LA PAZ, 17', '20000', 'MURCIA', '33333333L', 'SOLCON SL', 'AV LA PARRA, 78', '20000', 'ALCANTARILLA', 1000);

CREATE TABLE `pdf_lineas_factura` (
  `LINEA_FACTURA_ID` int(11) NOT NULL,
  `FACTURA_ID` int(11) DEFAULT NULL,
  `CONCEPTO_ID` int(11) NOT NULL,
  `CONCEPTO` varchar(50) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `PVP` float DEFAULT NULL,
  `IMPORTE` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `pdf_lineas_factura`
  ADD PRIMARY KEY (`LINEA_FACTURA_ID`),
  ADD KEY `FACTURA_ID` (`FACTURA_ID`);

INSERT INTO `pdf_lineas_factura` (`LINEA_FACTURA_ID`, `FACTURA_ID`, `CONCEPTO_ID`, `CONCEPTO`, `CANTIDAD`, `PVP`, `IMPORTE`) VALUES
(1, 1, 245, 'ANTENA GRID', 2, 200, 400);

INSERT INTO `pdf_lineas_factura` (`LINEA_FACTURA_ID`, `FACTURA_ID`, `CONCEPTO_ID`, `CONCEPTO`, `CANTIDAD`, `PVP`, `IMPORTE`) VALUES
(2, 1, 245, 'ROUTER', 2, 200, 400);