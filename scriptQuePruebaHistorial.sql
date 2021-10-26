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

insert into suscripcion (descripcion,precio,activo)
values ('suscripcion basica',100.0,true),
       ('suscripcion premium',300.0,true);

insert into usuario (nombre, apellido, email, password, especialidad_id, provincia_id, rol_id, activo)
values ('eric','cuevas','ecuevas@alumno.unlam.edu.ar','root',1,1,1, true);

insert into usuario (nombre, apellido, email, password, provincia_id, rol_id, activo)
values('lalo','landa','llanda@alumno.unlam.edu.ar','root',1,2, true);

INSERT INTO `db`.`prestacion` (`id`, `calificacionDadaPorElCliente`,`descripcion`, `estado`, `numerofactura`, `usuarioAsistente_id`, `usuarioSolicitante_id`)
VALUES ('1', 1,'hola', 'finalizado', '11111', '1', '2'),
       ('2',null ,'hola', 'activo', '22222', '1', '2'),
       ('3', null,'hola', 'activo', '33333', '1', '2'),
       ('4', 4,'hola', 'cancelado', '44444', '1', '2');

UPDATE `db`.`prestacion` SET `calificacionDadaPorElCliente` = '4' WHERE (`id` = '1');

select *
from usuario;

select *
from suscripcion;

select *
from prestacion;
