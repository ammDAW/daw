INSERT INTO `asignatura` (`id`, `asignatura`) VALUES
(1, 'PROGRAMACION'),
(2, 'ENTORNOS'),
(3, 'SISTEMAS'),
(4, 'BASES DE DATOS'),
(5, 'SERVIDOR'),
(6, 'CLIENTE');

INSERT INTO `alumno` (`id`, `nombre`, `apellidos`, `curso_id`) VALUES
(1, 'GUILLERMO', 'LOPEZ ALEGRIA', 1),
(2, 'PABLO ', 'GARCIA PEREZ', 1),
(3, 'ADRIANA', 'BELMONTE LOPEZ', 1),
(4, 'VICENTE', 'SANCHEZ SANCHEZ', 1),
(5, 'JUAN ', 'LOPEZ GARCIA', 2),
(6, 'ANTONIO', 'LUJAN MENOR', 2);

INSERT INTO `curso` (`id`, `curso`) VALUES
(1, '1DAW'),
(2, '2DAW');

INSERT INTO `calificacion` (`id`, `alumno_id`, `asignatura_id`, `evaluacion1`, `evaluacion2`, `evaluacion3`, `calificacion`) VALUES
(1, 1, 1, 1, 4, 5, 0),
(3, 2, 1, 4, 5, 6, NULL),
(4, 3, 1, 6, 7, 8, NULL),
(5, 4, 1, 9, 10, 0, NULL),
(6, 1, 2, NULL, NULL, NULL, NULL),
(7, 2, 2, NULL, NULL, NULL, NULL),
(8, 3, 2, NULL, NULL, NULL, NULL),
(9, 4, 2, NULL, NULL, NULL, NULL),
(10, 1, 3, NULL, NULL, NULL, NULL),
(11, 2, 3, NULL, NULL, NULL, NULL),
(12, 3, 3, NULL, NULL, NULL, NULL),
(13, 4, 3, NULL, NULL, NULL, NULL),
(14, 1, 4, NULL, NULL, NULL, NULL),
(15, 2, 4, NULL, NULL, NULL, NULL),
(16, 3, 4, NULL, NULL, NULL, NULL),
(17, 4, 4, NULL, NULL, NULL, NULL),
(18, 6, 5, NULL, NULL, NULL, NULL),
(19, 6, 6, 0, 0, 0, NULL),
(20, 5, 6, NULL, 0, 0, NULL),
(21, 5, 5, NULL, NULL, NULL, NULL);