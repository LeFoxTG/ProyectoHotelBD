package com.hotelBD.repository;

import com.hotelBD.model.ConsumoAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoAdicionalRepository extends JpaRepository<ConsumoAdicional, Integer> {

    // Buscar consumos por id de reservación
    List<ConsumoAdicional> findByIdReservacion(Integer idReservacion);

    // Buscar consumos por servicio
    List<ConsumoAdicional> findByIdServ(Integer idServ);

    // Obtener consumos con información del servicio asociado
    @Query("SELECT c FROM ConsumoAdicional c JOIN FETCH c.servicio WHERE c.idReservacion = :idRes")
    List<ConsumoAdicional> findConsumosConServicio(@Param("idRes") Integer idReservacion);

    // Total gastado por reservación
    @Query("SELECT SUM(c.precioTotal) FROM ConsumoAdicional c WHERE c.idReservacion = :idReservacion")
    Double calcularTotalPorReservacion(@Param("idReservacion") Integer idReservacion);

    // Contar consumos de un servicio
    @Query("SELECT COUNT(c) FROM ConsumoAdicional c WHERE c.idServ = :idServ")
    Long countByServicio(@Param("idServ") Integer idServ);
}
