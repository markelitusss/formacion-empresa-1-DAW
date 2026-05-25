-- Formación Empresa --------------------------
-- Script carga BD ----------------------------
-- Markel Canales Ramos 1º DAW ----------------
-- --------------------------------------------

-- Tabla propietario

INSERT INTO propietario VALUES 
    (NULL, '56714429T', 'José Francisco Martínez', 'josefran56@gmail.com', '698100234'),
    (NULL, '48110152C', 'Manuela Jiménez', 'majimenez30@gmail.com', '658377190'),
    (NULL, '81766244L', 'Alberto Fernández', 'al.fernandez@gmail.com', '645120781'),
    (NULL, '32566608R', 'José María García', 'josema.gar4@gmail.com', '662134004'),
    (NULL, '67755834H', 'Lucía Ramírez', 'lucia.ramirez67@gmail.com', NULL);

-- Tabla tipos de viviendas
INSERT INTO tipo_vivienda VALUES
    (NULL, 'Apartamento'),
    (NULL, 'Atico'),
    (NULL, 'Casa');

-- Tabla viviendas
INSERT INTO vivienda VALUES
    ('AAA-01', 1, 'Calle San Pascual 56 3ºB', 800, 70, 'Piso para alquilar en Calle San Pascual, Torrevieja', 1, 1),
    ('AAA-02', 2, 'Calle Orihuela 80', 600, 56, 'Ático en Torrevieja con servicios cercanos', 2, 0),
    ('AAB-01', 3, 'Calle Ramon Gallud 23 1ºC', 950, 78, 'Piso céntrico en Torrevieja, disponible para alquiler y compra', 1, 1),
    ('AAA-03', 4, 'Calle Bilbao 9 3ºD', 625, 61, 'Alquiler de piso disponible en Torrevieja, contacta con el propietario para más información', 1, 0),
    ('AAC-01', 5, 'Calle Escorpiones 17', 1200, 140, 'Vivienda en alquiler cerca de Orihuela Costa', 3, 1);

-- Tabla inquilino
INSERT INTO inquilino VALUES
    (NULL, '19154776B', 'Juan José Plaza', 'juanjo.plaza@gmail.com', '722142331', 1),
    (NULL, '43890966Y', 'María López', 'marilopez116@gmail.com', '643553816', 0),
    (NULL, '78199022W', 'Carlos Romero', NULL, '642134721', 0),
    (NULL, '66233098L', 'Victoria Carrillo', 'vic.carrillo0@gmail.com', '722869010', 1),
    (NULL, '32566954S', 'Alejandro Gómez', 'al.gomezzz@gmail.com', '620900659', 1);

INSERT INTO tipo_estado VALUES
    (NULL, 'Pendiente'),
    (NULL, 'Activo'),
    (NULL, 'Vencido');

INSERT INTO contrata VALUES
    (1, 'AAA-01', '2026-05-01', '2026-12-31', 800, 2),
    (2, 'AAA-03', '2026-04-01', '2026-08-01', 625, 2),
    (3, 'AAA-02', NULL, NULL, 600, 1),
    (4, 'AAC-01', NULL, NULL, 1200, 1),
    (5, 'AAB-01', '2026-06-01', '2026-09-01', 950, 1);