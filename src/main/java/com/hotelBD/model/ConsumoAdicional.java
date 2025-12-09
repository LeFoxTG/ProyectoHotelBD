package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consumoadicional")
@IdClass(ConsumoAdicionalId.class)
public class ConsumoAdicional implements Serializable {
    
    @Id
    @Column(name = "fechaconsumo")
    private LocalDate fechaConsumo;
    
    @Id
    @Column(name = "horaconsumo")
    private LocalTime horaConsumo;
    
    @Id
    @Column(name = "fechallegada")
    private LocalDate fechaLlegada;
    
    @Id
    @Column(name = "numerohab")
    private Integer numeroHab;
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Id
    @Column(name = "idservicio")
    private Integer idServicio;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cedulaper", referencedColumnName = "cedulaper", insertable = false, updatable = false),
        @JoinColumn(name = "numerohab", referencedColumnName = "numerohab", insertable = false, updatable = false),
        @JoinColumn(name = "fechallegada", referencedColumnName = "fechallegada", insertable = false, updatable = false)
    })
    private Reserva reserva;
    
    @ManyToOne
    @JoinColumn(name = "idservicio", insertable = false, updatable = false)
    private Servicio servicio;
    
    public ConsumoAdicional() {}
    
    public ConsumoAdicional(String fechaConsumo, String horaConsumo, String fechaLlegada, 
                           Integer numeroHab, String cedulaPer, Integer idServicio) {
        this.fechaConsumo = LocalDate.parse(fechaConsumo);
        this.horaConsumo = LocalTime.parse(horaConsumo);
        this.fechaLlegada = LocalDate.parse(fechaLlegada);
        this.numeroHab = numeroHab;
        this.cedulaPer = cedulaPer;
        this.idServicio = idServicio;
    }
    
    // Getters y Setters
    public LocalDate getFechaConsumo() {
        return fechaConsumo;
    }
    
    public void setFechaConsumo(LocalDate fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }
    
    public LocalTime getHoraConsumo() {
        return horaConsumo;
    }
    
    public void setHoraConsumo(LocalTime horaConsumo) {
        this.horaConsumo = horaConsumo;
    }
    
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }
    
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    public Integer getNumeroHab() {
        return numeroHab;
    }
    
    public void setNumeroHab(Integer numeroHab) {
        this.numeroHab = numeroHab;
    }
    
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public Integer getIdServicio() {
        return idServicio;
    }
    
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    
    public Reserva getReserva() {
        return reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    public Servicio getServicio() {
        return servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
