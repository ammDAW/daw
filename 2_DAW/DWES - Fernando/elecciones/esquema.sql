DROP TABLE IF EXISTS `elecciones_votos` ;
DROP TABLE IF EXISTS `elecciones_mesas` ;
DROP TABLE IF EXISTS `elecciones_delegados` ;
DROP TABLE IF EXISTS `elecciones_sindicatos`;

CREATE TABLE IF NOT EXISTS `elecciones_mesas` (
  `mesa_id` INT NOT NULL,
  `centro` VARCHAR(255) NOT NULL, 
  `localidad` VARCHAR(255) NOT NULL,
  `blancos` INT,
  `nulos` INT,
  `activa` tinyint DEFAULT 0,
  PRIMARY KEY (`mesa_id`)
);

CREATE TABLE IF NOT EXISTS `elecciones_sindicatos` (
  `sindicato_id` INT NOT NULL,
  `sindicato` VARCHAR(255) NOT NULL, 
  `logo` VARCHAR(255) NOT NULL,
  `votos_real` INT NOT NULL DEFAULT 0,
  `votos_virtual` INT NOT NULL DEFAULT 0,
  `delegados_real` INT,
  `delegados_virtual` INT,
  PRIMARY KEY (`sindicato_id`)
);

CREATE TABLE IF NOT EXISTS `elecciones_votos` (
  `mesa_id` INT NOT NULL,
  `sindicato_id` INT NOT NULL,
  `votos` FLOAT NOT NULL DEFAULT 0,
  PRIMARY KEY (`mesa_id` ,`sindicato_id` ),
  CONSTRAINT `fk_elecciones_votos_has_elecciones_sindicatos`
    FOREIGN KEY (`sindicato_id`)
    REFERENCES `elecciones_sindicatos` (`sindicato_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_elecciones_votos_has_elecciones_mesa`
    FOREIGN KEY (`mesa_id`)
    REFERENCES `elecciones_mesas` (`mesa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
	
CREATE TABLE IF NOT EXISTS `elecciones_mesas` (
  `mesa_id` INT NOT NULL,
  `centro` VARCHAR(255) NOT NULL, 
  `localidad` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`mesa_id`)
);

INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual`  ) VALUES ('1', 'ANPE', 'anpe.png', '0', '0'  );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('2', 'CCOO', 'ccoo.png', '0' , '0' );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('3', 'UGT', 'ugt.png', '0', '0'  );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual`  ) VALUES ('4', 'STERM', 'sterm.jpg', '0', '0'  );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('5', 'SIDI', 'sidi.jpg', '0' , '0' );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('6', 'SIDEMUR', 'sidemur.jpg', '0', '0'  );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('7', 'SPIDO', 'spido.jpg', '0', '0'  );
INSERT INTO elecciones_sindicatos (`sindicato_id`, `sindicato`, `logo`, `delegados_real`, `delegados_virtual` ) VALUES ('8', 'CSIF', 'csif.jpg', '0', '0'  );

INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (1,'  IES VILLA DE ABARAN ',' ABARAN',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (2,'  IES EUROPA ',' AGUILAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (3,'  IES REY CARLOS III ',' AGUILAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (4,'  CEIP NTRA SRA DE LA ASUNCION ',' ALCANTARILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (5,'  IES FRANCISCO SALZILLO ',' ALCANTARILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (6,'  IES ALCÁNTARA ',' ALCANTARILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (7,'  IES ANTONIO MENARGUEZ COSTA ',' ALCAZARES(LOS)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (8,'  IES MIGUEL HERNANDEZ ',' ALHAMA DE MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (9,'  IES  ',' LIBRILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (10,'  CEIP MIGUEL MEDINA ',' ARCHENA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (11,'  CEIP RIO SEGURA ',' BENIEL',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (12,'  IES VALLE DEL SEGURA ',' BLANCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (13,'  CEIP ARTERO ',' BULLAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (14,'  IES EMILIO PEREZ PIÑERO ',' CALASPARRA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (15,'  CEIP VIRGEN DE LA CANDELARIA ',' BARRANDA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (16,'  IES GINES PEREZ CHIRINOS ',' CARAVACA DE LA CRUZ',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (17,'  IES PEDRO PEÑALVER ',' ALGAR(EL)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (18,'  IES LOS MOLINOS ',' BARRIO DE PERAL',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (19,'  IES ISAAC PERAL ',' CARTAGENA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (20,'  IES BEN ARABI ',' CARTAGENA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (21,'  IES JIMENEZ DE LA ESPADA ',' CARTAGENA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (22,'  IES JUAN SEBASTIAN ELCANO ',' CARTAGENA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (23,'  CEIP VICENTE MEDINA ',' DOLORES(LOS)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (24,'  CEIP SANTA FLORENTINA ',' PALMA(LA)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (25,'  CEIP SAN ANTONIO ABAD ',' SAN ANTONIO ABAD',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (26,'  CEIP NTRA SRA DEL MAR ',' SANTA LUCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (27,'  IES ALQUIPIR ',' CEHEGIN',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (28,'  CEIP NTRA SRA DEL CARMEN ',' ALGUAZAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (29,'  IES FELIPE DE BORBON ',' CEUTI',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (30,'  IES ROMANO GARCIA ',' LORQUI',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (31,'  IES DIEGO TORTOSA ',' CIEZA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (32,'  CEIP DON JOSÉ MARÍN ',' CIEZA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (33,'  CEIP VICENTE ALEIXANDRE ',' FORTUNA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (34,'  CEIP DIONISIO BUENO ',' ABANILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (35,'  IES RICARDO ORTEGA ',' FUENTE ALAMO',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (36,'  IES INFANTA ELENA ',' JUMILLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (37,'  IES JOSÉ IBAÑEZ MARTIN ',' LORCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (38,'  IES SAN JUAN BOSCO ',' LORCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (39,'  IES PRINCIPE DE ASTURIAS ',' LORCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (40,'  IES RAMON ARCAS MECA ',' LORCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (41,'  CEIP SAN FERNANDO ',' LORCA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (42,'  CEIP PETRA GONZALEZ ',' PACA(LA)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (43,'  CEIP FRANCISCO CAPARROS ',' MAZARRON',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (44,'  IES D ANTONIO HELLIN COSTA ',' PUERTO DE MAZARRON',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (45,'  CEIP SAGRADO CORAZON ',' MOLINA DE SEGURA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (46,'  CEIP NTRA SRA DE FATIMA ',' MOLINA DE SEGURA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (47,'  CEIP NTRA SRA DE LA CONSOLACION ',' MOLINA DE SEGURA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (48,'  CEIP JUANA RODRIGUEZ ',' MORATALLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (49,'  CEIP ANITA ARNAO ',' MULA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (50,'  CEIP PASCUAL MARTINEZ ABELLAN ',' PLIEGO',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (51,'  CEIP FRANCISCO NOGUERA ',' SAN JOSE DE LA VEGA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (52,'  CEIP NTRA SRA DE LAS LAGRIMAS ',' CABEZO DE TORRES',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (53,'  CEIP NTRA SRA DE LA ANTIGUA ',' MONTEAGUDO',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (54,'  IES JOSE PLANES ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (55,'  EST ADMI CONSEJERÍA DE EDUCACIÓN Y CULTURA ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (56,'  MUS  CONS PROFESIONAL DE DANZA ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (57,'  IES EL CARMEN ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (58,'  IES MARIANO BAQUERO GOYANES ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (59,'  IES FLORIDABLANCA ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (60,'  IES INFANTE DJUAN MANUEL ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (61,'  IES JUAN CARLOS I ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (62,'  IES RAMON Y CAJAL ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (63,'  CEIP SAN ANDRES ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (64,' IES MIGEL DE CERVANTES ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (65,'  EAR ESCUELA DE ARTE Y SUPERIOR DE DISEÑO ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (66,'  IES LA FLOTA ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (67,'  CEIP NTRA SRA DE CORTES ',' NONDUERMAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (69,'  IES  ',' ALQUERIAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (68,'  IES MARQUES DE LOS VELEZ ',' PALMAR(EL) O LUGAR DE DON JUAN',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (70,'  CEIP JUAN CARLOS I ',' LLANO DE BRUJAS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (71,'  IES ALJADA ',' PUENTE TOCINOS',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (72,'  CEIP NICOLAS RAYA ',' SANGONERA LA VERDE',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (73,'  IES ALQUIBLA ',' ALBERCA DE LAS TORRES',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (74,'  IES INGENIERO DE LA CIERVA ',' MURCIA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (75,'  CEIP SAAVEDRA FAJARDO ',' ALGEZARES',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (76,'  CEIP SAGRADO CORAZON ',' PUERTO',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (77,'  CEIP LA PAZ ',' SAN JAVIER',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (78,'  IES MAR MENOR ',' SAN JAVIER',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (79,'  CEIP LOS ANTOLINOS ',' SAN PEDRO DEL PINATAR',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (80,'  CEIP NUMERO 2 ','RICARDO CAMPILLO',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (81,'  IES SABINA MORA ',' ROLDAN',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (82,'  CEIP FONTES ',' TORRE',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (83,'  CEIP SAN JOSÉ ',' TORRES DE COTILLAS (LAS)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (84,'  CEIP LA CRUZ ',' TOTANA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (85,'  CEIP SANTIAGO ',' TOTANA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (86,'  CEIP ALFONSO X EL SABIO ',' UNION(LA)',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (87,'  IES JOSE LCASTILLO PUCHE ',' YECLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (88,'  CEIP LAS HERRATILLAS ',' YECLA',0,0);
INSERT INTO elecciones_mesas (`mesa_id`, `centro`, `localidad`, blancos, nulos) VALUES (89,'  CEIP MEDITERRANEO ',' MANGA DEL MAR MENOR(LA)',0,0);

INSERT INTO  elecciones_votos ( mesa_id, sindicato_id ) select mesa_id, sindicato_id from elecciones_mesas, elecciones_sindicatos;