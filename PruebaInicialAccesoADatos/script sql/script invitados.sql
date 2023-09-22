CREATE DATABASE IF NOT EXISTS invitados;

USE invitados;

CREATE TABLE invitados (
  dni VARCHAR(255) PRIMARY KEY NOT NULL,
  apellidosVARCHAR(255) NOT NULL,
  nombre VARCHAR(255) NOT NULL,
  centro_educativo VARCHAR(255),
  edad INT
);

INSERT INTO invitados (dni, apellidos, nombre, centro_educativo, edad)
VALUES (12121212A, 'Gomez Perez', 'Pepito', 'Ilerna', '21');
INSERT INTO invitados (dni, apellidos, nombre, centro_educativo, edad)
VALUES (34343434B, 'Hernandez Garcia', 'Menganito', 'US', '22');
INSERT INTO invitados (dni, apellidos, nombre, centro_educativo, edad)
VALUES (56565656C, 'Fernandez Alvarez', 'Menganita', 'Erasmus', '23');

COMMIT;