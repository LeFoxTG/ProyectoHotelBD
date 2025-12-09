package com.hotelBD.repository;

import com.hotelBD.model.ConsumoAdicional;
import com.hotelBD.model.ConsumoAdicionalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ConsumoAdicionalRepository extends JpaRepository<ConsumoAdicional, ConsumoAdicionalId> {

    // Buscar consumos por fecha de consumo
    List<ConsumoAdicional> findByFechaConsumo(LocalDate fechaConsumo);

    // Buscar consumos dentro de un rango de fechas
    List<ConsumoAdicional> findByFechaConsumoBetween(LocalDate inicio, LocalDate fin);

    // Buscar consumos por número de habitación
    List<ConsumoAdicional> findByNumeroHab(Integer numeroHab);

    // Buscar consumos por cliente
    List<ConsumoAdicional> findByCedulaPer(String cedulaPer);

    // Buscar consumos por servicio específico
    List<ConsumoAdicional> findByIdServicio(Integer idServicio);

    // Buscar consumos por fecha + habitación
    List<ConsumoAdicional> findByFechaConsumoAndNumeroHab(LocalDate fechaConsumo, Integer numeroHab);

    // Buscar consumos exactos
    List<ConsumoAdicional> findByFechaConsumoAndHoraConsumo(LocalDate fechaConsumo, LocalTime horaConsumo);
}
