package com.hotelBD.repository;

import com.hotelBD.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    
    // Empleados por área
    List<Empleado> findByIdArea(Integer idArea);
    
    // Empleados por cargo
    List<Empleado> findByCargo(String cargo);
    
    // Buscar empleado con sus datos personales
    @Query("SELECT e FROM Empleado e JOIN FETCH e.persona WHERE e.cedulaPer = :cedula")
    Empleado findEmpleadoConPersona(@Param("cedula") String cedula);
    
    // Empleados de un área específica con sus datos
    @Query("SELECT e FROM Empleado e JOIN FETCH e.persona JOIN FETCH e.area WHERE e.idArea = :idArea")
    List<Empleado> findEmpleadosPorAreaCompletos(@Param("idArea") Integer idArea);
    
    // Contar empleados por área
    @Query("SELECT e.idArea, COUNT(e) FROM Empleado e GROUP BY e.idArea")
    List<Object[]> countEmpleadosPorArea();
}