-- Formación Empresa --------------------------
-- Procedimientos almacenados BD --------------
-- Markel Canales Ramos 1º DAW ----------------
-- --------------------------------------------

-- CÓDIGOS ERROR ------------------------------
-- 0. Sin errores
-- -1. Error genérico
-- -2. El ID/codigo solicitado no existe
-- -3. La clave ajena no existe en la tabla de origen

-- Operaciones CRUD propietario
DELIMITER //
DROP PROCEDURE sp_get_propietario //
CREATE PROCEDURE sp_get_propietario(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento utiliza una sentencia SELECT 
    -- simple para obtener todos los datos de un propietario

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM propietario) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SELECT * FROM propietario WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_ins_propietario //
CREATE PROCEDURE sp_ins_propietario(
    IN p_DNI VARCHAR(10),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(50),
    OUT p_id INT,
    OUT p_err INT
)
BEGIN
    -- el procedimiento utiliza SQL dinámico para introducir los valores
    -- del nuevo registro en la tabla
    -- además obtiene el ID del último registro insertado

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    SET @declaracion = 'INSERT INTO propietario VALUES (NULL, ?, ?, ?, ?)';
    PREPARE prepared_stmt FROM @declaracion;

    SET @DNI = p_DNI;
    SET @nombre = p_nombre;
    SET @email = p_email;
    SET @telefono = p_telefono;

    EXECUTE prepared_stmt USING @DNI, @nombre, @email, @telefono;
    SET p_id = LAST_INSERT_ID();

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_upd_propietario //
CREATE PROCEDURE sp_upd_propietario(
    IN p_id INT,
    IN p_DNI VARCHAR(10),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(50),
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dińamico para ejecutar
    -- una sentencia de actualización.
    -- basándonos en el ID del propietario actualizamos todos sus datos.
    
    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM propietario) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SET @declaracion = 'UPDATE propietario SET DNI = ?, nombre = ?, email = ?, telefono = ? WHERE id = ?';
    PREPARE prepared_stmt FROM @declaracion;

    SET @id = p_id;
    SET @DNI = p_DNI;
    SET @nombre = p_nombre;
    SET @email = p_email;
    SET @telefono = p_telefono;

    EXECUTE prepared_stmt USING @DNI, @nombre, @email, @telefono, @id;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_del_propietario //
CREATE PROCEDURE sp_del_propietario(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento elimina de la tabla propietario el registro con el ID indicado

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM propietario) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    DELETE FROM propietario WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;

-- Operaciones CRUD vivienda
DELIMITER //
DROP PROCEDURE sp_get_vivienda //
CREATE PROCEDURE sp_get_vivienda(IN p_codigo VARCHAR(50), OUT p_err INT)
sp: BEGIN
    -- el procedimiento utiliza una sentencia SELECT 
    -- simple para obtener todos los datos de una vivienda

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el codigo solicitado
    IF p_codigo NOT IN (SELECT codigo FROM vivienda) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SELECT * FROM vivienda WHERE codigo = p_codigo;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_ins_vivienda //
