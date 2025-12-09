package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefonoper")
@IdClass(TelefonoPerId.class)
public class TelefonoPer implements Serializable {
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Id
    @Column(name = "telefonoper")
    private String telefonoPer;
    
    @ManyToOne
    @JoinColumn(name = "cedulaper", insertable = false, updatable = false)
    private Persona persona;
    
    public TelefonoPer() {}
    
    public TelefonoPer(String cedulaPer, String telefonoPer) {
        this.cedulaPer = cedulaPer;
        this.telefonoPer = telefonoPer;
    }
    
    // Getters y Setters
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public String getTelefonoPer() {
        return telefonoPer;
    }
    
    public void setTelefonoPer(String telefonoPer) {
        this.telefonoPer = telefonoPer;
    }
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}