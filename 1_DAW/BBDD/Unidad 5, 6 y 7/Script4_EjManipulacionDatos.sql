use instituto;
alter table centros add primary key (cod_centro);

update profesores 
set dni=11223344
where apellidos like 'Rivera Silvestre, Ana';

alter table profesores add primary key (dni);

update personal
set dni=11223344
where apellidos like 'Rivera Silvestre, Ana';

alter table personal add primary key(dni);