CREATE PROCEDURE sp_ins_vivienda(
    IN p_codigo VARCHAR(50),
    IN p_id_propietario INT,
    IN p_direccion VARCHAR(100),
    IN p_precio DECIMAL(7, 2),
    IN p_superficie INT,
    IN p_descripcion VARCHAR(500),
    IN p_tipo VARCHAR(50),
    IN p_acepta_mascota BOOL,
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dinámico para introducir los valores
    -- del nuevo registro en la tabla

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- si el propietario no existe 
    IF p_id_propietario NOT IN (SELECT id FROM propietario) THEN
        SET p_err = -3;
        LEAVE sp;
    END IF;

    SET @declaracion = 'INSERT INTO vivienda VALUES (?, ?, ?, ?, ?, ?, ?, ?)';
    PREPARE prepared_stmt FROM @declaracion;

    SET @codigo = p_codigo;
    SET @id_propietario = p_id_propietario;
    SET @direccion = p_direccion;
    SET @precio = p_precio;
    SET @superficie = p_superficie;
    SET @descripcion = p_descripcion;
    SET @tipo = (SELECT id FROM tipo_vivienda WHERE tipo = p_tipo);
    SET @acepta_mascota = p_acepta_mascota;

    EXECUTE prepared_stmt USING @codigo, @id_propietario, @direccion, @precio, @superficie, @descripcion, @tipo, @acepta_mascota;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_upd_vivienda //
CREATE PROCEDURE sp_upd_vivienda(
    IN p_codigo VARCHAR(50),
    IN p_id_propietario INT,
    IN p_direccion VARCHAR(100),
    IN p_precio DECIMAL(7, 2),
    IN p_superficie INT,
    IN p_descripcion VARCHAR(500),
    IN p_tipo VARCHAR(50),
    IN p_acepta_mascota BOOL,
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dińamico para ejecutar
    -- una sentencia de actualización.
    -- basándonos en el código de la vivienda actualizamos todos sus datos.
    
    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el codigo solicitado
    IF p_codigo NOT IN (SELECT codigo FROM vivienda) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    -- si el propietario no existe 
    IF p_id_propietario NOT IN (SELECT id_propietario FROM vivienda) THEN
        SET p_err = -3;
        LEAVE sp;
    END IF;

    SET @declaracion = 'UPDATE vivienda SET codigo = ?, id_propietario = ?, direccion = ?, precio = ?, superficie = ?, descripcion = ?, tipo = ?, acepta_mascota = ? WHERE codigo = ?';
    PREPARE prepared_stmt FROM @declaracion;

    SET @codigo = p_codigo;
    SET @id_propietario = p_id_propietario;
    SET @direccion = p_direccion;
    SET @precio = p_precio;
    SET @superficie = p_superficie;
    SET @descripcion = p_descripcion;
    SET @tipo = (SELECT id FROM tipo_vivienda WHERE tipo = p_tipo);
    SET @acepta_mascota = p_acepta_mascota;

    EXECUTE prepared_stmt USING @codigo, @id_propietario, @direccion, @precio, @superficie, @descripcion, @tipo, @acepta_mascota, @codigo;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_del_vivienda //
CREATE PROCEDURE sp_del_vivienda(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento elimina de la tabla propietario el registro con el ID indicado

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_codigo NOT IN (SELECT codigo FROM vivienda) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    DELETE FROM vivienda WHERE codigo = p_codigo;
    SET p_err = 0;
END //
DELIMITER ;

-- Operaciones CRUD inquilino
DELIMITER //
DROP PROCEDURE sp_get_inquilino //
CREATE PROCEDURE sp_get_inquilino(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento utiliza una sentencia SELECT 
    -- simple para obtener todos los datos de un inquilino

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = --1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM inquilino) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SELECT * FROM inquilino WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_ins_inquilino //
CREATE PROCEDURE sp_ins_inquilino(
    IN p_DNI VARCHAR(10),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(50),
    IN p_mascota BOOL,
    OUT p_id INT,
    OUT p_err INT
)
BEGIN
    -- el procedimiento utiliza SQL dinámico para introducir los valores
    -- del nuevo registro en la tabla
    -- además obtiene el ID del último registro insertado

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    SET @declaracion = 'INSERT INTO inquilino VALUES (NULL, ?, ?, ?, ?, ?)';
    PREPARE prepared_stmt FROM @declaracion;

    SET @DNI = p_DNI;
    SET @nombre = p_nombre;
    SET @email = p_email;
    SET @telefono = p_telefono;
    SET @mascota = p_mascota;

    EXECUTE prepared_stmt USING @DNI, @nombre, @email, @telefono, @mascota;
    SET p_id = LAST_INSERT_ID();

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_upd_inquilino //
CREATE PROCEDURE sp_upd_inquilino(
    IN p_id INT,
    IN p_DNI VARCHAR(10),
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_telefono VARCHAR(50),
    IN p_mascota BOOL,
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dińamico para ejecutar
    -- una sentencia de actualización.
    -- basándonos en el ID del inquilino actualizamos todos sus datos.
    
    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM inquilino) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SET @declaracion = 'UPDATE inquilino SET DNI = ?, nombre = ?, email = ?, telefono = ?, mascota = ? WHERE id = ?';
    PREPARE prepared_stmt FROM @declaracion;

    SET @id = p_id;
    SET @DNI = p_DNI;
    SET @nombre = p_nombre;
    SET @email = p_email;
    SET @telefono = p_telefono;
    SET @mascota = p_mascota;

    EXECUTE prepared_stmt USING @DNI, @nombre, @email, @telefono, @mascota, @id;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_del_inquilino //
CREATE PROCEDURE sp_del_inquilino(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento elimina de la tabla inquilino el registro con el ID indicado

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM inquilino) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    DELETE FROM inquilino WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;

-- Operaciones CRUD contrato
DELIMITER //
DROP PROCEDURE sp_get_contrato //
CREATE PROCEDURE sp_get_contrato(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento utiliza una sentencia SELECT 
    -- simple para obtener todos los datos de un contrato

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM contrata) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    SELECT * FROM contrata WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_ins_contrato //
CREATE PROCEDURE sp_ins_contrato(
    IN p_id_inquilino INT,
    IN p_codigo_vivienda VARCHAR(50),
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_precio DECIMAL(7, 2),
    IN p_estado VARCHAR(50),
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dinámico para introducir los valores
    -- del nuevo registro en la tabla

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que el inquilino o la viivenda no existan
    IF p_id_inquilino NOT IN (SELECT id FROM inquilino) OR p_codigo_vivienda NOT IN (SELECT codigo FROM vivienda) THEN
        SET p_err = -3;
        LEAVE sp;
    END IF;

    SET @declaracion = 'INSERT INTO contrata VALUES (NULL, ?, ?, ?, ?, ?, ?)';
    PREPARE prepared_stmt FROM @declaracion;

    SET @id_inquilino = p_id_inquilino;
    SET @codigo_vivienda = p_codigo_vivienda;
    SET @fecha_inicio = p_fecha_inicio;
    SET @fecha_fin = p_fecha_fin;
    SET @precio = p_precio;
    SET @estado = (SELECT id FROM tipo_estado WHERE estado = p_estado);

    EXECUTE prepared_stmt USING @id_inquilino, @codigo_vivienda, @fecha_inicio, @fecha_fin, @precio, @estado;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_upd_contrato //
CREATE PROCEDURE sp_upd_contrato(
    IN p_id INT,
    IN p_id_inquilino INT,
    IN p_codigo_vivienda VARCHAR(50),
    IN p_fecha_inicio DATE,
    IN p_fecha_fin DATE,
    IN p_precio DECIMAL(7, 2),
    IN p_estado INT,
    OUT p_err INT
)
sp: BEGIN
    -- el procedimiento utiliza SQL dińamico para ejecutar
    -- una sentencia de actualización.
    -- basándonos en el ID del inquilino y el código de la vivienda actualizamos todos los datos del contrato.
    
    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM contrata) THEN
        SET p_err = 2;
        LEAVE sp;
    END IF;

    -- en caso de que el inquilino o la viivenda nuevas no existan
    IF p_id_inquilino NOT IN (SELECT id FROM inquilino) OR p_codigo_vivienda NOT IN (SELECT codigo FROM vivienda) THEN
        SET p_err = -3;
        LEAVE sp;
    END IF;

    SET @declaracion = 'UPDATE contrata SET id_inquilino = ?, codigo_vivienda = ?, fecha_inicio = ?, fecha_fin = ?, precio = ?, estado = ? WHERE id = ?';
    PREPARE prepared_stmt FROM @declaracion;

    SET @id = p_id;
    SET @id_inquilino = p_id_inquilino;
    SET @codigo_vivienda = p_codigo_vivienda;
    SET @fecha_inicio = p_fecha_inicio;
    SET @fecha_fin = p_fecha_fin;
    SET @precio = p_precio;
    SET @estado = (SELECT id FROM tipo_estado WHERE estado = p_estado);

    EXECUTE prepared_stmt USING @id_inquilino, @codigo_vivienda, @fecha_inicio, @fecha_fin, @precio, @estado, @id;

    DEALLOCATE PREPARE prepared_stmt;
    SET p_err = 0;
END //
DELIMITER ;

DELIMITER //
DROP PROCEDURE sp_del_contrato //
CREATE PROCEDURE sp_del_contrato(IN p_id INT, OUT p_err INT)
sp: BEGIN
    -- el procedimiento elimina de la tabla contrato el registro con el ID de inquilino y el codigo de vivienda indicados

    -- tratamiento de errores
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        SET p_err = -1;
    END;

    -- en caso de que no exista el id solicitado
    IF p_id NOT IN (SELECT id FROM contrata) THEN
        SET p_err = -2;
        LEAVE sp;
    END IF;

    DELETE FROM contrata WHERE id = p_id;
    SET p_err = 0;
END //
DELIMITER ;
