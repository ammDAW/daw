
CREATE DATABASE banca;

USE banca;

CREATE TABLE cliente (
  codigo_cliente int(11) UNIQUE NOT NULL,
  dni VARCHAR(9) PRIMARY KEY,
  nombre VARCHAR(20) NOT NULL,
  apellido1 VARCHAR(20) NOT NULL,
  apellido2 VARCHAR(20) DEFAULT NULL,
  direccion VARCHAR(50) DEFAULT NULL 
);
INSERT INTO `cliente` VALUES (1,117,'Alberto','Hernandez',NULL,NULL), (2,100,'Antonio','Perez','Sánchez','C/del Pino'), (3,120,'Manuel','Perez','Sánchez','C/del Pino');

CREATE TABLE cuenta (
  tipo VARCHAR(1) NOT NULL,
  fecha_creacion date NOT NULL,
  saldo int(11) NOT NULL,
  cod_cuenta int(11) PRIMARY KEY
  );
INSERT INTO cuenta VALUES ('1','2010-01-11',2333,0),('1','2010-01-11',4000,1),('1','2010-01-11',6000,2),('1','2010-01-11',10700,3),('1','2010-11-03',11700,4),('1','2010-11-03',13000,5),('1','2013-11-03',13200,6),('1','2013-11-03',13000,7);

CREATE TABLE movimiento (
  fecha datetime NOT NULL,
  cantidad decimal(4,0) NOT NULL,
  dni VARCHAR(9) NOT NULL,
  cod_cuenta int(11) NOT NULL,
  id_movimiento int(11) PRIMARY KEY,
  CONSTRAINT cliente FOREIGN KEY (dni) REFERENCES cliente (dni) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT cuenta FOREIGN KEY (cod_cuenta) REFERENCES cuenta (cod_cuenta) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO movimiento VALUES ('2012-08-05 00:00:00','100',117,5,0),('2012-08-05 00:00:00','320',117,6,1),('2012-08-05 00:00:00','100',117,3,3),('2012-08-05 00:00:00','100',117,2,4),('2012-08-05 00:00:00','100',117,1,5),('2012-03-05 00:00:00','200',117,4,6);

CREATE TABLE tiene (
  dni VARCHAR(9) NOT NULL,
  cod_cuenta int(11) NOT NULL,
  PRIMARY KEY (dni,cod_cuenta),
  CONSTRAINT fk1_cliente FOREIGN KEY (dni) REFERENCES cliente (dni),
  CONSTRAINT fk2_cuenta FOREIGN KEY (cod_cuenta) REFERENCES cuenta (cod_cuenta)
) ;

INSERT INTO tiene VALUES (117, 1), (117, 2),(117, 3),(117, 4),(117, 5),(117, 6), (100, 0),(120, 7);



CREATE DATABASE  liga;

USE liga;


CREATE TABLE equipo (
  id_equipo int(11) NOT NULL,
  nombre varchar(45) NOT NULL,
  ciudad varchar(45) NOT NULL,
  web varchar(250) DEFAULT 'sin web oficial',
  puntos int(11) DEFAULT NULL,
  PRIMARY KEY (id_equipo),
  UNIQUE KEY nombre_UNIQUE (nombre)
) ;
INSERT INTO equipo VALUES (1,'Regal Barcelona','Barcelona','http://www.fcbarcelona.com/web/index_idiomes.html',10),(2,'Real Madrid','Madrid','http://www.realmadrid.com/cs/Satellite/es/1193040472450/SubhomeEquipo/Baloncesto.htm',9),(3,'P.E. Valencia','Valencia','http://www.valenciabasket.com/',11),(4,'Caja Laboral','Vitoria','http://www.baskonia.com/prehomes/prehomes.asp?id_prehome=69',22),(5,'Gran Canaria','Las Palmas','http://www.acb.com/club.php?id=CLA',14),(6,'CAI Zaragoza','Zaragoza','http://basketzaragoza.net/',23);

CREATE TABLE jugador (
  id_jugador int(11) NOT NULL,
  nombre varchar(45) DEFAULT NULL,
  apellido varchar(45) DEFAULT NULL,
  posicion varchar(45) DEFAULT NULL,
  id_capitan int(11) DEFAULT NULL,
  fecha_alta datetime DEFAULT NULL,
  salario int(11) DEFAULT NULL,
  equipo int(11) DEFAULT NULL,
  altura decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (id_jugador),
  CONSTRAINT fequipo FOREIGN KEY (equipo) REFERENCES equipo (id_equipo) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;
INSERT INTO jugador VALUES (1,'Juan Carlos','Navarro','escolta',1,'2010-01-10 00:00:00',130000,1,'1.96'),(2,'Felipe','Reyes','Pivot',2,'2009-02-20 00:00:00',132000,2,'2.04'),(3,'Victor','Claver','Alero',3,'2009-03-08 00:00:00',99000,3,'2.08'),(4,'Rafa ','Martinez','ala-pivot',4,'2010-11-11 00:00:00',51000,3,'1.91'),(5,'Fernando','San Emeterio','Alero',6,'2008-09-22 00:00:00',60000,4,'1.99'),(6,'Mirza','Teletovic','Pivot',6,'2010-05-13 00:00:00',77000,4,'2.06'),(7,'Sergio ','Llull','Escolta',2,'2011-10-29 00:00:00',100000,2,'1.90'),(8,'Victor ','Sada','Base',1,'2012-01-01 00:00:00',80000,1,'1.92'),(9,'Carlos','Suarez','Alero',2,'2011-02-19 00:00:00',66000,2,'2.03'),(10,'Xavi ','Rey','Pivot',14,'2008-10-12 00:00:00',104500,5,'2.09'),(11,'Carlos ','Cabezas','Base',13,'2012-01-21 00:00:00',105000,6,'1.86'),(12,'Pablo ','Aguilar','Alero',13,'2011-06-14 00:00:00',51700,6,'2.03'),(13,'Rafa','Hettsheimeir','Pivot',13,'2008-04-15 00:00:00',58300,6,'2.08'),(14,'Sitapha','Savané','Pivot',14,'2011-07-27 00:00:00',66000,5,'2.01'),(15,'anonimo','anonimo','Ala-pivot',2,'2012-01-01 00:00:00',4000,3,'2.00'),(22,'j1',NULL,NULL,NULL,NULL,NULL,2,'2.00'),(23,'j2',NULL,NULL,NULL,NULL,NULL,2,NULL);

CREATE TABLE partido (
  id_partido int(11) NOT NULL AUTO_INCREMENT,
  local int(11) NOT NULL,
  visitante int(11) NOT NULL,
  resultado varchar(45) DEFAULT NULL,
  fecha date DEFAULT NULL,
  arbitro varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_partido),
  CONSTRAINT flocal FOREIGN KEY (local) REFERENCES equipo (id_equipo) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fvisitante FOREIGN KEY (visitante) REFERENCES equipo (id_equipo) ON DELETE CASCADE ON UPDATE CASCADE
) ;
INSERT INTO partido VALUES (1,1,2,'100-100','2011-10-10','4\r'),(2,2,3,'90-91','2011-11-17','5\r'),(3,3,4,'88-77','2011-11-23','6\r'),(4,1,6,'66-78','2011-11-30','6\r'),(5,2,4,'90-90','2012-01-12','7\r'),(6,4,5,'79-83','2012-01-19','3\r'),(7,3,6,'91-88','2012-02-22','3\r'),(8,5,4,'90-66','2012-04-27','2\r'),(9,6,5,'110-70','2012-05-30','1'),(10,3,5,'88-77','2011-09-01','2');


