package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefonoper")
@IdClass(TelefonoPerId.class)
class TelefonoPer implements Serializable {
    
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

// Clase PK Compuesta
class TelefonoPerId implements Serializable {
    private String cedulaPer;
    private String telefonoPer;
    
    public TelefonoPerId() {}
    
    public TelefonoPerId(String cedulaPer, String telefonoPer) {
        this.cedulaPer = cedulaPer;
        this.telefonoPer = telefonoPer;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefonoPerId that = (TelefonoPerId) o;
        return cedulaPer.equals(that.cedulaPer) && telefonoPer.equals(that.telefonoPer);
    }
    
    @Override
    public int hashCode() {
        return cedulaPer.hashCode() + telefonoPer.hashCode();
    }
}