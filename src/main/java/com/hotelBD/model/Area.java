package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "area")
class Area implements Serializable {
    
    @Id
    @Column(name = "idarea")
    private Integer idArea;
    
    @Column(name = "nombrearea", nullable = false)
    private String nombreArea;
    
    // Constructores
    public Area() {}
    
    public Area(Integer idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }
    
    // Getters y Setters
    public Integer getIdArea() {
        return idArea;
    }
    
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }
    
    public String getNombreArea() {
        return nombreArea;
    }
    
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
    
    @Override
    public String toString() {
        return "Area{" +
                "idArea=" + idArea +
                ", nombreArea='" + nombreArea + '\'' +
                '}';
    }
}
