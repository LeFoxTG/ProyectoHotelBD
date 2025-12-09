package com.hotelBD.repository;

import com.hotelBD.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    // Buscar servicios por nombre (contiene)
    List<Servicio> findByNombreContainingIgnoreCase(String nombre);

    // Servicios por estado (Activo / Inactivo)
    List<Servicio> findByEstadoServ(String estadoServ);

    // Servicios dentro de un rango de precio
    @Query("SELECT s FROM Servicio s WHERE s.precioServ BETWEEN :min AND :max")
    List<Servicio> findByPrecioRange(@Param("min") Double min, @Param("max") Double max);

    // Buscar servicio con consumos adicionales asociados
    @Query("SELECT s FROM Servicio s LEFT JOIN FETCH s.consumoAdicionalList WHERE s.idServ = :idServ")
    Servicio findServicioConConsumos(@Param("idServ") Integer idServ);

    // Contar servicios activos
    @Query("SELECT COUNT(s) FROM Servicio s WHERE s.estadoServ = 'Activo'")
    Long countServiciosActivos();
}
