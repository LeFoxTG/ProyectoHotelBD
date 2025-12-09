package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    
    // Habitaciones por estado
    List<Habitacion> findByEstadoHab(String estadoHab);
    
    // Habitaciones por categoría
    List<Habitacion> findByCategoria(String categoria);
    
    // Habitaciones disponibles de una categoría específica
    List<Habitacion> findByCategoriaAndEstadoHab(String categoria, String estadoHab);
    
    // Habitaciones en rango de precio
    @Query("SELECT h FROM Habitacion h WHERE h.precioNoche BETWEEN :min AND :max")
    List<Habitacion> findByPrecioRange(@Param("min") Double min, @Param("max") Double max);
    
    // Contar habitaciones disponibles
    @Query("SELECT COUNT(h) FROM Habitacion h WHERE h.estadoHab = 'Disponible'")
    Long countDisponibles();
}
