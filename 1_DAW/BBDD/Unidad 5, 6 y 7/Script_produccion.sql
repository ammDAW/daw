Create database produccion;

use produccion;

CREATE TABLE IF NOT EXISTS producto(
    cod_prod VARCHAR(5) PRIMARY KEY,
    nombre_prod VARCHAR(20) NOT NULL,
    color_prod VARCHAR(20) NOT NULL,
    peso_prod DECIMAL(3,1) NOT NULL,
    ciudad_prod VARCHAR(30) NOT NULL
);
 
CREATE TABLE empresa(
    cod_emp VARCHAR(5) PRIMARY KEY,
    nombre_emp VARCHAR(20) NOT NULL,
    ciudad_emp VARCHAR(30) NOT NULL
);
 
CREATE TABLE fabricante(
    cod_fab VARCHAR(5) PRIMARY KEY,
    nombre_fab VARCHAR(20) NOT NULL,
    puntuacion_fab INTEGER(2) NOT NULL,
    ciudad_fab VARCHAR(30) NOT NULL
);
 
 
CREATE TABLE ENTREGA(
cod_fab VARCHAR(5),
    cod_prod VARCHAR(5) DEFAULT 'P1' ,
    cod_emp VARCHAR(5),
    cantidad INTEGER(4)  NOT NULL,
    CONSTRAINT ent_pk PRIMARY KEY(cod_fab, cod_prod,cod_emp) ,
    CONSTRAINT ent_cod_fab_fk FOREIGN KEY(cod_fab) REFERENCES fabricante(cod_fab) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ent_cod_prod_fk FOREIGN KEY(cod_prod) REFERENCES producto(cod_prod)  ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT ent_cod_emp_fk FOREIGN KEY(cod_emp) REFERENCES empresa(cod_emp) ON DELETE RESTRICT ON UPDATE CASCADE
);
   
INSERT INTO PRODUCTO VALUES
('P1', 'Clasificador','Rojo', 12,'Londres'),
('P2', 'Perforadora', 'Verde', 17, 'París'),
('P3', 'Lectora', 'Azul', 17, 'Roma');
 
INSERT INTO PRODUCTO VALUES
('P4', 'Consola','Rojo', 14,'Londres'),
('P5', 'Terminal', 'Azul', 12, 'París'),
('P6', 'cinta', 'Rojo', 19, 'Londres');
 
 
INSERT INTO EMPRESA VALUES
('E1', 'PC-COMP', 'París'),
('E2', 'HARDWARE,S.L.', 'París'),
('E3', 'SOFTTON', 'Atenas'),
('E4', 'DATATEST', 'Atenas'),
('E5', 'HARD-SOFT', 'Londres'),
('E6', 'CALIPSO-SOFT', 'Oslo'),
('E7', 'INFORSOFT', 'Londres');
 
INSERT INTO fabricante VALUES
('F1', 'Juan',20,  'Londres'),
('F2', 'Antonio',10,  'París'),
('F3', 'María',30,  'París'),
('F4', 'Susana',20,  'Londres'),
('F5', 'Felipe',30,  'Atenas');
 
INSERT INTO entrega VALUES
('F1', 'P1','E1',  200),
('F1', 'P1','E4',  700),
('F2', 'P3','E1',  800),
('F2', 'P3','E2',  200),
('F2', 'P3','E3',  100),
('F2', 'P3','E4',  100),
('F2', 'P3','E5',  500),
('F2', 'P3','E6',  300),
('F2', 'P3','E7',  500),
('F2', 'P5','E2',  150),
('F3', 'P3','E1',  125),
('F3', 'P4','E2',  200),
('F4', 'P6','E3',  200),
('F4', 'P6','E7',  300),
('F5', 'P2','E4',  8000),
('F5', 'P2','E2',  500),
('F5', 'P5','E5',  300),
('F5', 'P5','E7',  700),
('F5', 'P1','E4',  900),
('F5', 'P3','E4',  100),
('F5', 'P4','E4',  200);