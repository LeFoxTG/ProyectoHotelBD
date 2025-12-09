package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {
    
    @Id
    @Column(name = "idservicio")
    private Integer idServicio;
    
    @Column(name = "nomservicio", nullable = false)
    private String nomServicio;
    
    @Column(name = "contenidoservicio", nullable = false)
    private String contenidoServicio;
    
    @Column(name = "costoservicio", nullable = false)
    private Double costoServicio;
    
    public Servicio() {}
    
    public Servicio(Integer idServicio, String nomServicio, String contenidoServicio, Double costoServicio) {
        this.idServicio = idServicio;
        this.nomServicio = nomServicio;
        this.contenidoServicio = contenidoServicio;
        this.costoServicio = costoServicio;
    }
    
    // Getters y Setters
    public Integer getIdServicio() {
        return idServicio;
    }
    
    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }
    
    public String getNomServicio() {
        return nomServicio;
    }
    
    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }
    
    public String getContenidoServicio() {
        return contenidoServicio;
    }
    
    public void setContenidoServicio(String contenidoServicio) {
        this.contenidoServicio = contenidoServicio;
    }
    
    public Double getCostoServicio() {
        return costoServicio;
    }
    
    public void setCostoServicio(Double costoServicio) {
        this.costoServicio = costoServicio;
    }
}