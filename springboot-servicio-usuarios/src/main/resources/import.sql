INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES( 'elon', '12345', 1, 'Elon','musk', 'elon@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES( 'jeff', '12345', 1, 'jef','bezos', 'jef@gmail.com');

INSERT INTO `roles` (nombre) VALUES('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES(1,1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES(2,2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES(2,1);
