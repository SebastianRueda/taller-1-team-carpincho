
use db;

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
      
insert into motivodenuncia (descripcion)
values ('El Asistente nunca se presentó.'),
       ('El Asistente me agredió verbalmente.'),
       ('El Asistente me agredió físicamente'),
       ('El Asistente me cobró un extra'),
       ('El Asistente no se correspondía con el registrado en la App'),
       ('Otro motivo...');       
       
insert into suscripcion (descripcion,precio,activo)
values ('suscripcion basica',100.0,true),
       ('suscripcion premium',300.0,true);

insert into especialidad (descripcion, suscripcion_id)
values ('grua', 1),
       ('policia',1),
       ('medico', 1),
       ('mecanico', 2),
       ('abogado', 2),
       ('gomeria movil', 2),
       ('chofer', 2);

insert into usuario (nombre, apellido, email, password, especialidad_id, provincia_id, rol_id, activo)
values ('eric','cuevas','ecuevas@alumno.unlam.edu.ar','root',1,1,1, true),
		('Cristian','Ramirez','CRamirez@gmail.com','root',3,3,2, true),
	   ('Juan Peréz','Gonzalez','jpg@edu.ar','root',2,2,1, true);


insert into usuario (nombre, apellido, email, password, provincia_id, rol_id, activo)
values('lalo','landa','llanda@alumno.unlam.edu.ar','root',1,2, true);

INSERT INTO `db`.`prestacion` (`id`, `calificacionDadaPorElCliente`,`calificacionDadaPorUsuarioAsistente`,`descripcion`, `estado`, `numerofactura`, `usuarioAsistente_id`, `usuarioSolicitante_id`)
VALUES ('1', 1,3,'hola', 'finalizado', '11111', '1', '2'),
       ('2',null ,3,'hola', 'activo', '22222', '1', '2'),
       ('3', null,3,'hola', 'activo', '33333', '1', '2'),
       ('4', 4,5,'hola', 'cancelado', '44444', '1', '2'),
       ('5', null,5,'hola', 'finalizado', '55555', '1', '2'),
       ('6', null,2,'hola', 'cancelado', '66666', '1', '2');

insert into estadoFactura (estado)
values('pagado'),
      ('impago');

select * from especialidad;