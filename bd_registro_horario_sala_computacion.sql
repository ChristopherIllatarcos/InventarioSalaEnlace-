CREATE DATABASE IF NOT EXISTS bd_registro_horario_sala_computacion;
USE bd_registro_horario_sala_computacion;

CREATE TABLE tb_usuario(
id_usuario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
usuario VARCHAR(20) NOT NULL,
contrasena VARCHAR(15) NOT NULL,
estado VARCHAR(10) NOT NULL
);

INSERT INTO tb_usuario (usuario, contrasena, estado)
VALUES ('admin', SHA2('admin', 256), 'activo');

ALTER TABLE tb_usuario MODIFY COLUMN contrasena VARCHAR(64);

SELECT * FROM tb_usuario;


CREATE TABLE tb_funcionario(
id_funcionario INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
cargo VARCHAR(100) NOT NULL,
especialidad VARCHAR(50) NOT NULL,
curso VARCHAR(50) NOT NULL,
hora_entrada DATETIME,
hora_salida DATETIME NULL,
estado VARCHAR(50) DEFAULT 'Ingreso'
);

CREATE TABLE tb_prestramo(
id_prestamo INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
curso VARCHAR(50) NOT NULL,
hora_entrega DATETIME,
hora_devolucion DATETIME NULL,
estado VARCHAR(50) DEFAULT 'Prestado'
);

RENAME TABLE tb_prestramo TO tb_prestamo;


SELECT * FROM tb_prestamo;


SELECT * FROM tb_funcionario;

UPDATE tb_funcionario
SET estado  = 'Egresado'   
WHERE id_funcionario = 1;

DELETE FROM tb_funcionario
WHERE id_funcionario = 11;

