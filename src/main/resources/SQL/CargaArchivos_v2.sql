-------1. Persona
COPY Persona(cedulaPer, primerNom, segundoNom, primerApell, segundoApell, calle, carrera, numero, complemento)
FROM 'src/main/resources/DATA/Persona.csv'
DELIMITER ','
CSV HEADER;

-------2. Area
COPY Area(idArea, nombreArea)
FROM 'src/main/resources/DATA/Area.csv'
DELIMITER ','
CSV HEADER;

-------3. Empleado
COPY Empleado(cedulaPer, cargo, idArea)
FROM 'src/main/resources/DATA/Empleado.csv'
DELIMITER ','
CSV HEADER;

-------4. TelefonoPer
COPY TelefonoPer(cedulaPer, telefonoPer)
FROM 'src/main/resources/DATA/TelefonoPer.csv'
DELIMITER ','
CSV HEADER;

-------5. Cliente
COPY Cliente(cedulaPer)
FROM 'src/main/resources/DATA/Cliente.csv'
DELIMITER ','
CSV HEADER;

-------6. Correo
COPY Correo(cedulaPer, correo)
FROM 'src/main/resources/DATA/Correo.csv'
DELIMITER ','
CSV HEADER;

-------7. Habitacion
COPY Habitacion(numeroHab, categoria, estadoHab, precioNoche)
FROM 'src/main/resources/DATA/Habitacion.csv'
DELIMITER ','
CSV HEADER;

-------8. Servicio
COPY Servicio(idServicio, nomServicio, contenidoServicio, costoServicio)
FROM 'src/main/resources/DATA/Servicio.csv'
DELIMITER ','
CSV HEADER;

-------9. Reserva
COPY Reserva(cedulaPer, numeroHab, fechaLlegada, fechaSalida, tiempoMaxCancel)
FROM 'src/main/resources/DATA/Reserva.csv'
DELIMITER ','
CSV HEADER;

-------10. ConsumoAdicional
COPY ConsumoAdicional(fechaConsumo, horaConsumo, fechaLlegada, numeroHab, cedulaPer, idServicio)
FROM 'src/main/resources/DATA/ConsumoAdicional.csv'
DELIMITER ','
CSV HEADER;