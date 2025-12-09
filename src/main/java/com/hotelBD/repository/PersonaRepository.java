package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    
    // Buscar persona por nombre
    @Query("SELECT p FROM Persona p WHERE LOWER(p.primerNom) LIKE LOWER(CONCAT('%', :nombre, '%')) " +
           "OR LOWER(p.primerApell) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Persona> findByNombre(@Param("nombre") String nombre);
}