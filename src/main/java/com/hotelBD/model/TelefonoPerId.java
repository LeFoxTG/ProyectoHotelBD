package com.hotelBD.model;

import java.io.Serializable;

// Clase PK Compuesta
public class TelefonoPerId implements Serializable {
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