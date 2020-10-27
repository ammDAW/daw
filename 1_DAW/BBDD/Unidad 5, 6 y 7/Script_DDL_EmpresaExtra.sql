USE EMPRESA;

DROP TABLE clientes;
CREATE TABLE clientes (
  CLI_NO numeric(3) primary key , 
  NOMBRE varchar(25) default NULL,
  LOCALIDAD varchar(14)  default NULL,
  VEN_NO numeric(4) default NULL,
  DEBE numeric(8) default NULL,
  HABER numeric(8) default NULL,
  LIMITE_CREDITO numeric(8) default NULL
) ;


INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(101, 'DISTRIBUCIONES GOMEZ', 'MADRID', 7499, 0, 0, 50000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(102, 'LOGITRONICA S.L', 'BARCELONA', 7654, 0, 0, 50000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(103, 'INDUSTRIAS LACTEAS S.A.', 'LAS ROZAS', 7844, 0, 0, 100000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(104, 'TALLERES ESTESO S.A.', 'SEVILLA', 7654, 0, 0, 50000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(105, 'EDICIONES SANZ', 'BARCELONA', 7499, 0, 0, 30000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(106, 'SIGNOLOGIC S.A.', 'MADRID', 7654, 0, 0, 50000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(107, 'MARTIN Y ASOCIADOS S.L.', 'VALENCIA', 7844, 0, 0, 100000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(108, 'MANUFACTURAS ALI S.A.', 'SEVILLA', 7654, 0, 0, 30000);
INSERT INTO clientes (CLI_NO, NOMBRE, LOCALIDAD, VEN_NO, DEBE, HABER, LIMITE_CREDITO) VALUES
(109, 'AUTOMECANICA MARIN', 'SEVILLA', 7844, 0, 0, 80000);



DROP TABLE pedidos;
CREATE TABLE pedidos (
  PED_NO numeric(4) primary key ,
  PROD_NO numeric(3) default NULL,
  CLI_NO numeric(4) default NULL,
  UNIDADES numeric(4) default 1,
  FECHA_PEDIDO date default NULL
) ;


INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1000, 20, 103, 3, '2006-10-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1001, 50, 106, 2, '2006-10-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1002, 10, 101, 4, '2006-10-07');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1003, 20, 105, 4, '2006-10-16');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1004, 40, 106, 8, '2006-10-17');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1005, 30, 105, 2, '2006-10-20');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1006, 70, 103, 3, '2006-11-03');

INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1007, 50, 101, 2, '2006-11-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1008, 10, 106, 6, '2006-11-16');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1009, 20, 105, 2, '2006-11-26');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1010, 40, 102, 3, '2006-12-08');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1011, 30, 106, 2, '2006-12-05');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1012, 10, 105, 3, '2006-12-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1013, 30, 106, 2, '2006-12-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1014, 20, 101, 4, '2007-01-07');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1015, 70, 105, 4, '2007-01-16');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1016, 30, 106, 7, '2007-01-17');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1017, 20, 105, 6, '2007-01-20');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1018, 20, 106, 6, '2007-01-22');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1019, 30, 105, 2, '2008-01-26');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1020, 50, 102, 3, '2008-02-08');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1021, 60, 106, 2, '2008-02-15');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1022, 10, 106, 3, '2008-03-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1023, 30, 106, 2, '2008-03-06');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1024, 20, 102, 5, '2008-03-07');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1025, 70, 105, 3, '2008-03-16');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1026, 20, 106, 7, '2008-03-18');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1027, 10, 105, 1, '2008-03-20');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1028, 10, 106, 6, '2008-04-20');
INSERT INTO pedidos (PED_NO, PROD_NO, CLI_NO, UNIDADES, FECHA_PEDIDO) VALUES
(1029, 20, 105, 5, '2008-04-28');


DROP TABLE productos;
CREATE TABLE productos (
  PROD_NO numeric(3) default NULL,
  DESCRIPCION varchar(30) default NULL,
  PRECIO  numeric(8) default NULL,
  STOCK numeric(3) default NULL
) ;



INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(10, 'MESA DESPACHO MOD. GAVIOTA', 550, 50);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(20, 'SILLA DIRECTOR MOD. BUFALO', 270, 25);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(30, 'ARMARIO NOGAL DOS PUERTAS', 460, 20);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(40, 'MESA MODELO UNIÓN', 340, 15);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(50, 'ARCHIVADOR CEREZO', 1050, 20);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(60, 'CAJA SEGURIDAD MOD B222', 2800, 15);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(70, 'DESTRUCTORA DE PAPEL A3', 150, 25);
INSERT INTO productos (PROD_NO, DESCRIPCION, PRECIO, STOCK) VALUES
(80, 'MODULO ORDENADOR MOD. ERGOS', 250, 25);
