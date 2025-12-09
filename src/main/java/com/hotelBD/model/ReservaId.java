package com.hotelBD.model;

import java.io.Serializable;
import java.time.LocalDate;

// Clase para la Primary Key Compuesta
public class ReservaId implements Serializable {
    private String cedulaPer;
    private Integer numeroHab;
    private LocalDate fechaLlegada;
    
    public ReservaId() {}
    
    public ReservaId(String cedulaPer, Integer numeroHab, LocalDate fechaLlegada) {
        this.cedulaPer = cedulaPer;
        this.numeroHab = numeroHab;
        this.fechaLlegada = fechaLlegada;
    }
    
    // Getters, Setters, equals y hashCode
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public Integer getNumeroHab() {
        return numeroHab;
    }
    
    public void setNumeroHab(Integer numeroHab) {
        this.numeroHab = numeroHab;
    }
    
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }
    
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaId that = (ReservaId) o;
        return cedulaPer.equals(that.cedulaPer) && 
               numeroHab.equals(that.numeroHab) && 
               fechaLlegada.equals(that.fechaLlegada);
    }
    
    @Override
    public int hashCode() {
        return cedulaPer.hashCode() + numeroHab.hashCode() + fechaLlegada.hashCode();
    }
}
