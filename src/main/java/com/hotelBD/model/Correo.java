package com.hotelBD.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "correo")
@IdClass(CorreoId.class)
public class Correo implements Serializable {
    
    @Id
    @Column(name = "cedulaper")
    private String cedulaPer;
    
    @Id
    @Column(name = "correo")
    private String correo;
    
    @ManyToOne
    @JoinColumn(name = "cedulaper", insertable = false, updatable = false)
    private Cliente cliente;
    
    public Correo() {}
    
    public Correo(String cedulaPer, String correo) {
        this.cedulaPer = cedulaPer;
        this.correo = correo;
    }
    
    // Getters y Setters
    public String getCedulaPer() {
        return cedulaPer;
    }
    
    public void setCedulaPer(String cedulaPer) {
        this.cedulaPer = cedulaPer;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

// Clase PK Compuesta
class CorreoId implements Serializable {
    private String cedulaPer;
    private String correo;
    
    public CorreoId() {}
    
    public CorreoId(String cedulaPer, String correo) {
        this.cedulaPer = cedulaPer;
        this.correo = correo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorreoId that = (CorreoId) o;
        return cedulaPer.equals(that.cedulaPer) && correo.equals(that.correo);
    }
    
    @Override
    public int hashCode() {
        return cedulaPer.hashCode() + correo.hashCode();
    }
}
