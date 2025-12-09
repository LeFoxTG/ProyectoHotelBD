
package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// ==================== CLIENTE REPOSITORY ====================
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    
    // Buscar cliente por nombre
    @Query("SELECT c FROM Cliente c JOIN c.persona p " +
           "WHERE LOWER(p.primerNom) LIKE LOWER(CONCAT('%', :nombre, '%')) " +
           "OR LOWER(p.primerApell) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Cliente> findByNombre(@Param("nombre") String nombre);
    
    // Obtener cliente con sus datos personales completos
    @Query("SELECT c FROM Cliente c JOIN FETCH c.persona WHERE c.cedulaPer = :cedula")
    Cliente findClienteConPersona(@Param("cedula") String cedula);
}
