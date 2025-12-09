package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CorreoRepository extends JpaRepository<Correo, CorreoId> {
    
    // Obtener todos los correos de un cliente
    List<Correo> findByCedulaPer(String cedulaPer);
}
