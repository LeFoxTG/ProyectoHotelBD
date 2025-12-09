package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, ReservaId> {
    
    // Encontrar todas las reservas de un cliente
    List<Reserva> findByCedulaPer(String cedulaPer);
    
    // Encontrar reservas por habitación
    List<Reserva> findByNumeroHab(Integer numeroHab);
    
    // Reservas activas (fecha de llegada <= hoy <= fecha de salida)
    @Query("SELECT r FROM Reserva r WHERE r.fechaLlegada <= :fecha AND r.fechaSalida >= :fecha")
    List<Reserva> findReservasActivas(@Param("fecha") LocalDate fecha);
    
    // Verificar disponibilidad de habitación en un rango de fechas
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN false ELSE true END " +
           "FROM Reserva r WHERE r.numeroHab = :numeroHab " +
           "AND ((r.fechaLlegada BETWEEN :llegada AND :salida) " +
           "OR (r.fechaSalida BETWEEN :llegada AND :salida) " +
           "OR (:llegada BETWEEN r.fechaLlegada AND r.fechaSalida))")
    boolean isHabitacionDisponible(@Param("numeroHab") Integer numeroHab,
                                    @Param("llegada") LocalDate llegada,
                                    @Param("salida") LocalDate salida);
    
    // Reservas próximas a llegar (en los próximos N días)
    @Query("SELECT r FROM Reserva r WHERE r.fechaLlegada BETWEEN :hoy AND :futuro")
    List<Reserva> findReservasProximas(@Param("hoy") LocalDate hoy, 
                                       @Param("futuro") LocalDate futuro);
}

