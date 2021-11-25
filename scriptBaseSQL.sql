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

/*insert into denuncia (id, descripcion)
values (1,'El Asistente nunca se presentó.'),
       (2,'El Asistente me agredió verbalmente.'),
       (3,'El Asistente me agredió físicamente'),
       (4,'El Asistente me cobró un extra'),
       (5,'El Asistente no se correspondía con el registrado en la App');*/
       
insert into motivodenuncia (descripcion)
values ('El Asistente nunca se presentó.'),
       ('El Asistente me agredió verbalmente.'),
       ('El Asistente me agredió físicamente'),
       ('El Asistente me cobró un extra'),
       ('El Asistente no se correspondía con el registrado en la App');       
    

insert into rol (descripcion)
values('prestador'),
      ('cliente final');

insert into usuario (nombre, apellido, email, password, especialidad_id, provincia_id, rol_id, activo)
values('eric','cuevas','ecuevas@alumno.unlam.edu.ar','root',1,1,1, true),
	('nicolas','marmirolli','nmarmirolli@alumno.unlam.edu.ar','root',2,1,1, true),
	('emilio','rojas','erojas@alumno.unlam.edu.ar','root',1,1,1, true),
    ('elsa','romero','eromero@alumno.unlam.edu.ar','root',1,1,1, true),
    ('geronimo','rodriguez','grodriguez@alumno.unlam.edu.ar','root',2,1,1, true),
    ('anna','gianna','agianna@alumno.unlam.edu.ar','root',2,1,1, true),
    ('alan','recalde','arecalde@alumno.unlam.edu.ar','root',2,1,1, true),
    ('matias','tolosa','mtolosa@alumno.unlam.edu.ar','root',3,1,1, true),
    ('nahuel','juncosa','njuncosa@alumno.unlam.edu.ar','root',3,1,1, true),
    ('nicolas','gomez','ngomez@alumno.unlam.edu.ar','root',3,1,1, true),
    ('lalo','landa','llanda@alumno.unlam.edu.ar','root',4,1,1, true),
    ('lito','perez','lperez@alumno.unlam.edu.ar','root',4,1,1, true),
    ('hernan','cuevas','hcuevas@alumno.unlam.edu.ar','root',4,1,1, true),
    ('rocio','moran','rocio@alumno.unlam.edu.ar','root',5,1,1, true),
	('andrea','galvan','andrea@alumno.unlam.edu.ar','root',6,1,1, true),
	('silvana','urquiza;','silvana@alumno.unlam.edu.ar','root',7,1,1, true);


/* usuario que no tiene una especialidad, es decir usuario final*/
insert into usuario (nombre, apellido, email, password, provincia_id, rol_id, activo)
values('emiliano','leandro;','emiliano@alumno.unlam.edu.ar','root',1,2, true);


insert into suscripcion (descripcion,precio,activo)
values ('suscripcion basica',100.0,true),
       ('suscripcion premium',300.0,true);


