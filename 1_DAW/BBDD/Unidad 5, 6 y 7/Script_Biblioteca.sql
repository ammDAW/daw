CREATE DATABASE biblioteca;
USE biblioteca;

create table Libro
(
Id_Libro numeric,
primary key (Id_Libro),
Titulo varchar(100),
Editorial varchar(100),
Area varchar(100)
);

create table Autor
(
Id_Autor numeric,
primary key (Id_Autor),
Nombre varchar(100),
Nacionalidad varchar(100),
Edad integer
);

create table Estudiante
(
Id_Lector numeric,
primary key (Id_Lector),
Nombre varchar(100),
Apellido varchar(100),
Direccion varchar(100),
Carrera varchar(100),
Edad integer
);

create table LibAut
 (
 Id_Autor numeric,
 FOREIGN KEY (Id_Autor) REFERENCES Autor (Id_Autor),
 Id_Libro numeric,
 FOREIGN KEY (Id_Libro) REFERENCES Libro (Id_Libro), 
 PRIMARY KEY(Id_Autor, Id_Libro)
 );
 
 create table Prestamo
(
Id_Lector numeric,
FOREIGN KEY (Id_Lector) REFERENCES Estudiante (Id_Lector),
Id_Libro numeric,
FOREIGN KEY (Id_Libro) REFERENCES Libro (Id_Libro),
Fecha_Prestamo date,
Fecha_Devuelto date,
Devuelto date,
PRIMARY KEY (Id_Lector, Id_Libro, Fecha_Prestamo)
);

insert into LIbro values ('001','El Señor de las
Moscas','Marruecos','Novela'),
('002','El Esclavo','Porrua','Narracion'),
('003','El Señor de los Anillos','FCE','Internet'),
('004','Don Quijote de la Mancha','Grijalva','Narracion'), 
('005','visual Estudio Net','Alfay Omega','informatica'),
('006','Base de Datos','Alfay Omega','informatica'),
('007','Ingenieria de Software','Alfay Omega','informatica')
, ('008','Un Mexicano Mas','planeta','novela')
, ('009','Entregame tu corazon','Marruecos','Novela')
, ('010','Harry Potter','edicciones prado','Internet')
, ('011','Harry Potter:Las Reliquias de la Muerte','edicciones prado','Internet')
, ('012','Orgullo y Prejuicio','Marruecos','Novela')
, ('013','Romeo y Julienta','Marruecos','Novela')
, ('014','Navidad en las Montañas','Marruecos','Narracion')
, ('015','El Señor de los Anillos: Las Dos Torres','FCE','Internet');

insert into Autor values ('16','Juan Rufol','Mexico','45');
insert into Autor values ('17','Willian Golding','Alemania','50');
insert into Autor values ('18','Barbara Gostmich','Francia','33');
insert into Autor values ('19','Mario Benedetti','USA','47');
insert into Autor values ('20','Altamirano','Mexico','65');
insert into Autor values ('21','Jose Gonzalez','Italia','55');
insert into Autor values ('22','Ana laura Delgado','Mexico','48');
insert into Autor values ('23','Og Mandino','Usa','44');
insert into Autor values ('24','thomas Huxley','Japón','60');
insert into Autor values ('25','Leticia Lopez Juarez','Canada','58');
insert into Autor values ('26','Osar Palacios Ceballos','Mexico','45');
insert into Autor values ('27','Zamná Heredia','Portugal','62');
insert into Autor values ('28','maria Bernaldez ','Mexico','54');
insert into Autor values ('29','Jhon y Rita Lang','Italia','55');
insert into Autor values ('30','Rafael Camacho','Chile','62');

insert into Estudiante values ('31','Maria','crispin','noche triste','contabilidad','17');
insert into Estudiante values ('32','Jonathan','Garcia Lopez ','morelos no 7','alimentos','17');
insert into Estudiante values ('33','roberto','Sanchez Mejia','flor de azalia SN','agrobiotecnologia','20');
insert into Estudiante values ('34','Paola','Cervantes Castillo','Av. Zaragoza','contabilidad','18');
insert into Estudiante values ('35','mayra','Hernandez Sanchez','Allende No 3','alimentos','22');
insert into Estudiante values ('36','ivan','Trejo Aragon','Galeana No23','contabilidad','19');
insert into Estudiante values ('37','Alexander','Borregero Cerero','Guerrero No8','contabilidad','18');
insert into Estudiante values ('38','Erick', 'Diaz olalde','Puerta Norte No6','agrobiotecnologa','18');
insert into Estudiante values ('39','luis', 'Chaltel Gaspar','noche triste','paramedicos','19');
insert into Estudiante values ('40','Enrique', 'Aldama Leyte','ahuehuetes ','tic-si','22');
insert into Estudiante values ('41','raul', 'Valdez Alanes', 'noche triste No9','administrador','17');
insert into Estudiante values ('42','Sandra' , 'Guzman Agurre','Hidalgo No12','contabilidad','20');
insert into Estudiante values ('43','Maricruz','Crispin Claveria','Mariano Matamoros SN','contabilidad','19');
insert into Estudiante values ('44','Gabriel', ' Liberato Cuacuamoxtla','Cuauhtemoc','administracion','23');
insert into Estudiante values ('45','Marisol', 'Jimenez Jimenez','Los pinos No15','tic-si','20');

insert into LibAut values('16','001');
insert into LibAut values ('17','002');
insert into LibAut values ('18','003');
insert into LibAut values('19','004');
insert into LibAut values('20','005');
insert into LibAut values('21','006');
insert into LibAut values('22','007');
insert into LibAut values('23','008');
insert into LibAut values('24','009');
insert into LibAut values('25','010');
insert into LibAut values('26','011');
insert into LibAut values('27','012');
insert into LibAut values('28','013');
insert into LibAut values('29','014');
insert into LibAut values('30','015');

insert into Prestamo values ('31','001','2012/04/08','2012/04/10','2012/04/11');
insert into Prestamo values ('32','005','2012/04/08','2012/04/10', '2012/04/10');
insert into Prestamo values ('33','006','2012/04/08','2012/04/10', '2012/04/12');
insert into Prestamo values ('34','005','2012/05/07','2012/05/09','2012/05/10');
insert into Prestamo values ('35','004','2012/05/09','2012/05/11','2012/05/11');
insert into Prestamo values ('36','003','2012/05/25','2012/05/28','2012/05/28');
insert into Prestamo values ('37','001','2012/06/12','2012/06/14','2012/06/15');
insert into Prestamo values ('38','001','2012/06/13','2012/06/15','2012/06/15');
insert into Prestamo values ('39','006','2013/01/14','2013/01/16','2013/01/16');
insert into Prestamo values ('40','007','2013/02/16','2013/02/18','2013/02/18');
insert into Prestamo values ('41','008','2013/02/20','2013/02/22','2013/02/25');
insert into Prestamo values ('42','007','2013/03/11','2013/03/13','2013/03/13');
insert into Prestamo values ('43','010','2013/03/27','2013/03/29','2013/04/01');
insert into Prestamo values ('44','006','2013/04/08','2013/04/10', '2013/04/10');
insert into Prestamo values ('45','002','2013/04/08','2013/04/10', '2013/04/10');
