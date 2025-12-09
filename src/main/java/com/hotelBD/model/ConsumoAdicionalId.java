package com.hotelBD.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

// Clase para PK Compuesta de ConsumoAdicional
public class ConsumoAdicionalId implements Serializable {
    private LocalDate fechaConsumo;
    private LocalTime horaConsumo;
    private LocalDate fechaLlegada;
    private Integer numeroHab;
    private String cedulaPer;
    private Integer idServicio;
    
    public ConsumoAdicionalId() {}
    
    // Getters, Setters, equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumoAdicionalId that = (ConsumoAdicionalId) o;
        return fechaConsumo.equals(that.fechaConsumo) && 
               horaConsumo.equals(that.horaConsumo) && 
               fechaLlegada.equals(that.fechaLlegada) &&
               numeroHab.equals(that.numeroHab) &&
               cedulaPer.equals(that.cedulaPer) &&
               idServicio.equals(that.idServicio);
    }
    
    @Override
    public int hashCode() {
        return fechaConsumo.hashCode() + horaConsumo.hashCode() + 
               fechaLlegada.hashCode() + numeroHab.hashCode() + 
               cedulaPer.hashCode() + idServicio.hashCode();
    }
}
