
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
      
/*insert into motivodenuncia (id ,descripcion)
values (1,'El Asistente nunca se presentó.'),
       (2,'El Asistente me agredió verbalmente.'),
       (3,'El Asistente me agredió físicamente'),
       (4,'El Asistente me cobró un extra'),
       (5,'El Asistente no se correspondía con el registrado en la App'),
       (6,'Otro motivo...');       
 
insert into historialdenuncia (id ,comentario)
values (1, 'El Asistente me agredió físicamente'),
       (2, 'El Asistente me agredió físicamente'),
       (3, 'El Asistente nunca se presentó.');*/
       
insert into suscripcion (descripcion,precio,activo)
values ('suscripcion basica',100.0,true),
       ('suscripcion premium',300.0,true);
       


insert into usuario (nombre, apellido, email, password, especialidad_id, provincia_id, rol_id, activo)
values ('eric','cuevas','ecuevas@alumno.unlam.edu.ar','root',1,1,1, true);

insert into usuario (nombre, apellido, email, password, provincia_id, rol_id, activo)
values('lalo','landa','llanda@alumno.unlam.edu.ar','root',1,2, true);

INSERT INTO `db`.`prestacion` (`id`, `calificacionDadaPorElCliente`,`calificacionDadaPorUsuarioAsistente`,`descripcion`, `estado`, `numerofactura`, `usuarioAsistente_id`, `usuarioSolicitante_id`)
VALUES ('1', 1,3,'hola', 'finalizado', '11111', '1', '2'),
       ('2',null ,3,'hola', 'activo', '22222', '1', '2'),
       ('3', null,3,'hola', 'activo', '33333', '1', '2'),
       ('4', 4,5,'hola', 'cancelado', '44444', '1', '2'),
       ('5', null,5,'hola', 'finalizado', '55555', '1', '2'),
       ('6', null,2,'hola', 'cancelado', '66666', '1', '2');

/*insert into denuncia (descripcion ,motivo,prestacion_id,usuarioDenunciante_id, usuarioDenunciado_id)
values ('hola','sarasa',1,2,1),
       ('hola2','sarasa',2,2,1),
       ('hola3','sarasa',3,2,1);*/
insert into estadoFactura (estado)
values('pagado'),
      ('impago');


select * from usuario;






/*
select * from prestacion;
select* from factura;
SELECT * FROM factura
WHERE usuarioQuePaga_id =2
ORDER BY fecha(NAME_FIELD, "DD/MM/YY") DESC;

select * from factura order by fecha desc limit 1
*/