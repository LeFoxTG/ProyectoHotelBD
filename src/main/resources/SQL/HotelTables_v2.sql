-- ELIMINACIÓN DE TABLAS (si existen)
DROP TABLE IF EXISTS ConsumoAdicional CASCADE;
DROP TABLE IF EXISTS Reserva CASCADE;
DROP TABLE IF EXISTS Correo CASCADE;
DROP TABLE IF EXISTS TelefonoPer CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Empleado CASCADE;
DROP TABLE IF EXISTS Servicio CASCADE;
DROP TABLE IF EXISTS Habitacion CASCADE;
DROP TABLE IF EXISTS Area CASCADE;
DROP TABLE IF EXISTS Persona CASCADE;


-- CREACIÓN DE TABLAS

-- PERSONA
CREATE TABLE IF NOT EXISTS Persona (
	cedulaPer NUMERIC(11),
	primerNom VARCHAR(250) NOT NULL,
	segundoNom VARCHAR(250),
	primerApell VARCHAR(250) NOT NULL,
	segundoApell VARCHAR(250),
	calle VARCHAR(100) NOT NULL,
	carrera VARCHAR(100) NOT NULL,
	numero VARCHAR(100) NOT NULL,
	complemento VARCHAR(250)
);

ALTER TABLE Persona
ADD CONSTRAINT pk_persona
PRIMARY KEY (cedulaPer);


-- ÁREA
CREATE TABLE IF NOT EXISTS Area (
	idArea NUMERIC(11),
	nombreArea VARCHAR(250) NOT NULL
);

ALTER TABLE Area
ADD CONSTRAINT pk_area
PRIMARY KEY (idArea);


-- EMPLEADO
CREATE TABLE IF NOT EXISTS Empleado (
	cedulaPer NUMERIC(11),
	cargo VARCHAR(250) NOT NULL,
	idArea NUMERIC(11)
);

ALTER TABLE Empleado
ADD CONSTRAINT pk_empleado
PRIMARY KEY (cedulaPer);

ALTER TABLE Empleado
ADD CONSTRAINT fk_emp_per
FOREIGN KEY (cedulaPer)
REFERENCES Persona(cedulaPer)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Empleado
ADD CONSTRAINT fk_emp_area
FOREIGN KEY (idArea)
REFERENCES Area(idArea)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- TELÉFONO PERSONA
CREATE TABLE IF NOT EXISTS TelefonoPer (
	cedulaPer NUMERIC(11),
	telefonoPer NUMERIC(10) NOT NULL
);

ALTER TABLE TelefonoPer
ADD CONSTRAINT pk_telefonoPer
PRIMARY KEY (cedulaPer, telefonoPer);

ALTER TABLE TelefonoPer
ADD CONSTRAINT fk_tel_per
FOREIGN KEY (cedulaPer)
REFERENCES Persona(cedulaPer)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE TelefonoPer
ADD CONSTRAINT ck_tel_positive
CHECK (telefonoPer > 0);


-- CLIENTE
CREATE TABLE IF NOT EXISTS Cliente (
	cedulaPer NUMERIC(11)
);

ALTER TABLE Cliente
ADD CONSTRAINT pk_cliente
PRIMARY KEY (cedulaPer);

ALTER TABLE Cliente
ADD CONSTRAINT fk_cliente_persona
FOREIGN KEY (cedulaPer)
REFERENCES Persona(cedulaPer)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- CORREO 
CREATE TABLE IF NOT EXISTS Correo (
	cedulaPer NUMERIC(11),
	correo VARCHAR(250) NOT NULL
);

ALTER TABLE Correo
ADD CONSTRAINT pk_correo
PRIMARY KEY (cedulaPer, correo);

ALTER TABLE Correo
ADD CONSTRAINT fk_correo_cliente
FOREIGN KEY (cedulaPer)
REFERENCES Cliente(cedulaPer)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- HABITACIÓN
CREATE TABLE IF NOT EXISTS Habitacion (
	numeroHab NUMERIC(5),
	categoria VARCHAR(100) NOT NULL,
	estadoHab VARCHAR(100) NOT NULL,
	precioNoche NUMERIC(11) NOT NULL
);

ALTER TABLE Habitacion
ADD CONSTRAINT pk_habitacion
PRIMARY KEY (numeroHab);

ALTER TABLE Habitacion
ADD CONSTRAINT ck_categoria_habitacion
CHECK (categoria IN ('Sencilla', 'Doble', 'Suite'));

ALTER TABLE Habitacion
ADD CONSTRAINT ck_estado_habitacion
CHECK (estadoHab IN ('Disponible', 'No disponible'));

ALTER TABLE Habitacion
ADD CONSTRAINT ck_precio_habitacion
CHECK (precioNoche > 0);


-- SERVICIO
CREATE TABLE IF NOT EXISTS Servicio (
	idServicio NUMERIC(11),
	nomServicio VARCHAR(250) NOT NULL,
	contenidoServicio VARCHAR(250) NOT NULL,
	costoServicio NUMERIC(11) NOT NULL
);

ALTER TABLE Servicio
ADD CONSTRAINT pk_servicio
PRIMARY KEY (idServicio);

ALTER TABLE Servicio
ADD CONSTRAINT ck_costoservicio
CHECK (costoServicio > 0);

-- RESERVA
-- Relación entre Cliente y Habitación
CREATE TABLE IF NOT EXISTS Reserva (
	cedulaPer NUMERIC(11),
	numeroHab NUMERIC(5),
	fechaLlegada DATE NOT NULL,
	fechaSalida DATE NOT NULL,
	tiempoMaxCancel NUMERIC(5) NOT NULL
);

ALTER TABLE Reserva
ADD CONSTRAINT pk_reserva
PRIMARY KEY (cedulaPer, numeroHab, fechaLlegada);

ALTER TABLE Reserva
ADD CONSTRAINT fk_reserva_cliente
FOREIGN KEY (cedulaPer)
REFERENCES Cliente(cedulaPer)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Reserva
ADD CONSTRAINT fk_reserva_habitacion
FOREIGN KEY (numeroHab)
REFERENCES Habitacion(numeroHab)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE Reserva
ADD CONSTRAINT ck_fechas_reserva
CHECK (fechaLlegada < fechaSalida);

ALTER TABLE Reserva
ADD CONSTRAINT ck_tiempo_cancela
CHECK (tiempoMaxCancel > 0);

-- CONSUMO ADICIONAL
-- Relación entre Reserva y Servicio
CREATE TABLE IF NOT EXISTS ConsumoAdicional (
	fechaConsumo DATE,
	horaConsumo TIME,
	fechaLlegada DATE,
	numeroHab NUMERIC(5),
	cedulaPer NUMERIC(11),
	idServicio NUMERIC(11)
);

ALTER TABLE ConsumoAdicional
ADD CONSTRAINT pk_consumoAdicional
PRIMARY KEY (fechaConsumo, horaConsumo, fechaLlegada, numeroHab, cedulaPer, idServicio);

ALTER TABLE ConsumoAdicional
ADD CONSTRAINT fk_conres
FOREIGN KEY (cedulaPer, numeroHab, fechaLlegada)
REFERENCES Reserva(cedulaPer, numeroHab, fechaLlegada)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE ConsumoAdicional
ADD CONSTRAINT fk_conser
FOREIGN KEY (idServicio)
REFERENCES Servicio(idServicio)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE ConsumoAdicional
ADD CONSTRAINT ck_fecha_consumo
CHECK (fechaConsumo >= fechaLlegada);
