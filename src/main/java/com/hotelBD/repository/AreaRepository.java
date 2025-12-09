package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    
    // Buscar área por nombre
    @Query("SELECT a FROM Area a WHERE LOWER(a.nombreArea) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Area> findByNombreContaining(@Param("nombre") String nombre);
}