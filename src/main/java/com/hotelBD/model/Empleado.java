package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Column(name = "cargo", nullable = false)
    private String cargo;
    
    @Column(name = "idarea")
    private Integer idArea;
    
    @ManyToOne
    @JoinColumn(name = "cedulaper", insertable = false, updatable = false)
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "idarea", insertable = false, updatable = false)
    private Area area;
    
    // Constructores
    public Empleado() {}
    
    public Empleado(String cedulaPer, String cargo, Integer idArea) {
        this.cedulaPer = cedulaPer;
        this.cargo = cargo;
        this.idArea = idArea;
    }
    
    // Getters y Setters
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public Integer getIdArea() {
        return idArea;
    }
    
    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Area getArea() {
        return area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
}