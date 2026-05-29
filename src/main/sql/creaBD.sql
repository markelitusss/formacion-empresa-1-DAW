-- Formación Empresa --------------------------
-- Script creación BD -------------------------
-- Markel Canales Ramos 1º DAW ----------------
-- --------------------------------------------

-- Definición BD
DROP DATABASE IF EXISTS alquiler_viviendas;
CREATE DATABASE alquiler_viviendas;
USE alquiler_viviendas;

-- Tabla propietario
CREATE TABLE propietario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(50),
    CONSTRAINT uk_dni_propietario UNIQUE(DNI)
);

-- Tabla tipo
CREATE TABLE tipo_vivienda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50)
);

-- Tabla vivienda
CREATE TABLE vivienda (
    codigo VARCHAR(50) PRIMARY KEY,
    id_propietario INT,
    direccion VARCHAR(100),
    precio DECIMAL(7, 2),
    superficie INT,
    descripcion VARCHAR(500),
    tipo INT,
    acepta_mascota BOOL,
    CONSTRAINT fk_vivienda_propietario FOREIGN KEY(id_propietario) REFERENCES propietario(id),
    CONSTRAINT fk_vivianda_tipo FOREIGN KEY(tipo) REFERENCES tipo_vivienda(id)
);

-- Tabla inquilino
CREATE TABLE inquilino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(10) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(50),
    mascota BOOL,
    CONSTRAINT uk_dni_inquilino UNIQUE(DNI)
);

CREATE TABLE tipo_estado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estado VARCHAR(50)
)

-- Tabla contrata
CREATE TABLE contrata (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_inquilino INT,
    codigo_vivienda VARCHAR(50),
    fecha_inicio DATE,
    fecha_fin DATE,
    precio DECIMAL(7, 2),
    estado INT,
    CONSTRAINT fk_contrata_estado FOREIGN KEY(estado) REFERENCES tipo_estado(id),
    CONSTRAINT fk_contrata_inquilino FOREIGN KEY(id_inquilino) REFERENCES inquilino(id),
    CONSTRAINT fk_contrata_vivienda FOREIGN KEY(codigo_vivienda) REFERENCES vivienda(codigo)
);

-- Creación usuario
DROP USER usuario@'%';
CREATE USER usuario@'%' IDENTIFIED BY 'user1234';
GRANT INSERT, DELETE, UPDATE, SELECT ON alquiler_viviendas.* TO usuario@'%';
GRANT EXECUTE ON alquiler_viviendas.* TO usuario@'%';