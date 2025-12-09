package com.hotelBD.repository;

import com.hotelBD.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    // Buscar por nombre del servicio (nomServicio)
    List<Servicio> findByNomServicioContainingIgnoreCase(String nomServicio);

    // Si quieres buscar por contenido
    List<Servicio> findByContenidoServicioContainingIgnoreCase(String contenidoServicio);
}
