CREATE TABLE personas(
    codigo int not null AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(255) not null,
    apellidos varchar(255)
);

CREATE TABLE cliente(
    codigo int not null AUTO_INCREMENT PRIMARY KEY,
    nombre_emp varchar(255) not null,
    telefono int not null
);