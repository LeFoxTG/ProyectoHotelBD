-- 1. Rol para la Recepción
CREATE ROLE recepcion NOLOGIN;

-- 2. Rol para el Personal de Servicio
CREATE ROLE servicio NOLOGIN;

-- 3. Rol para Administración
CREATE ROLE administracion NOLOGIN;

-- Gestión de Clientes y Reservas (I/U/C)
GRANT INSERT, UPDATE, SELECT ON Persona TO recepcion;
GRANT INSERT, UPDATE, SELECT ON Cliente TO recepcion;
GRANT INSERT, UPDATE, SELECT ON Reserva TO recepcion;

-- Consulta de Habitaciones
GRANT SELECT ON Habitacion TO recepcion;

-- Gestión de Habitaciones (para limpieza/mantenimiento)
GRANT SELECT, UPDATE (estadoHab) ON Habitacion TO servicio; -- Solo puede actualizar el estado

-- Registro de Consumos Adicionales
GRANT INSERT ON ConsumoAdicional TO servicio;
GRANT SELECT ON Servicio TO servicio; -- Necesitan ver qué servicios pueden registrar
GRANT SELECT ON Reserva TO servicio; -- Necesitan ver las reservas activas para el consumo

-- Gestión de Empleados (Control total sobre datos de Personal y Áreas)
GRANT ALL PRIVILEGES ON Persona TO administracion;
GRANT ALL PRIVILEGES ON Empleado TO administracion;
GRANT ALL PRIVILEGES ON Area TO administracion;

-- Gestión de Servicios (Control total)
GRANT ALL PRIVILEGES ON Servicio TO administracion;

-- Consultas Administrativas (Análisis)
GRANT SELECT ON Cliente TO administracion;
GRANT SELECT ON Reserva TO administracion;
GRANT SELECT ON ConsumoAdicional TO administracion;

-- Acceso a tablas de soporte para consulta (opcional)
GRANT SELECT ON TelefonoPer TO administracion;
GRANT SELECT ON Correo TO administracion;

-- 1. Crear usuarios de ejemplo
CREATE USER user_recepcion WITH PASSWORD 'contraseña_recep';
CREATE USER user_servicio_1 WITH PASSWORD 'contraseña_serv1';
CREATE USER user_admin WITH PASSWORD 'contraseña_admin';

-- 2. Asignar los roles de permisos a los usuarios
GRANT recepcion TO user_recepcion;
GRANT servicio TO user_servicio_1;
GRANT administracion TO user_admin;

REVOKE ALL ON ALL TABLES IN SCHEMA public FROM PUBLIC;