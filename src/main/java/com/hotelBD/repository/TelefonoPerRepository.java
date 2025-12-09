package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TelefonoPerRepository extends JpaRepository<TelefonoPer, TelefonoPerId> {
    
    // Obtener todos los teléfonos de una persona
    List<TelefonoPer> findByCedulaPer(String cedulaPer);
}
