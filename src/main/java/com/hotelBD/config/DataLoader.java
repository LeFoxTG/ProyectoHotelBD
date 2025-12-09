package com.hotelBD.config;

import com.hotelBD.model.*;
import com.hotelBD.repository.*;
import com.hotelBD.utils.CsvUtils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonaRepository personaRepo;
    private final AreaRepository areaRepo;
    private final EmpleadoRepository empleadoRepo;
    private final TelefonoPerRepository telefonoRepo;
    private final ClienteRepository clienteRepo;
    private final CorreoRepository correoRepo;
    private final HabitacionRepository habitRepo;
    private final ServicioRepository servicioRepo;
    private final ReservaRepository reservaRepo;
    private final ConsumoAdicionalRepository consumoRepo;

    public DataLoader(PersonaRepository personaRepo, AreaRepository areaRepo, EmpleadoRepository empleadoRepo,
                      TelefonoPerRepository telefonoRepo, ClienteRepository clienteRepo, 
                      CorreoRepository correoRepo, HabitacionRepository habitRepo,
                      ServicioRepository servicioRepo, ReservaRepository reservaRepo,
                      ConsumoAdicionalRepository consumoRepo) {
        this.personaRepo = personaRepo;
        this.areaRepo = areaRepo;
        this.empleadoRepo = empleadoRepo;
        this.telefonoRepo = telefonoRepo;
        this.clienteRepo = clienteRepo;
        this.correoRepo = correoRepo;
        this.habitRepo = habitRepo;
        this.servicioRepo = servicioRepo;
        this.reservaRepo = reservaRepo;
        this.consumoRepo = consumoRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPersonas();
        loadAreas();
        loadEmpleados();
        loadTelefonos();
        loadClientes();
        loadCorreos();
        loadHabitaciones();
        loadServicios();
        loadReservas();
        loadConsumoAdicional();
    }

    private void loadPersonas() {
        if (personaRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Persona.csv");
            for (String[] r : rows) {
                Persona p = new Persona(
                        r[0], r[1], r[2], r[3], r[4], r[5], r[6], r[7], r[8]
                );
                personaRepo.save(p);
            }
        }
    }

    private void loadAreas() {
        if (areaRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Area.csv");
            for (String[] r : rows) {
                Area a = new Area(Integer.parseInt(r[0]), r[1]);
                areaRepo.save(a);
            }
        }
    }

    private void loadEmpleados() {
        if (empleadoRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Empleado.csv");
            for (String[] r : rows) {
                Empleado e = new Empleado(r[0], r[1], Integer.parseInt(r[2]));
                empleadoRepo.save(e);
            }
        }
    }

    private void loadTelefonos() {
        if (telefonoRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/TelefonoPer.csv");
            for (String[] r : rows) {
                TelefonoPer t = new TelefonoPer(r[0], r[1]);
                telefonoRepo.save(t);
            }
        }
    }

    private void loadClientes() {
        if (clienteRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Cliente.csv");
            for (String[] r : rows) {
                Cliente c = new Cliente(r[0]);
                clienteRepo.save(c);
            }
        }
    }

    private void loadCorreos() {
        if (correoRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Correo.csv");
            for (String[] r : rows) {
                Correo c = new Correo(r[0], r[1]);
                correoRepo.save(c);
            }
        }
    }

    private void loadHabitaciones() {
        if (habitRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Habitacion.csv");
            for (String[] r : rows) {
                Habitacion h = new Habitacion(
                        Integer.parseInt(r[0]),
                        r[1],
                        r[2],
                        Double.parseDouble(r[3])
                );
                habitRepo.save(h);
            }
        }
    }

    private void loadServicios() {
        if (servicioRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Servicio.csv");
            for (String[] r : rows) {
                Servicio s = new Servicio(
                        Integer.parseInt(r[0]),
                        r[1], r[2], Double.parseDouble(r[3])
                );
                servicioRepo.save(s);
            }
        }
    }

    private void loadReservas() {
        if (reservaRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/Reserva.csv");
            for (String[] r : rows) {
                Reserva x = new Reserva(
                        r[0],
                        Integer.parseInt(r[1]),
                        r[2],
                        r[3],
                        Integer.parseInt(r[4])
                );
                reservaRepo.save(x);
            }
        }
    }

    private void loadConsumoAdicional() {
        if (consumoRepo.count() == 0) {
            List<String[]> rows = CsvUtils.readCsv("/DATA/ConsumoAdicional.csv");
            for (String[] r : rows) {
                ConsumoAdicional c = new ConsumoAdicional(
                        r[0],
                        r[1],
                        r[2],
                        Integer.parseInt(r[3]),
                        r[4],
                        Integer.parseInt(r[5])
                );
                consumoRepo.save(c);
            }
        }
    }
}