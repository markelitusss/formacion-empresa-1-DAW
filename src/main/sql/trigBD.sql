-- Formación Empresa --------------------------
-- Triggers BD --------------------------------
-- Markel Canales Ramos 1º DAW ----------------
-- --------------------------------------------

-- Triggers solapamiento de fechas
DELIMITER //
DROP TRIGGER tr_fechas_insert //
CREATE TRIGGER tr_fechas_insert BEFORE INSERT ON contrata
FOR EACH ROW
BEGIN
    DECLARE v_numero_filas INT;

    SELECT COUNT(*) INTO v_numero_filas FROM contrata
    WHERE codigo_vivienda = NEW.codigo_vivienda
    AND (NEW.fecha_inicio <= fecha_fin AND NEW.fecha_fin >= fecha_inicio);

    IF v_numero_filas > 0 THEN
        SIGNAL SQLSTATE '45000' SET message_text = 'Solapamiento de fechas en la insercion';
    END IF;
END //
DELIMITER ;

DELIMITER //
DROP TRIGGER tr_fechas_update //
CREATE TRIGGER tr_fechas_update BEFORE UPDATE ON contrata
FOR EACH ROW
BEGIN
    DECLARE v_numero_filas INT;

    SELECT COUNT(*) INTO v_numero_filas FROM contrata
    WHERE codigo_vivienda = NEW.codigo_vivienda
    AND (NEW.fecha_inicio <= fecha_fin AND NEW.fecha_fin >= fecha_inicio)
    AND (NEW.fecha_inicio != OLD.fecha_inicio OR NEW.fecha_fin != OLD.fecha_fin);

    IF v_numero_filas > 0 THEN
        SIGNAL SQLSTATE '45000' SET message_text = 'Solapamiento de fechas en la actualización';
    END IF;
END //
DELIMITER ;

-- Triggers para controlar que no haya contratos entre inquilinos con mascota y viviendas que no aceptan mascotas
DELIMITER //
DROP TRIGGER tr_mascota_insert //
CREATE TRIGGER tr_mascota_insert BEFORE INSERT ON contrata
FOR EACH ROW
BEGIN
    DECLARE v_mascota_inquilino INT;
    DECLARE v_mascota_vivienda INT;

    SELECT mascota INTO v_mascota_inquilino FROM inquilino WHERE id = NEW.id_inquilino;
    SELECT acepta_mascota INTO v_mascota_vivienda FROM vivienda WHERE codigo = NEW.codigo_vivienda;

    IF (v_mascota_inquilino = 1) AND (v_mascota_vivienda = 0) THEN
        SIGNAL SQLSTATE '45000' SET message_text = 'Mascota';
    END IF;
END //
DELIMITER ;

DELIMITER //
DROP TRIGGER tr_mascota_update //
CREATE TRIGGER tr_mascota_update BEFORE UPDATE ON contrata
FOR EACH ROW
BEGIN
    DECLARE v_mascota_inquilino INT;
    DECLARE v_mascota_vivienda INT;

    SELECT mascota INTO v_mascota_inquilino FROM inquilino WHERE id = NEW.id_inquilino;
    SELECT acepta_mascota INTO v_mascota_vivienda FROM vivienda WHERE codigo = NEW.codigo_vivienda;

    IF (v_mascota_inquilino = 1) AND (v_mascota_vivienda = 0) THEN
        SIGNAL SQLSTATE '45000' SET message_text = 'Mascota';
    END IF;
END //
DELIMITER ;

-- Evento para controlar la fecha de fin de los contratos
DELIMITER //
DROP EVENT evt_contratos_vencidos //
CREATE EVENT evt_contratos_vencidos ON SCHEDULE EVERY 1 DAY
DO
    BEGIN
        UPDATE contrata SET estado = 3 WHERE fecha_fin < CURDATE();
    END //
DELIMITER ;