DROP TABLE IF EXISTS `tenis_partido` ;
DROP TABLE IF EXISTS `tenis_torneo` ;

CREATE TABLE IF NOT EXISTS `tenis_torneo` (
  `id_torneo` INT NOT NULL,
  `nombre` VARCHAR(55) NOT NULL, 
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`id_torneo`)
);

CREATE TABLE IF NOT EXISTS `tenis_partido` (
  `id_partido` INT NOT NULL,
  `jugador1` VARCHAR(55) NOT NULL, 
  `jugador2` VARCHAR(55) NOT NULL,
  `resultado` VARCHAR(55) NOT NULL,
  `id_torneo` INT NOT NULL,
  `tipo_partido` VARCHAR(55) NOT NULL,
  PRIMARY KEY (`id_partido`)
);

INSERT INTO `tenis_torneo` (`id_torneo`, `nombre`, `fecha`) VALUES ('1', 'Miami', '2020-08-11');
INSERT INTO `tenis_torneo` (`id_torneo`, `nombre`, `fecha`) VALUES ('2', 'Paris', '2020-12-15');

INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('1', 'Nadal', 'Federer', '6-0 6-0 6-0', '1', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('2', 'Gasquet', 'Wawrinka', '6-1 6-4 7-6', '1', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('3', 'Ferrero', 'Nisikory', '0-6 3-6 7-6', '1', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('4', 'Moya', 'Monfils', '6-1 6-4 7-6', '1', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('5', 'Nadal', 'Gasquet', '6-4 4-6 6-4', '1', 'semifinal');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('6', 'Nisikory', 'Moya', '6-0 6-0 6-0', '1', 'semifinal');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('7', 'Nadal', 'Nisikory', '6-2 6-2 6-1', '1', 'final');

INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('8', 'Federer', 'Moya', '6-0 6-0 6-0', '2', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('9', 'Ferrero', 'Gasquet', '3-6 6-7 6-7', '2', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('10', 'Nisikory', 'Monfils', '0-6 6-3 3-6', '2', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('11', 'Wawrinka', 'Nadal', '2-6 2-6 2-6', '2', 'cuartos');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('12', 'Federer', 'Gasquet', '6-0 6-0 6-0', '2', 'semifinal');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('13', 'Monfils', 'Nadal', '1-6 1-6 1-6', '2', 'semifinal');
INSERT INTO `tenis_partido` (`id_partido`, `jugador1`, `jugador2`, `resultado`, `id_torneo`, `tipo_partido`) VALUES ('14', 'Federer', 'Nadal', '6-7 7-6 6-7', '2', 'final');