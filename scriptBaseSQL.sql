use db;
insert into especialidad (descripcion)
values ('grua'),
       ('mecanico'),
       ('medico'),
       ('gestor'),
       ('abogado'),
       ('gomeria movil'),
       ('chofer');

insert into provincia (nombre)
values ('CABA'),
       ('Buenos Aires'),
       ('Tierra Del Fuego'),
       ('Santa Cruz'),
       ('Chubut'),
       ('Rio Negro'),
       ('Mendoza'),
       ('Neuquen'),
       ('La Pampa'),
       ('Cordoba'),
       ('Santa Fe'),
       ('Jujuy'),
       ('Salta'),
       ('Misiones'),
       ('Corrientes'),
       ('Catamarca'),
       ('Entre Rios'),
       ('San Juan'),
       ('San Luis'),
       ('Formosa'),
       ('Chaco'),
       ('Santiago Del Estero'),
       ('Tucuman'),
       ('La Rioja');

insert into rol (descripcion)
values('prestador'),
      ('cliente final');

insert into usuario (nombre, apellido, email, password, especialidad_id, provincia_id, rol_id, activo)
values('eric','cuevas','ecuevas@alumno.unlam.edu.ar','root',1,1,1, true);

/* usuario que no tiene una especialidad, es decir usuario final*/
insert into usuario (nombre, apellido, email, password, provincia_id, rol_id, activo)
values('emiliano','leandro;','emiliano@alumno.unlam.edu.ar','root',1,2, true);


insert into suscripcion (descripcion,precio,activo)
values ('suscripcion basica',100.0,true),
       ('suscripcion premium',300.0,true);

