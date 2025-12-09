package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@IdClass(ReservaId.class)
public class Reserva implements Serializable {
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Id
    @Column(name = "numerohab")
    private Integer numeroHab;
    
    @Id
    @Column(name = "fechallegada")
    private LocalDate fechaLlegada;
    
    @Column(name = "fechasalida", nullable = false)
    private LocalDate fechaSalida;
    
    @Column(name = "tiempomaxcancel", nullable = false)
    private Integer tiempoMaxCancel;
    
    @ManyToOne
    @JoinColumn(name = "cedulaper", insertable = false, updatable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "numerohab", insertable = false, updatable = false)
    private Habitacion habitacion;
    
    // Constructores
    public Reserva() {}
    
    public Reserva(String cedulaPer, Integer numeroHab, String fechaLlegada, 
                   String fechaSalida, Integer tiempoMaxCancel) {
        this.cedulaPer = cedulaPer;
        this.numeroHab = numeroHab;
        this.fechaLlegada = LocalDate.parse(fechaLlegada);
        this.fechaSalida = LocalDate.parse(fechaSalida);
        this.tiempoMaxCancel = tiempoMaxCancel;
    }
    
    // Getters y Setters
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
    
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public Integer getTiempoMaxCancel() {
        return tiempoMaxCancel;
    }
    
    public void setTiempoMaxCancel(Integer tiempoMaxCancel) {
        this.tiempoMaxCancel = tiempoMaxCancel;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Habitacion getHabitacion() {
        return habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
