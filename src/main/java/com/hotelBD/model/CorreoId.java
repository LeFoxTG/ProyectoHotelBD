package com.hotelBD.model;

import java.io.Serializable;

public class CorreoId implements Serializable {
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